

import java.util.*;
import java.util.function.*;


public class P2_6 {
    public static void main(String[] args) {
        Node lst = list(1,2,3,4,5,4,3,2,1);
        Node lst2 = list(1,2);
        // print(lst);
        // print(reverse(lst, null));

        System.out.println(eq(lst, reverse(lst, null)));
        System.out.println(eq(lst2, reverse(lst2, null)));
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
    
    static Node reverse(Node n, Node prev) {
        if (n == null) {
            return prev;
        }
        else {
            return reverse(n.next, new Node(n.value, prev));
        }
    }

    static boolean eq(Node a, Node b) {
        if (a == null ^ b == null)
            return false;
        else if (a == null) 
            return true;
        else
            return a.value == b.value;
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
