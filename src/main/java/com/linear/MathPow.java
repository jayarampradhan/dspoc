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
 * Given a, b calculate the Math.pow(a,b)
 *
 * @author Jay
 * @since 1.0.0
 */
public class MathPow {

    public static void main (String[] args) {
        System.out.println(pow(2,2));
        System.out.println(pow(-2,3));
        System.out.println(pow(4,2));
    }

    private static int pow(int a, int b) {
        if (b == 0)
            return 1;

        int res = pow(a, b / 2);

        if (b % 2 == 0)
            return res * res;
        else
            if ( b > 0) {
                return a * res * res;

            } else {
                return (res * res) / a;
            }
    }

}
