package com.thread;
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jay
 * @since 1.0.0
 */
public class ProducerConsumerUsingLock {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main (String[] args) {
        Queue<Integer> qu = new LinkedList<Integer>();
        Thread t = new Thread(new Producer(qu,10));
        Thread t1 = new Thread(new Consumer(qu));
        t1.start();
        t.start();
        try {

            Thread.sleep(10000l);
        } catch (Exception e) {
            System.out.println("something wrong" + e);
        }
    }

    public static class Producer implements Runnable {
        private Queue<Integer> qu;
        private int maxSize;

        public Producer (Queue<Integer> qu, int maxSize) {
            this.qu = qu;
            this.maxSize = maxSize;
        }

        public void run () {
            while (true) {
                try {
                    lock.lock();
                    while (qu.size() == maxSize) {
                        System.out.println(Thread.currentThread().getName()
                                + " : Buffer is full, waiting");
                        try {
                            condition.await();
                        } catch (Exception e) {
                            System.out.println("something wrong" + e);
                        }
                    }

                    int test = new Double(Math.random()).intValue();
                    System.out.println("producing: " + test);
                    qu.offer(test);
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }

            }

        }
    }
    public static class Consumer implements Runnable {
        private Queue<Integer> qu;

        public Consumer (Queue<Integer> qu) {
            this.qu = qu;
        }

        public void run () {
            while (true) {
                try {
                    lock.lock();;
                    while (qu.isEmpty()) {
                        System.out.println("qu doesn't have any data");
                        try {
                            condition.await();
                        } catch (Exception e) {
                            System.out.println("something wrong" + e);
                        }
                    }
                    while (!qu.isEmpty()) {
                        Integer test = qu.peek();
                        System.out.println("Consumed: "+ test);
                        qu.remove();
                    }
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }

            }

        }
    }

}
