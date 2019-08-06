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
 * Find maximum sum of the array where no two element are adjacent.
 * @author Jay
 * @since 1.0.0
 */
public class MaxSumWhenNoTwoElementAreAdjacent {

    public static void main (String[] args) {
        int[] in = {5,  5, 10, 40, 50, 35};
        System.out.println("maxSum(in) = " + maxSum(in));
    }

    static int maxSum(int[] in) {
        int maxIncluding = in[0], maxExcluding = 0;
        for (int i = 1; i < in.length; i++) {
            int tmpMax = Math.max(maxIncluding, maxExcluding);
            maxIncluding = maxExcluding + in[i];
            maxExcluding = tmpMax;
        }
        return Math.max(maxExcluding, maxExcluding);
    }
}
