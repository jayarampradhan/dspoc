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

/**
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)
 *
 * A node x is there in output if x is the topmost node at its horizontal distance.
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
 * and that of right child is horizontal distance of x plus 1.
 * @author Jay
 * @since 1.0.0
 */
public class TreeTraverseTopView {

    static boolean printed = Boolean.FALSE;

    static class MinMax {
        int min = 0;
        int max = 0;
    }

    public static void main (String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));

        node.getLeft().setRight(new TreeNode(5));
        node.getLeft().setLeft(new TreeNode(4));

        node.getRight().setRight(new TreeNode(7));
        node.getRight().setLeft(new TreeNode(6));

        node.getRight().getRight().setRight(new TreeNode(14));
        verticalTraverse(node);
    }

    static void verticalTraverse(TreeNode node) {
        MinMax minMax = new MinMax();
        determineHDDistance(node, minMax, 0);
        for (int i = minMax.min; i <= minMax.max; i++) {
            printVertical(node, i, 0);
            printed = Boolean.FALSE;
        }
    }

    static void determineHDDistance(TreeNode node, MinMax minMax, int hd) {
        if (node == null) {
            return;
        }
        if (hd < minMax.min) {
            minMax.min = hd;
        }
        if (hd > minMax.max) {
            minMax.max = hd;
        }

        determineHDDistance(node.getLeft(), minMax, hd -1);
        determineHDDistance(node.getRight(), minMax, hd +1);
    }

    static void printVertical(TreeNode node, int lineNum, int hd) {
        if(node == null) {
            return;
        }
        if (hd == lineNum) {
            if (!printed) {
                System.out.println(node.getKey() + " ");
                printed = Boolean.TRUE;
            }
        }
        printVertical(node.getLeft(), lineNum, hd - 1);
        printVertical(node.getRight(), lineNum, hd + 1);
    }

}
