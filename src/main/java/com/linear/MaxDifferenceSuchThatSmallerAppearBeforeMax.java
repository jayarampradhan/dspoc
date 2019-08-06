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
 * Maximum difference between two elements such that larger element appears after the smaller number
 * Given an array arr[] of integers, find out the maximum difference between
 * any two elements such that larger element appears after the smaller number.
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * Output : 8
 * Explanation : The maximum difference is between 10 and 2.
 *
 * Input : arr = {7, 9, 5, 6, 3, 2}
 * Output : 2
 * Explanation : The maximum difference is between 9 and 7.
 *
 * Approach: Find the difference between adjacent element first, then find the max sum of the new array
 * {2,3,10,6,4,8,1}
 * diff array = {1,7,-4,-2,4,-7}
 * output: max sum is 8
 * Time complexity O(n)
 * Space: O(1)
 * @author Jay
 * @since 1.0.0
 */
public class MaxDifferenceSuchThatSmallerAppearBeforeMax {

    public static void main (String[] args) {
        int[] in = {1,7,-4,-2,4,-7};
        System.out.println("findMaxDiff(in) = " + findMaxDiff(in));
        System.out.println("findMaxDiffApproach2(in) = " + findMaxDiffApproach2(in));
    }

    static int findMaxDiff(int[] in) {
        int maxEndingHere = in[0];
        int maxSumSoFar = maxEndingHere;
        for (int i =1; i< in.length ; i++) {
            maxEndingHere = Math.max(in[i], maxEndingHere+in[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);

        }
        return maxSumSoFar;

    }

    /**
     * works for only +ve numbers in case of -ve it won't work
     * Time: O(n)
     * Space: O(1)
     * @param in
     * @return
     */
    static int findMaxDiffApproach2(int[] in) {
        int maxDiff = in[1] - in[0];
        int minimumElm = in[0];
        for (int i = 1; i< in.length-1; i++) {
            if (in[i] - minimumElm > maxDiff) {
                maxDiff = in[i] - minimumElm;
            }
            if (in[i] < minimumElm) {
                minimumElm = in[1];
            }
        }
        return maxDiff;
    }

}
