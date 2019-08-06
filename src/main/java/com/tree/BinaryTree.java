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
 * @author Jay
 * @since 1.0.0
 */
public class BinaryTree {

    // Root of Binary Tree
    TreeNode root;
    static int maxLevel = -1, data = -1;
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new TreeNode(1);

        /* following is the tree after above statement
          1
        /   \
      null  null
          */

        tree.root.setLeft(new TreeNode(2));
        tree.root.setRight(new TreeNode(3));
        tree.root.getRight().setLeft(new TreeNode(5));

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */
        tree.root.getLeft().setLeft(new TreeNode(4));
        tree.root.getLeft().getLeft().setLeft(new TreeNode(6));
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

//        TreeTraversal.printInorder(tree.root);
//        System.out.println(TreeTraversal.height(tree.root));
//        TreeTraversal.height(tree.root);
//        findDeepestNode(tree.root, 0);
//        System.out.println(data);
        TreeTraversal.printAncestors(tree.root, 6);
//        TreeTraversal.printLevelOrderUsingQue(tree.root);
//        TreeTraversal.printInorderUsingStack(tree.root);
//        TreeTraversal.printAncestors(tree.root, 5);

    }


    public static void findDeepestNode(TreeNode node, int level) {
        if (node != null) {
            level = level +1;
            findDeepestNode(node.getLeft(), level);
            if (level > maxLevel) {
                maxLevel = level;
                data = node.getKey();
            }
            findDeepestNode(node.getRight(), level);
        }
    }

}
