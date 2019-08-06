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
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children
 *
 * Approach: for any traverse, check if the root has the same data as of left + right value
 * @author Jay
 * @since 1.0.0
 */
public class CheckChildrenSumProperty {

    public static void main (String[] args) {
        TreeNode node = new TreeNode(10);
        node.setLeft(new TreeNode(8));
        node.setRight(new TreeNode(2));

        node.getLeft().setLeft(new TreeNode(3));
        node.getLeft().setRight(new TreeNode(5));

        node.getRight().setRight(new TreeNode(2));

        System.out.println(isChildrenSumProperty(node));

    }

    static boolean isChildrenSumProperty(TreeNode node) {
        int left_data = 0, right_data = 0;
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return Boolean.TRUE;
        }
        if (node.getLeft() != null) {
            left_data = node.getLeft().getKey();
        }
        if (node.getRight() != null) {
            right_data = node.getRight().getKey();
        }
        if (node.getKey() == left_data + right_data &&
                isChildrenSumProperty(node.getLeft()) &&
                isChildrenSumProperty(node.getRight())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
