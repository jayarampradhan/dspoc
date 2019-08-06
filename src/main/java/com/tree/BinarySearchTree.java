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
public class BinarySearchTree {


    public static TreeNode createBSTFromSortedArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) /2;
        TreeNode node = new TreeNode(arr[mid]);
        node.setLeft(createBSTFromSortedArray(arr, start, mid -1));
        node.setRight(createBSTFromSortedArray(arr, mid + 1, end));
        return node;
    }

    public static void main (String[] args) {
//        int[] arr = {1,2,3,4,50,100,200,400,600,800};
        int[] arr = {1,2,7,11,15,29,35,40};
        final TreeNode node = createBSTFromSortedArray(arr, 0, arr.length - 1);
        //In order traversal always produce the sorted order
        TreeTraversal.printInorder(node);
    }

}
