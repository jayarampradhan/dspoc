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

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jay
 * @since 1.0.0
 */
public class CustomThreadPoolTest {

    @Test
    public void testPool () {
        CustomThreadPool pool = new CustomThreadPool.Builder(2)
                .withIdleTime(1000L)
                .withInitialSize(1)
                .withMaxTaskQueSize(500)
                .build();
        for (int i = 0; i < 500; i++) {
            try {
                pool.executeTask(() -> {
                    System.out.println(Thread.currentThread().getName() + " is Executing");
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        System.out.println("Exception " + e);
                    }
                });
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
        try {
            Thread.sleep(10000L);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
