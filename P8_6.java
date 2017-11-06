import java.util.*;

public class P8_6 {

    public static void main(String[] args) {
        Stack<String> from = new Stack<>();
        Stack<String> mid = new Stack<>();
        Stack<String> end = new Stack<>();

        for (int i = 0; i < 5; i++) {
            from.push(String.valueOf(5-i));
        }

        System.out.println(from);
        System.out.println(mid);
        System.out.println(end);
        hanoi(from, mid, end, 5);

        System.out.println(from);
        System.out.println(mid);
        System.out.println(end);
    }

    public static void hanoi(
            Stack<String> from,
            Stack<String> mid,
            Stack<String> dest,
            int count) {
        if (count == 0) {
            return;
        }
        if (count == 1) {
            dest.push(from.pop());
            return;
        }
        
        hanoi(from, dest, mid, count - 1);
        dest.push(from.pop());
        hanoi(mid, from, dest, count - 1);
    }

}

