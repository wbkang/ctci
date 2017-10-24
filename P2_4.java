

import java.util.*;
import java.util.function.*;


public class P2_4 {
    public static void main(String[] args) {
        Node lst = list(3,5,8,5,10,2,1);
        print(lst);
        print(partition(lst, 5));
    }

    private static Node list(int... array) {
        Node n = null;
        for (int i = array.length - 1; i >= 0; i--) {
            n = new Node(array[i], n);
        }
        return n;
    }

    private static void print(Node n) {
        if (n == null) {
            System.out.println();
        }
        else {
            System.out.print(n.value + " ");
            print(n.next);
        }
    }

    private static Node partition(Node lst, int x) {
        Node lhs = null;
        Node lastLhs = null;
        Node rhs = null;
        
        Node cur = lst;
        while (cur != null) {
            if (cur.value < x) {
                // append to lhs
                if (lhs == null) {
                    lhs = new Node(cur.value, null);
                    lastLhs = lhs;
                }
                else {
                    lhs = new Node(cur.value, lhs);
                }
            }
            else {
                rhs = new Node(cur.value, rhs);
            }
            cur = cur.next;
        }

        if (lastLhs != null) 
            lastLhs.next = rhs;
        
        return  lhs == null ? rhs : lhs; 
    }

    static class Node {
        Node next;
        int value;
        Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }
}
