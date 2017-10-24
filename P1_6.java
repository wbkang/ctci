
import java.util.*;
import java.util.function.*;


public class P1_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        
        System.out.println(new Compressor().compress(str));
    }
    
    private static class Compressor {
        private char cur;
        private int count;
        private StringBuilder buf;
        
        private void accept(char c) {
            if (c != cur) {
                output();
                cur = c;
                count = 1;
            }
            else {
                count++;
            }
        }

        private void output() {
            buf.append(cur);
            buf.append(count);
        }
        
        public String compress(String str) {
            if (str.length() < 2) return str;
            buf = new StringBuilder();
            cur = str.charAt(0);
            count = 1;

            for (int i = 1; i < str.length(); i++) {
                accept(str.charAt(i));
            }
            output();

            if (buf.length() < str.length()) {
                return buf.toString();
            }
            else {
                return str;
            }
        }
    }
}
