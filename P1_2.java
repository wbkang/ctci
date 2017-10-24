
import java.util.*;
import java.util.function.*;


public class P1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s1 = input.nextLine();
        String s2 = input.nextLine();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        
        System.out.println(Arrays.equals(c1, c2) ? "Yes": "No");

    }
    
    
}
