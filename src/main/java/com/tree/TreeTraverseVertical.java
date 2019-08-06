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
 * Traverse a tree in vertical order.
 * @author Jay
 * @since 1.0.0
 */
public class TreeTraverseVertical {

    static class MinMax {
        int min = 0;
        int max = 0;
    }

    public static void main (String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));

        node.getLeft().setLeft(new TreeNode(4));
        node.getLeft().setRight(new TreeNode(5));

        node.getRight().setRight(new TreeNode(7));
        node.getRight().setLeft(new TreeNode(6));

        node.getRight().getLeft().setRight(new TreeNode(8));
        node.getRight().getRight().setRight(new TreeNode(9));

        verticalOrderTraverse(node);
    }

    static void verticalOrderTraverse(TreeNode node) {
        MinMax val = new MinMax();
        determineHDDistance(node, val, 0);
        for (int line_no = val.min; line_no <= val.max; line_no++)
        {
            printVertical(node, line_no, 0);
            System.out.println("");
        }
    }

    static void determineHDDistance(TreeNode node, MinMax minMax, int hd) {
        if (node == null) {
            return;
        }
        if (hd < minMax.min) {
            minMax.min = hd;
        }
        if (hd > minMax.max) {
            minMax.max = hd;
        }

        determineHDDistance(node.getLeft(), minMax, hd - 1);
        determineHDDistance(node.getRight(), minMax, hd + 1);

    }

    static void printVertical(TreeNode node, int lineNum, int hd) {
        if (node == null) {
            return;
        }
        if (lineNum == hd) {
            System.out.print(node.getKey() + " ");
        }
        printVertical(node.getLeft(), lineNum, hd - 1);
        printVertical(node.getRight(), lineNum, hd + 1);
    }

}
