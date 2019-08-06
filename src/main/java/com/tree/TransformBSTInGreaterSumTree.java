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
 * given a BST tree
 *          11                           119
 *         / \                           /  \
 *         2  29     =>                 137  75
 *        / \ / \                       / \  /  \
 *        1 7 15 40                   139 130 104 0
 *               /                                /
 *               35                              40
 * Idea is as tree is BST, then in-order traverse will give sorted order so, reverse the in order traverse, hence we will visit the highest node
 * first then keep track of all the element and replace the value with the sum
 * Inorder L -> Root -> Right so reverse will be (Right -> root -> Left)
 * @author Jay
 * @since 1.0.0
 */
public class TransformBSTInGreaterSumTree {

    private static int sumSoFar = 0;
    public static void main (String[] args) {
        int[] arr = {1,2,7,11,15,29,35,40};
        final TreeNode node = BinarySearchTree.createBSTFromSortedArray(arr, 0, arr.length - 1);
        transform(node);
        TreeTraversal.printInorder(node);

    }

    public static void transform(TreeNode node) {
        if (node == null) {
            return;
        }
        transform(node.getRight());
        int currentVal = node.getKey();
        node.setKey(sumSoFar);
        sumSoFar += currentVal;
        transform(node.getLeft());
    }

}
