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
 * find distance between two nodes, is equal to find the least common ancesstor of those two node
 * then find distance of node1 from LCA and distance of node2 from LCA and sum is the distance.
 * @author Jay
 * @since 1.0.0
 */
public class TreeFindDistanceBetweenTwoNodes {

    public static void main (String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));

        node.getLeft().setRight(new TreeNode(5));
        node.getLeft().setLeft(new TreeNode(4));

        node.getRight().setRight(new TreeNode(7));
        node.getRight().setLeft(new TreeNode(6));
        node.getRight().getLeft().setRight(new TreeNode(8));
//        node.getRight().setLeft(new TreeNode(5));
        findDistance(node);

    }
    static void findDistance(TreeNode node) {
        int n1 = 8, n2 = 5;
        TreeNode foundNode = lca(node, n1,n2);
        if (foundNode != null) {
            int n1D = findLevel(foundNode, n1, 0);
            int n2D = findLevel(foundNode, n2, 0);
            System.out.println("Distance between "+ n1 + " and "+ n2 + " is: " + (n1D + n2D));
        }
    }

    static TreeNode lca(TreeNode node, int n1, int n2) {
        if (node == null) {
            return node;
        }
        if (node.getKey() == n1 || node.getKey() == n2) {
            return node;
        }
        TreeNode left = lca(node.getLeft(), n1, n2);
        TreeNode right = lca(node.getRight(), n1, n2);

        if (left != null && right != null) {
            return node;
        } else if (left != null){
            return lca(node.getLeft(), n1, n2);
        } else {
            return lca(node.getRight(), n1, n2);
        }
    }

    static int findLevel(TreeNode node, int n, int level) {
        if (node == null) {
            return -1;
        }
        if (node.getKey() == n) {
            return level;
        }
        int left = findLevel(node.getLeft(), n, level + 1);
        if (left == -1) {
            return findLevel(node.getRight(), n, level + 1);
        }
        return left;
    }
}
