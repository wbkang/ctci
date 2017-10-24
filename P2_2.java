

import java.util.*;
import java.util.function.*;


public class P2_2 {
    public static void main(String[] args) {
        Node lst = new Node(1,
                new Node(2,
                    new Node(3,
                        new Node(4,
                            new Node(5, null)
                            )
                        )
                    )
                );
        findLastKth(lst, 1, System.out::println);
        findLastKth(lst, 2, System.out::println);
        findLastKth(lst, 3, System.out::println);
        findLastKth(lst, 4, System.out::println);
        findLastKth(lst, 5, System.out::println);
    }

    private static int findLastKth(Node n, int k, Consumer<Integer> fun) {
        if (n == null) {
            return 0;
        }
        int count = findLastKth(n.next, k, fun) + 1;
        if (count == k) {
            fun.accept(n.value);
        }
        return count;
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
