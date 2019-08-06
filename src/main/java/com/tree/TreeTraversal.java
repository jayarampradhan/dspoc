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
import java.util.Stack;

/**
 *
 * (a) DFS: Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) DFS: Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) DFS: Postorder (Left, Right, Root) : 4 5 2 3 1
 * (d) BFS i.e level order
 * @author Jay
 * @since 1.0.0
 */
public class TreeTraversal {

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    public static void printPostorder(TreeNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.getLeft());

        // then recur on right subtree
        printPostorder(node.getRight());

        // now deal with the node
        System.out.print(node.getKey() + " ");
    }

    public static void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.getLeft());

        /* then print the data of node */
        System.out.print(node.getKey() + " ");

        /* now recur on right child */
        printInorder(node.getRight());
    }

    public static void printInorderUsingStack(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = node;
        while (current != null || stack.size() > 0) {
            //End of this while will have current as null
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.print(current.getKey() + " ");
            //Now process its right node
            current = current.getRight();
        }

    }

    public static void printPreorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.getKey() + " ");

        /* then recur on left sutree */
        printPreorder(node.getLeft());

        /* now recur on right subtree */
        printPreorder(node.getRight());
    }


    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public static int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }


    /* Print nodes at the given level
    * Can be used for the printing the element in k th distance
    * */
    public static void printGivenLevel (TreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getKey() + " ");
        else if (level > 1)
        {
            printGivenLevel(root.getLeft(), level-1);
            printGivenLevel(root.getRight(), level-1);
        }
    }

    /* function to print level order traversal of tree*/
    public static void printLevelOrder(TreeNode root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    public static void printLevelOrderUsingQue(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.getKey() + " ");

            /*Enqueue left child */
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            /*Enqueue right child */
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }

    public static void printMaxWidthUsingLevelOrderUsingQue(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int maxwidth = 0;
        while (!queue.isEmpty())
        {

            int count = queue.size();
            // Update the maximum node count value
            maxwidth = Math.max(maxwidth, count);
            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            TreeNode tempNode = queue.poll();

            /*Enqueue left child */
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            /*Enqueue right child */
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        System.out.print(maxwidth + " ");
    }

    public static boolean printAncestors(TreeNode node, int target) {
        if (node == null) {
            return Boolean.FALSE;
        }
        if (node.getKey() == target) {
            return Boolean.TRUE;
        }
        if (printAncestors(node.getLeft(), target) || printAncestors(node.getRight(), target)) {
            System.out.print(node.getKey() + " ");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /* A utility function to check whether trees with roots as root1 and
       root2 are identical or not */
    public static boolean areIdentical(TreeNode root1, TreeNode root2) {

        /* base cases */
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.getKey() == root2.getKey()
                && areIdentical(root1.getLeft(), root2.getLeft())
                && areIdentical(root1.getRight(), root2.getRight()));
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    public static boolean isSubtree(TreeNode T, TreeNode S)
    {
        /* base cases */
        if (S == null)
            return true;

        if (T == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(T, S))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.getLeft(), S)
                || isSubtree(T.getRight(), S);
    }

    public static void printAllLeafNode(TreeNode node) {
        if(node == null) {
            return;
        }
        printAllLeafNode(node.getLeft());
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.print(node.getKey() + " ");
        }
        printAllLeafNode(node.getRight());
    }

    public static boolean isMirror(TreeNode node, TreeNode anotherNode) {
        if (node == null && anotherNode == null) {
            return Boolean.TRUE;
        } else if (node == null || anotherNode == null) {
            return Boolean.FALSE;
        }
        return node.getKey() == anotherNode.getKey() && isMirror(node.getLeft(), anotherNode.getRight()) && isMirror(node.getRight(), anotherNode.getLeft());
    }



}
