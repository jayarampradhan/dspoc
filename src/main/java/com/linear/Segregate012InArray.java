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
 * Input array   =  [0, 1, 2, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2]
 *
 * Approach 1:
 * count number of 0 and 1, fill the array till count as zero and 1 respectively and remaining as 1
 *
 * Approach 2:
 * keep left and right, move left till it has zero and move right if it has 1 else exchange
 * @author Jay
 * @since 1.0.0
 */
public class Segregate012InArray {

    public static void main (String[] args) {
        int[] in = {0, 1, 2, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(approach1(in)));
        System.out.println(Arrays.toString(approach2(in)));
    }

    public static int[] approach2(int[] in) {

        int lo = 0;
        int hi = in.length - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (in[mid])
            {
                case 0:
                {
                    temp   =  in[lo];
                    in[lo]  = in[mid];
                    in[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:
                {
                    temp = in[mid];
                    in[mid] = in[hi];
                    in[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
        return in;
    }

    public static int[] approach1(int[] in) {
        int zeroCounts = 0;
        int oneCounts = 0;
        for(int i = 0; i< in.length; i++) {
            if(in[i] == 0) {
                zeroCounts++;
            } else if(in[i] == 1) {
                oneCounts++;
            }
        }
        int oneCountStartIndex = zeroCounts;
        int oneCountEndIndex = oneCountStartIndex + oneCounts;
        for (int i = 0; i < in.length; i++) {
            if(i < zeroCounts) {
                in[i] = 0;
            } else if(i < oneCountEndIndex) {
                in[i] = 1;
            } else {
                in[i] = 2;
            }
        }
        return in;
    }
}
