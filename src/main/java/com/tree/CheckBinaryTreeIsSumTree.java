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
 * Write a function that returns true if the given Binary Tree is SumTree else false.
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
 * An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 * @author Jay
 * @since 1.0.0
 */
public class CheckBinaryTreeIsSumTree {

    public static void main (String[] args) {

        TreeNode node = new TreeNode(26);
        node.setLeft(new TreeNode(10));
        node.setRight(new TreeNode(3));

        node.getLeft().setLeft(new TreeNode(4));
        node.getLeft().setRight(new TreeNode(6));

        node.getRight().setRight(new TreeNode(3));

        System.out.println(isSumTree(node));
    }

    static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return sum(node.getLeft()) + node.getKey() + sum(node.getRight());
    }

    static boolean isSumTree(TreeNode node) {
        int leftData = 0;
        int rightData = 0;
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return Boolean.TRUE;
        }

        leftData = sum(node.getLeft());
        rightData = sum(node.getRight());
        if (node.getKey() == leftData + rightData && isSumTree(node.getLeft()) && isSumTree(node.getRight())) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

}
