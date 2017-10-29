

import java.util.*;
import java.util.function.*;


public class P5_3 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        
        List<Data> lst = new ArrayList<>();
        
        Data data = null; // no sequence
        for (int i = 0; num != 0; i++) {
            if ((num & 1) == 1) {
                if (data == null) {
                    data = new Data();
                    data.begin = i;
                    data.length = 1;
                }
                else {
                    data.length++;
                }
            }
            else {
                if (data != null) {
                    lst.add(data);
                    data = null;
                }
            }
            num >>= 1;
        }
        if (data != null) {
            lst.add(data);
        }
        int max = 0;
        for (int i = 0; i < lst.size(); i++) {
            Data cur = lst.get(i);
            if (lst.size() - 1 != i) {
                Data next = lst.get(i + 1);
                if (next.begin == cur.begin + cur.length + 1) {
                    max = Math.max(max, cur.length);
                    max = Math.max(max, cur.length + next.length + 1);
                }
            }
        }
        System.out.println(max);
    }

    static class Data{
        int begin;
        int length;
    }
}
