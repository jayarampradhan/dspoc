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
 * O(logn)
 *
 * @author Jay
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main (String[] args) {
        int[] in = {2, 3, 4, 10, 40, 50};
        int index = binarySearch(in, 0, in.length - 1, 50);
        System.out.println("Found index: " + index);
    }

    static int binarySearch(int[] in, int l, int r, int target) {
        if (r >= l) {
            int m = (r + l)/2;
            if(in[m] == target) {
                return m;
            }
            if (in[m] > target) {
                return binarySearch(in, l, m - 1, target);
            } else {
                return binarySearch(in, m + 1, r, target);
            }
        }
        return -1;
    }
}
