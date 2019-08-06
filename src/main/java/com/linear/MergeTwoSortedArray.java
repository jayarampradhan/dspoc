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

/**
 * @author Jay
 * @since 1.0.0
 */
public class MergeTwoSortedArray {

    static int[] merge(int[] in, int[] in1) {
        int n = in.length + in1.length;
        int[] in2 = new int[n];
        int i = 0,j = 0,k=0;
        while (i < in.length && j < in1.length) {
            if (in[i] < in1[j]) {
                in2[k] = in[i];
                i++;
            } else {
                in2[k] = in1[j];
                j++;
            }
            k++;
        }
        while (i < in.length) {
            in2[k] = in[i];
            i++;
            k++;
        }
        while (j < in1.length) {
            in2[k] = in1[j];
            j++;
            k++;
        }
        return in2;
    }

    public static void main (String[] args) {
        int[] n1 = {1,2,60,80,90};
        int[] n2 = {6,7,8,9,100};
        int[] n3 = merge(n1, n2);
        System.out.println("Before Merge: "+ Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println("After Merge: "+ Arrays.toString(n3));
    }

}
