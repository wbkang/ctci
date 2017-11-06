import java.util.*;

public class P8_7 {

    public static void main(String[] args) {
        System.out.println(permutation(args[0], ""));    
    }
    
    public static Set<String> permutation(String remainder, String prefix) {
        Set<String> result = new HashSet<>();
        if (remainder.length() == 0) {
            return result;
        }
        if (remainder.length() == 1) {
            result.add(prefix + remainder);
            return result;
        }

        for (int i = 0; i < remainder.length(); i++) {
            String nextPrefix = prefix + remainder.charAt(i);
            String nextRemainder = 
                remainder.substring(0, i) + remainder.substring(i + 1);
            result.addAll(permutation(nextRemainder, nextPrefix));
        }
        return result;
    }
}

