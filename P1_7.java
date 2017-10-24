
import java.util.*;
import java.util.function.*;


public class P1_7 {
    public static void main(String[] args) {
        int[][] matrix = { 
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        printMatrix(matrix);
        printMatrix(rotate90(matrix));
    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotate90(int[][] mat) {
        int [][] output = new int[mat.length][mat.length];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat.length; c++) {
               int fromRow = mat.length - 1 - c;
               int fromCol = r;
               output[r][c] = mat[fromRow][fromCol];
            }
        }
        return output;
    }
}
