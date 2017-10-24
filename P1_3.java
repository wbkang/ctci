
import java.util.*;
import java.util.function.*;


public class P1_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();
        int len = input.nextInt();
        
        char[] array = str.toCharArray();
        // actually do things
        
        int orgPosition = len - 1;
        int destPosition = str.length() - 1;

        while (orgPosition >= 0 && destPosition >= 0) {
            char c = array[orgPosition--];
            if (c == ' ') {
                array[destPosition--] = '0';
                array[destPosition--] = '2';
                array[destPosition--] = '%';
            }
            else {
                array[destPosition--] = c;
            }
        }
        
        System.out.println(new String(array));

    }

    
}
