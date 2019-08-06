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
 * Given a Binary Tree, check if all leaves are at same level or not.
 * @author Jay
 * @since 1.0.0
 */
public class CheckAllLeavesAreAtSameLevel {

    static int leftMostLevel = 0;

    public static void main (String[] args) {
        TreeNode node = new TreeNode(26);
        node.setLeft(new TreeNode(10));
        node.setRight(new TreeNode(3));

        node.getLeft().setLeft(new TreeNode(4));
        node.getLeft().setRight(new TreeNode(6));

        node.getRight().setRight(new TreeNode(3));
        node.getRight().setLeft(new TreeNode(9));
        System.out.println(isLeavesAtSameLevel(node, 0));
    }

    static boolean isLeavesAtSameLevel(TreeNode node, int level) {
        if (node == null) {
            return Boolean.TRUE;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            if (leftMostLevel == 0) {
                leftMostLevel = level;
            }
            if (leftMostLevel == level) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }

        return isLeavesAtSameLevel(node.getLeft(), level + 1) && isLeavesAtSameLevel(node.getRight(), level + 1);
    }



}
