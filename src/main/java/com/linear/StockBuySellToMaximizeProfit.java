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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days.
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3.
 * Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order,
 * then profit cannot be earned at all.
 * Approach:
 * 1. Find the local minima and store it as starting index. If not exists, return.
 * 2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
 * 3. Update the solution (Increment count of buy sell pairs)
 * 4. Repeat the above steps if end is not reached.
 *
 * Time: O(n)
 * @author Jay
 * @since 1.0.0
 */
public class StockBuySellToMaximizeProfit {

    public static void main (String[] args) {
        int[] in = {100, 180, 260, 310, 40, 535, 695};
        final List<Map<String, Integer>> maxProfit = findMaxProfit(in);
        maxProfit.forEach(m -> {
            System.out.println("Buy At = " + m.get("BUY") + " actual value= "+ in[m.get("BUY")]);
            System.out.println("Sell At = " + m.get("SELL") + " actual value= "+ in[m.get("SELL")]);

        });
    }

    static List<Map<String, Integer>> findMaxProfit(int[] in) {
        int i = 0; int n = in.length -1;
        List<Map<String, Integer>> anss = new ArrayList<>();
        while (i < n) {
            while (i < n && in[i+1] <= in[i]) {
                i++;
            }
            if (i == n)
                break;
            Map<String, Integer> m = new HashMap<>();
            m.put("BUY", i++);
            while (i < n && in[i-1] <= in[i]) {
                i++;
            }
            m.put("SELL", i - 1);
            anss.add(m);
        }
        return anss;
    }
}
