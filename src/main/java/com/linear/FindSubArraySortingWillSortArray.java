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
 * For a given array, idea is to traverse from left to right and find index where mismatch happens, and from right to left index where missmatch happen
 * then from those index find minimum and max element and then check the minimum in left part and maximum in right part then change the index
 * @author Jay
 * @since 1.0.0
 */
public class FindSubArraySortingWillSortArray {

    public static void main (String[] args) {
        int[] input = {10,20,30,6,40,60,70,80};
        int startIndex = 0, endIndex= 0;
        for (int i =0; i< input.length-1; i++) {
            if (input[i] > input[i+1]) {
                startIndex = i;
            }
        }
        for (int i =input.length-1; i > 0; i--) {
            if (input[i] < input[i-1]) {
                endIndex = i;
            }
        }
        System.out.println("start Index:" + startIndex + " endIndex: "+ endIndex);
        int max = input[startIndex];
        int min = input[startIndex];
        for(int i = startIndex + 1; i <= endIndex; i++) {
            if(input[i] > max) {
                max = input[i];
            }
            if(input[i] < min) {
                min = input[i];
            }

        }
        for(int i = 0; i< startIndex; i++) {
            if(input[i] > min) {
                startIndex = i;
                break;
            }
        }
        for(int i = input.length-1; i >= endIndex+1; i--) {
            if(input[i] < max) {
                endIndex = i;
                break;
            }
        }
        System.out.println("start Index:" + startIndex + " endIndex: "+ endIndex);
    }

}
