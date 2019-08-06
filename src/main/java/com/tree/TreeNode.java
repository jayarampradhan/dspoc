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
public class TreeNode {
    private int key;
    private TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }

    public int getKey () {
        return key;
    }

    public TreeNode getLeft () {
        return left;
    }

    public TreeNode getRight () {
        return right;
    }

    public void setLeft (TreeNode left) {
        this.left = left;
    }

    public void setRight (TreeNode right) {
        this.right = right;
    }

    public void setKey (int key) {
        this.key = key;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("key=").append(key);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
