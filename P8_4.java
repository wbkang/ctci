import java.util.*;

public class P8_4 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (String a: args) {
            set.add(a);
        }
        System.out.println("Set is " + powerset(set));
    }


    public static Set<Set<String>> powerset(Set<String> s) {
        Set<Set<String>> r = new HashSet<>();
        for (int i = 0; i <= s.size(); i++) {
            r.addAll(subset(i, s));
        }
        return r;
    }

    public static Set<Set<String>> subset(int size, Set<String> set) {
        Set<Set<String>> r = new HashSet<>();
        if (size == 0) {
            r.add(new HashSet<>());
            return r;
        }

        Set<String> copy = new HashSet<>(set);
        for (String elem : set) {
            Set<String> ss = new HashSet<>();
            copy.remove(elem);
            for (Set<String> subset : subset(size - 1, copy)) {
                subset.add(elem);
                r.add(subset);
            }
            copy.add(elem);
        }
        return r;
    }
}

