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

import java.util.HashMap;
import java.util.Map;

/**
 * For a given tree find the appropriate element till which the path needs to be reversed.
 * approach: find the path and store in the map level wise, which will help in doing the replacements.
 *
 * @author Jay
 * @since 1.0.0
 */
public class ReverseTreePath {

    static int pathPos = 0;
    public static void main (String[] args) {
        int[] in = {1,2,3,4,5,6};
        TreeNode node = BinarySearchTree.createBSTFromSortedArray(in, 0, in.length -1);
        TreeTraversal.printLevelOrder(node);
        System.out.println("");
        findAndreversePath(node, new HashMap<>(), 0, 4);
        TreeTraversal.printLevelOrder(node);

    }

    static TreeNode findAndreversePath(TreeNode node, Map<Integer, Integer> pathStore, int pathLevel, int target) {
        if (node == null) {
            return null;
        }
        if (node.getKey() == target) {
            pathStore.put(pathLevel, node.getKey());
            node.setKey(pathStore.get(pathPos));
            pathPos++;
            return node;
        }
        pathStore.put(pathLevel, node.getKey());
        TreeNode left; TreeNode right = null;
        left = findAndreversePath(node.getLeft(), pathStore, pathLevel + 1, target);
        if (left == null) {
            right = findAndreversePath(node.getRight(), pathStore, pathLevel + 1, target);
        }
        if (left == null && right == null) {
            //No path found for the given key
            return null;
        }
        TreeNode tmpNode = left == null ? right : left;
        node.setKey(pathStore.get(pathPos));
        pathPos++;
        return tmpNode;
    }
}
