package com.linear;
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

import java.util.Stack;

/**
 * Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.
 * R->A->D->A->R
 * @author Jay
 * @since 1.0.0
 */
public class CheckLinkedListIsPallendrum {

    public static void main (String[] args) {

        Node root = createLinkedList(new Character[] {'R', 'A', 'D', 'A', 'R'});

        System.out.println("Is Palindrome: "+ checkPalindrome(root));

    }

    static boolean checkPalindrome(Node root) {
        Node slowPointer = root;
        Node fastPointer = root;
        boolean isPalindrome = Boolean.TRUE;
        Stack<Character> data = new Stack<>();
        while (slowPointer != null && fastPointer != null) {
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                fastPointer = null;
            }
            data.push(slowPointer.data);
            slowPointer = slowPointer.next;
        }

        if (slowPointer != null && slowPointer.data != data.peek()) {
            data.pop();
        }

        while (slowPointer != null && isPalindrome) {
            if (!data.empty() && slowPointer.data == data.pop()) {
                slowPointer = slowPointer.next;
            } else {
                isPalindrome = Boolean.FALSE;
            }
        }
        return isPalindrome && data.empty();
    }

    static Node createLinkedList(Character[] in) {
        Node root = new Node();
        Node n = root;
        for (int i = 0 ; i < in.length; i++) {
            n.data = in[i];
            if ( i+ 1 < in.length) {
                Node tmp = new Node();
                n.next = tmp;
                n = n.next;
            }
        }
        return root;
    }
    static class Node {
        private Node next;
        private Character data;

        public Node getNext () {
            return next;
        }

        public void setNext (Node next) {
            this.next = next;
        }

        public int getData () {
            return data;
        }

        public void setData (Character data) {
            this.data = data;
        }
    }

}
