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
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 * @author Jay
 * @since 1.0.0
 */
public class TreeTraverseLeftView {

    static boolean printed = Boolean.FALSE;
    public static void main (String[] args) {
        TreeNode node = new TreeNode(4);
        node.setLeft(new TreeNode(5));
        node.setRight(new TreeNode(2));

        node.getRight().setRight(new TreeNode(1));
        node.getRight().setLeft(new TreeNode(3));

        node.getRight().getLeft().setRight(new TreeNode(7));
        node.getRight().getLeft().setLeft(new TreeNode(6));
        leftView(node);

    }

    static void leftView(TreeNode node) {
        int height = height(node);
        for (int i =1 ; i<= height; i++) {
            printed = Boolean.FALSE;
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
            if(!printed) {
                System.out.print(node.getKey() + " ");
                printed = Boolean.TRUE;
            }
        } else {
            printGivenLevel(node.getLeft(), level -1);
            printGivenLevel(node.getRight(), level -1);
        }
    }

}
