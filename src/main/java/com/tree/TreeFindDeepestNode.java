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
 * Find the deepest node of the tree.
 * deepest is last node of the tree
 *
 * @author Jay
 * @since 1.0.0
 */
public class TreeFindDeepestNode {

    static int maxLevel = 0;
    static int data;

    public static void main (String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));

        node.getLeft().setRight(new TreeNode(6));
        node.getLeft().setLeft(new TreeNode(7));

        node.getRight().setRight(new TreeNode(4));
//        node.getRight().getRight().setRight(new TreeNode(4));
//        node.getRight().setLeft(new TreeNode(5));
        approach1(node, 0);
        System.out.println("maxLevel = " + maxLevel + " and found data: "+ data);
        approach2(node);
    }

    static void approach2(TreeNode node) {
        //find the level, then find the nodes in that level
        int height = height(node);
        printGivenLevel(node, height);

    }

    static int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int lHeight = height(node.getLeft());
        int rHeight = height(node.getRight());
        return Math.max(lHeight, rHeight) + 1;
    }

    static void printGivenLevel(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(level == 1) {
            System.out.print(node.getKey() + " ");
        } else {
            printGivenLevel(node.getLeft(), level -1);
            printGivenLevel(node.getRight(), level -1);
        }
    }

    static void approach1(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        level = level + 1;
        approach1(node.getLeft(), level);
        if(level > maxLevel) {
            maxLevel = level;
            data = node.getKey();
        }
        approach1(node.getRight(), level);
    }
}
