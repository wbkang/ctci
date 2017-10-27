

import java.util.*;
import java.util.function.*;


public class P4_4 {
    public static void main(String[] args) {
        
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            l.add(i);
        }
        List<List<Integer>> out = new ArrayList<>();
        Node n = treefy(l);
        System.out.println(depth(n));
        System.out.println(balanced(n));
        
        Node unbalanced = 
            new Node(null,
                    1,
                    new Node(
                        new Node(null, 2, null),
                        3,
                        new Node(null, 4, null)
                    ));
        System.out.println(balanced(unbalanced));
    }
    
    static int depth(Node n) {
        if (n == null) {
            return 0;
        }
        return Math.max(depth(n.left), depth(n.right)) + 1;
    }

    static boolean balanced(Node n) {
        if (n == null) {
            return true;
        }
        return
            balanced(n.left) &&
            balanced(n.right) &&
            Math.abs(depth(n.left) - depth(n.right)) <= 1;
    }

    static Node treefy(List<Integer> lst) {
        if (lst.isEmpty()) {
            return null;
        }
        if (lst.size() == 1) {
            return new Node(null, lst.get(0), null);
        }
        int midIndex = lst.size() / 2;
        return new Node(
                treefy(lst.subList(0, midIndex)),
                lst.get(midIndex),
                treefy(lst.subList(midIndex + 1, lst.size()))
        );
    }

        
    static class Node {
        Node left;
        Node right;
        int value;
        Node(Node left, int value, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public String toString() {
            String l = left == null ? "" : left.toString();
            String r = right == null ? "" : right.toString();

            return "(" + l + " [" + value + "] " + r + ")";
        }
    }


}
