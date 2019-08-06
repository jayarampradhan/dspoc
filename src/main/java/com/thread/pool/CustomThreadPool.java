package com.thread.pool;
/*
 ******************************************************************************
 * Copyright (c) 2019 Uimirror.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Uimirror license
 * which accompanies this distribution, and is available at
 * http://www.uimirror.com/legal
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Uimirror Team
 ******************************************************************************
 */

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * It will serve the purpose of the general thread pool concept.
 * @author Jay
 * @since 1.0.0
 */
public class CustomThreadPool {
    private BlockingQueue<Runnable> tasks;
    private boolean isTerminating = Boolean.FALSE;
    private long idleTime;
    private int initialSize;
    private int maxThreadSize;
    private List<Thread> threads = new LinkedList<>();
    private List<Runnable> waitingTasks;
    private int maxTaskQueueSize;
    private Lock moveWaitingTaskLock = new ReentrantLock(Boolean.TRUE);

    public void executeTask(Runnable runnable) {
        if (this.tasks.size() < (this.initialSize + this.maxThreadSize)) {
            this.tasks.add(runnable);
        } else {
            if (this.waitingTasks.size() < this.maxTaskQueueSize) {
                this.waitingTasks.add(runnable);
            } else {
                throw new RuntimeException("Task Rejection");
            }
        }
        resizeMaxThread();
    }

    private void resizeMaxThread() {
        if (this.tasks.size() > this.initialSize && this.threads.size() < (this.initialSize + this.maxThreadSize)) {
            int newSizeToBeAdded = this.tasks.size() - this.initialSize;
            for (int i = 0; i < newSizeToBeAdded; i++) {
                Thread thread = new CustomThread(new CustomRunnable(this.tasks, this));
                thread.setName(String.format("Custom-pool-%d", i + this.threads.size()));
                thread.start();
                threads.add(thread);
            }
        }
    }

    private void removeUnUsedThread() {
        if (this.tasks.size() < this.initialSize && this.threads.size() > this.initialSize) {
            int toBeRemovedCount = this.threads.size() - this.initialSize;
            int i = 0;
            while (toBeRemovedCount > 0 && i < this.threads.size()) {
                final Iterator<Thread> threadIterator = this.threads.iterator();
                while (threadIterator.hasNext()) {
                    final CustomThread thread = (CustomThread)threadIterator.next();
                    CustomRunnable runnable = (CustomRunnable)thread.getTarget();
                    if (runnable.isExpired()) {
                        threadIterator.remove();
                    }
                }
            }
        }
    }

    private void replaceJobFromWaitingToExecute() {
        if(this.waitingTasks.size() <= 0) {
            return;
        }
        boolean isLocked = moveWaitingTaskLock.tryLock();
        if (isLocked) {
            try {
                final Iterator<Runnable> runnableIterator = waitingTasks.iterator();
                while (this.tasks.size() < (this.initialSize + this.maxThreadSize) && runnableIterator.hasNext()) {
                    this.tasks.add(runnableIterator.next());
                    runnableIterator.remove();
                }
            } finally {
                moveWaitingTaskLock.unlock();
            }
        }

    }

    private void setUp(){
        this.waitingTasks = new LinkedList<>();
        for(int i = 0; i < initialSize; i++) {
            Thread thread = new CustomThread(new CustomRunnable(this.tasks, this));
            thread.setName(String.format("Custom-pool-%d", i));
            thread.start();
            threads.add(thread);
        }
        new Thread(() -> {
            this.removeUnUsedThread();
            try {
                Thread.sleep(this.idleTime);
            } catch (Exception e) {
                System.out.println("Something wrong " + e);
            }
        }).start();
    }

    public static class Builder {
        private BlockingQueue<Runnable> tasks;
        private int maxThreadSize;
        //In case tasks are already executed by all the available threads, then maximum tasks can be in que
        private int maxTaskQueueSize;
        private long idleTime;
        private int initialSize;

        public Builder(int size) {
            this.maxThreadSize = size;
        }
        public Builder withMaxTaskQueSize(int size) {
            this.maxTaskQueueSize = size;
            return this;
        }
        public Builder withIdleTime(long idleTime) {
            this.idleTime = idleTime;
            return this;
        }
        public Builder withInitialSize(int size) {
            this.initialSize = size;
            return this;
        }

        public CustomThreadPool build() {
            CustomThreadPool pool = new CustomThreadPool();
            pool.tasks = new LinkedBlockingQueue<>(this.maxThreadSize + this.maxTaskQueueSize);
            pool.idleTime = this.idleTime;
            pool.initialSize = this.initialSize;
            pool.maxTaskQueueSize = this.maxTaskQueueSize;
            pool.maxThreadSize = this.maxThreadSize;
            pool.setUp();
            return pool;
        }


    }

    public static class CustomThread extends Thread {
        private Runnable target;
        public CustomThread(Runnable target) {
            super(target);
        }

        public Runnable getTarget () {
            return target;
        }
    }

    public static class CustomRunnable implements Runnable {

        private final BlockingQueue<Runnable> tasks;
        private final CustomThreadPool pool;
        private long idleStartTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        private boolean isExecuting;

        public CustomRunnable (BlockingQueue<Runnable> tasks, CustomThreadPool pool) {
            this.tasks = tasks;
            this.pool = pool;
        }

        @Override
        public void run () {
            while (!pool.isTerminating) {
                try {
                    Runnable run = tasks.poll();
                    if (run != null) {
                        isExecuting = Boolean.TRUE;
                        run.run();
                        idleStartTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                        isExecuting = Boolean.FALSE;
                    } else {
                        //there might be situations like when the actual queue is empty but jobs are waiting in the waiting queue
                        pool.replaceJobFromWaitingToExecute();
                    }
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " has encountered exception = " + e);
                }
            }
        }

        public long getIdleStartTime () {
            return idleStartTime;
        }

        public boolean isExpired () {
            if (!isExecuting) {
                if (LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) - idleStartTime >= pool.idleTime) {
                    return Boolean.TRUE;
                }
            }

            return Boolean.FALSE;
        }
    }

}
