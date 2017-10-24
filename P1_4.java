
import java.util.*;
import java.util.function.*;


public class P1_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        // ignore empty space; totally not obvious from the problem
        str = str.toLowerCase().replace(" ", "");

        // if element exists, odd, otherwise, even.
        Set<Character> set = new HashSet();
        
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }

        boolean answer;
        if (str.length() % 2 == 0) {
            // even length, the set should be empty
            answer = set.isEmpty();
        }
        else {
            // odd length, the set should have a single elem
            answer = set.size() == 1;
        }

        System.out.println(answer);


    }

    
}
