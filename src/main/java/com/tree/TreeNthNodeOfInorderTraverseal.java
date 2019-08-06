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
 * For a given a tree print the nth node of the tree when doing in-order traverse.
 * Traverse: L -> Root-> Right
 * @author Jay
 * @since 1.0.0
 */
public class TreeNthNodeOfInorderTraverseal {

    static int count = 0;
    public static void main (String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9,10};
        final TreeNode tree = BinarySearchTree.createBSTFromSortedArray(in, 0, in.length - 1);
        TreeTraversal.printInorder(tree);
        inorderTraverse(tree, 4);

    }

    static void inorderTraverse(TreeNode node, int nthNode) {
        if (node == null) {
            return;
        }
        if(count <= nthNode) {
            inorderTraverse(node.getLeft(), nthNode);
            count++;
            if (count == nthNode) {
                System.out.println(node.getKey());
            }
            inorderTraverse(node.getRight(), nthNode);
        }
    }

}
