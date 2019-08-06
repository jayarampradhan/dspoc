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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array arr[] of N integers and an integer S.
 * The task is to find an element K in the array such that if all the elements from the array > K are made equal to
 * K then the sum of all the elements of the resultant array becomes equal to S.
 * If it is not possible to find such an element then print -1
 * nput: M = 15, arr[] = {12, 3, 6, 7, 8}
 * Output: 3
 * Resultant array = {3, 3, 3, 3, 3}
 * Sum of the array elements = 15 = S
 *
 * Input: M = 5, arr[] = {1, 3, 2, 5, 8}
 * Output: 1
 * Approach: 1- sort it
 *          2- for each index check if (sum + arr[i]*n-i) then thats the elemnt else -1
 * @author Jay
 * @since 1.0.0
 */
public class ArrayManipulationSum {

    public static void main (String[] args) {
        int[] input = {12, 3, 6, 7, 8};

        System.out.println(findElement(input, 15));

        System.out.println(Math.pow(-2,2));
    }

    static boolean isProcessed(Integer a) {
        return Boolean.FALSE;
    }

    public static int findElement(int[] in, int target) {
        Arrays.sort(in);
        int rs = -1;
        int sum = 0;
        for (int i =0; i< in.length; i++) {
            if (sum + (in[i] * in.length -i) == target) {
                rs = in[i];
                break;
            } else {
                sum += in[i];
            }
        }
        return rs;
    }
}
