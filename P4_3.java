

import java.util.*;
import java.util.function.*;


public class P4_3 {
    public static void main(String[] args) {
        
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            l.add(i);
        }
        List<List<Integer>> out = new ArrayList<>();
        depths(treefy(l), 0, out);
        System.out.println(out);

    }
    
    static void depths(Node n, int curDepth, List<List<Integer>> out) {
        if (n == null) {
            return;
        }
        List<Integer> curList;
        if (curDepth > out.size() - 1) {
            curList = new ArrayList<>();
            out.add(curList);
        }
        else {
            curList = out.get(curDepth);
        }
        System.err.println("Depth " + curDepth + " and value is " + n.value);
        curList.add(n.value);
        depths(n.left, curDepth + 1, out);
        depths(n.right, curDepth + 1, out);
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
