package com.tree;
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * for a given tree traverse in the reverse order.
 *
 * @author Jay
 * @since 1.0.0
 */
public class ReverseLevelOrderTraverse {

    public static void main (String[] args) {
        int[] in = {1,2,3,4};
        TreeNode node = BinarySearchTree.createBSTFromSortedArray(in, 0, in.length - 1);
        TreeTraversal.printLevelOrder(node);
        System.out.println("");
        approach1(node);
        System.out.println("");
        System.out.println("Approach 2");
        TreeTraversal.printLevelOrderUsingQue(node);
        System.out.println("");
        System.out.println("Approach 2 new");
        approach2(node);
    }

    static void approach2(TreeNode node) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(node);
        Stack<Integer> data = new Stack<Integer>();
        while (!qu.isEmpty()) {
            TreeNode tmpNode = qu.poll();

            data.push(tmpNode.getKey());
            if (tmpNode.getRight() != null) {
                qu.add(tmpNode.getRight());
            }
            if (tmpNode.getLeft() != null) {
                qu.add(tmpNode.getLeft());
            }
        }
        while (!data.empty()) {
            System.out.print(data.pop() + " ");
        }
    }

    static void approach1(TreeNode node) {
        //Step 1 find the height of the tree
        int height = height(node);
        for (int i = height; i >= 1; i--) {
            printGivenLevel(node, i);
        }
    }

    static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHeight = height(node.getLeft());
        int rHeight = height(node.getRight());
        return Math.max(lHeight, rHeight) + 1;
    }

    static void printGivenLevel(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getKey() + " ");
        } else {
            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);
        }
    }
}
