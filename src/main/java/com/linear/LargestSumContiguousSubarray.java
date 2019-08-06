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
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * @author Jay
 * @since 1.0.0
 */
public class LargestSumContiguousSubarray {

    static int findMaxSum(int[] in) {
        int sumEndingHere = 0, maxSumSoFar = 0;

        for (int i = 0; i< in.length; i++) {
            sumEndingHere += in[i];
            if (sumEndingHere < 0) {
                sumEndingHere = 0;
            }
            if (maxSumSoFar < sumEndingHere) {
                maxSumSoFar = sumEndingHere;
            }
        }

        return maxSumSoFar;
    }

    /**
     * Works for the -ve number as well
     * [-2,1,-3,4,-1,2,1,-5,4]
     * @param in
     * @return
     */
    static int findMaxSumApproach2(int[] in) {
        int maxEndingHere = in[0];
        int maxSumSoFar = maxEndingHere;
        for (int i =1; i< in.length ; i++) {
            maxEndingHere = Math.max(in[i], maxEndingHere+in[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);

        }
        return maxSumSoFar;
    }



    public static void main (String[] args) {
        int[] in = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("findMaxSum(in) = " + findMaxSum(in));
        System.out.println("findMaxSumApproach2(in) = " + findMaxSumApproach2(in));
    }
}
