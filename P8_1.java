import java.util.*;

public class P8_1 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(new TripleStep(n).solve());
    }

    public static class TripleStep {
        private int n;
        private int[] mem;
        public TripleStep(int n) {
            this.n = n;
            mem = new int[n];
        }

        public int solve() {
            return solveFor(0) + Math.min(3, n);
        }

        private int solveFor(int step) {
            if (step >= n - 1) {
                return 0;
            }
            if (step == n - 2) {
                return 1;
            }
            if (mem[step] == 0) {
                mem[step] = solveFor(step + 1) + solveFor(step + 2) + solveFor(step + 3);
            }
            return mem[step];
        }
    }

}

