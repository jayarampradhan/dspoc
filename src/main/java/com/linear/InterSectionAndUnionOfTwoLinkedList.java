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

import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 *    List1: 10 -> 15 -> 4 -> 20
 *    list2:  8 -> 4 -> 2 -> 10
 * Output:
 *    Intersection List: 4 -> 10
 *    Union List: 2 -> 8 -> 20 -> 4 -> 15 -> 10
 *
 * Idea:
 * is to store the lists into hashMap and print all the keys for union and
 * when keys occurrence is more than 1 then that's the intersection
 *
 * @author Jay
 * @since 1.0.0
 */
public class InterSectionAndUnionOfTwoLinkedList {

    public static void main (String[] args) {
        Node linkedList = createLinkedList(new int[] {1,2,3,4,5,6});
        Node linkedList2 = createLinkedList(new int[] {2,4,10});
        show(linkedList);
        show(linkedList2);

        Map<Integer, Integer> hash = new HashMap<>();
        populateMap(linkedList, linkedList2, hash);
        System.out.println("Union-->");
        show(getUnion(hash));
        System.out.println("Intersection-->");
        show(getIntersection(hash));
    }

    static Node getIntersection(Map<Integer, Integer> hash) {
        return createLinkedList(hash.keySet().stream().filter(k -> hash.get(k) > 1).mapToInt(Integer::intValue).toArray());
    }

    static Node getUnion(Map<Integer, Integer> hash) {
        return createLinkedList(hash.keySet().stream().mapToInt(Integer::intValue).toArray());
    }

    static void populateMap(Node linkedList, Node linkedList2, Map<Integer, Integer> hash) {
        Node tmp = linkedList;
        Node tmp2 = linkedList2;

        while (tmp != null || tmp2 != null) {
            if (tmp != null) {
                hash.put(tmp.data, hash.getOrDefault(tmp.data, 0) + 1);
                tmp = tmp.next;
            }
            if (tmp2 != null) {
                hash.put(tmp2.data, hash.getOrDefault(tmp2.data, 0) + 1);
                tmp2 = tmp2.next;
            }
        }
    }

    static void show(Node linkedList) {
        Node tmp = linkedList;
        while (tmp != null) {
            if (tmp.next == null) {
                System.out.print(tmp.data);
            } else {
                System.out.print(tmp.data + "->");
            }
            tmp = tmp.next;
        }
        System.out.println("");
    }

    static Node createLinkedList(int[] in) {
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
        private int data;

        public Node getNext () {
            return next;
        }

        public void setNext (Node next) {
            this.next = next;
        }

        public int getData () {
            return data;
        }

        public void setData (int data) {
            this.data = data;
        }
    }
}
