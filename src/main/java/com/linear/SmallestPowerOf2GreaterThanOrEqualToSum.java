package com.linear;
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

/**
 * Given an array of N numbers where values of the array represent memory sizes.
 * The memory that is required by the system can only be represented in powers of 2.
 * The task is to return the size of the memory required by the system.
 * Input: a[] = {2, 1, 4, 5}
 * Output: 16
 * The sum of memory required is 12,
 * hence the nearest power of 2 is 16.
 *
 * Input: a[] = {1, 2, 3, 2}
 * Output: 8
 * @author Jay
 * @since 1.0.0
 */
public class SmallestPowerOf2GreaterThanOrEqualToSum {

    public static void main (String[] args) {
        int[] in = {2, 1, 4, 5};
        int sum = 0;
        for(int i : in) {
            sum+=i;
        }

        int nextPow = nextPowerOf2(sum);
        System.out.println(nextPow);

    }

    public static int nextPowerOf2(int num) {
        if (num == 0) {
            return num;
        }
        if(isPowerOf2(num)) {
            return num;
        }
        int p = 1;
        while (p < num) {
            //left shift makes power of 2 for +ve number
            p <<=1 ;
        }
        return p;

    }

    public static boolean isPowerOf2(int num) {
        while (num != 1) {
            if (num%2 != 0) {
                return Boolean.FALSE;
            }
            num = num /2;
        }
        return Boolean.TRUE;
    }
}
