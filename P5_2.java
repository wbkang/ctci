

import java.util.*;
import java.util.function.*;


public class P5_2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = scanner.nextDouble();
        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        double divisor = 1;
        for (int i = 0; i < 32; i++) {
            divisor /= 2;
            if (num >= divisor) {
                num -= divisor;
                sb.append('1');
            }
            else {
                sb.append('0');
            }
        }
        if (num > 0)
            System.err.println("ERROR");
        else
            System.out.println(sb.toString());
    }
    

}
