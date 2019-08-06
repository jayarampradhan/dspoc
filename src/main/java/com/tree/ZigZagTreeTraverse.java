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

/**
 * @author Jay
 * @since 1.0.0
 */
public class ZigZagTreeTraverse {
    public static void main (String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));

        node.getLeft().setRight(new TreeNode(6));
        node.getLeft().setLeft(new TreeNode(7));

        node.getRight().setRight(new TreeNode(4));
        node.getRight().setLeft(new TreeNode(5));

//        node.getRight().getRight().setRight(new TreeNode(14));
        printLevelOrder(node);
        System.out.println("");
        approach2(node);
    }

    static void printLevelOrder(TreeNode node) {
        int height = height(node);
        for (int i =1 ; i<= height;i++) {
            if (i %2 == 0) {
                printGivenLevel(node, i, Boolean.TRUE);
            } else {
                printGivenLevel(node, i, Boolean.FALSE);
            }
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

    static void printGivenLevel(TreeNode node, int level, boolean flip) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getKey() + " ");
        }
        if (flip) {
            printGivenLevel(node.getRight(), level -1, flip);
            printGivenLevel(node.getLeft(), level -1, flip);
        } else {
            printGivenLevel(node.getLeft(), level -1, flip);
            printGivenLevel(node.getRight(), level -1, flip);
        }
    }

    static void approach2(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(node);

        while (!qu.isEmpty()) {
            TreeNode cur = qu.poll();
            System.out.print(cur.getKey() + " ");
            if(cur.getLeft() != null) {
                qu.add(cur.getLeft());
            }
            if(cur.getRight() != null) {
                qu.add(cur.getRight());
            }
        }
    }

}
