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
 * O(nlogn)
 * @author Jay
 * @since 1.0.0
 */
public class MergeSortCustom {

    static void merge(int[] in, int l, int r, int m) {
        int n1 = m - l +1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = in[l+i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = in[m +1 + j];
        }
        //copy back to the actual array
        int i = 0, j =0;
        int k = l;
        while (i < n1 && j < n2) {
            if(L[i] < R[j]) {
                in[k] = L[i];
                i++;
            } else {
                in[k] = R[j];
                j++;
            }
            k++;
        }
        //Copy remaining elements
        while (i < n1) {
            in[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            in[k] = R[j];
            k++;
            j++;
        }

    }

    static void sort(int[] in, int l, int r) {
        if (r > l) {
            int m = (l+r)/2;
            sort(in, l, m);
            sort(in, m+1, r);
            merge(in, l, r, m);
        }
    }

    public static void main (String[] args) {
        int[] input = {80,10,90,40,20,100};
        sort(input, 0, input.length -1);
        System.out.println("After sorting = " + Arrays.toString(input));
    }
}
