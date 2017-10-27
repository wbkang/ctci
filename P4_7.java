

import java.util.*;
import java.util.function.*;


public class P4_7 {
    public static void main(String[] args) {
        DepResolver r = new DepResolver();
        r.addProjects("a", "b", "c", "d", "e", "f");
        r.addDeps("a", "d");
        r.addDeps("f", "b");
        r.addDeps("b", "d");
        r.addDeps("f", "a");
        r.addDeps("d", "c");
        System.out.println(r.build());
    }
    
    static class DepResolver {
        // prereq -> proj
        Map<String, Set<String>> deps = new HashMap<>();
        Set<String> projects = new HashSet<>();

        public void addProjects(String... p) {
            for (String s : p)
                projects.add(s);
        }

        public void addDeps(String prereq, String p) {
            Set<String> set;
            if (!deps.containsKey(prereq)) {
                set = new HashSet<>();
                deps.put(prereq, set);
            }
            else {
                set = deps.get(prereq);
            }
            set.add(p);
        }

        public List<String> build() {
            Set<String> noDeps = new HashSet<>(projects);
            for (Set<String> set : deps.values()) {
                noDeps.removeAll(set);
            }
            Set<String> built = new HashSet<>();
            List<String> out = new ArrayList<>();

            Queue<String> q = new LinkedList<>();

            for (String topProj : noDeps) {
                q.offer(topProj);
                while (!q.isEmpty()) {
                    String p = q.poll();        
                    if (!built.contains(p)) {
                        built.add(p);
                        out.add(p);
                        if (deps.containsKey(p)) {
                            for (String next : deps.get(p)) {
                                q.offer(next);
                            }
                        }
                    }
                }
            }
            return out;
        }
    }


}
