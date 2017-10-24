
import java.util.*;
import java.util.function.*;


public class P1_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String from = input.nextLine();
        String to = input.nextLine();
        
        System.out.println(checkEdit(from, to));
    }

    private static boolean checkEdit(String from, String to) {
        int fromLength = from.length();
        int toLength = to.length();
        
        if (fromLength + 1 == toLength) {
            // 1 addition
            return checkAddition(from, to);
        }
        else if (fromLength == toLength) {
            // 1 replacement
            return checkReplacement(from, to);
        }
        else if (fromLength - 1 == toLength) {
            // check 1 deletion
            return checkAddition(to, from);
        }
        else {
            return false;
        }
    }

    private static boolean checkAddition(String from, String to) {
        for (int fromCounter = 0, toCounter = 0, diffCount = 0;
                fromCounter < from.length() && toCounter < to.length();) {
            char f = from.charAt(fromCounter);
            char t = to.charAt(toCounter);
            if (f == t) {
                fromCounter++;
                toCounter++;
            }
            else {
                toCounter++;
                if (++diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean checkReplacement(String from, String to) {
        for (int i = 0, diffCount = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                if (++diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
