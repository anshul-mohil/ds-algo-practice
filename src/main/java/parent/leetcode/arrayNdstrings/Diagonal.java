package parent.leetcode.arrayNdstrings;

import java.util.Arrays;

public class Diagonal {


    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row -= d;
            col += d;
            if (row == m) {
                row = m - 1;
                col += 2;
                d = -d;
            } else if (col == n) {
                col = n - 1;
                row += 2;
                d = -d;
            } else if (row == -1) {
                row = 0;
                d = -d;
            } else if (col == -1) {
                col = 0;
                d = -d;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        var findPivot = new Diagonal();
        var matrix3by3 = new int[3][3];
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                matrix3by3[i][j] = (i + 1) * (j + 3);
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) {
                System.out.print(" , ");
                System.out.print(matrix3by3[i][j]);
            }
        var singleArray = new int[1][3];
        singleArray[0][0] = 1;
        singleArray[0][1] = 2;
        singleArray[0][2] = 3;

//        System.out.println("Array: {1,2,3}" + Arrays.toString(findPivot.findDiagonalOrder2(singleArray)));
//        System.out.println("Array: {1,2,3,2,4,6,3,6,9} : expected:{1,2,2,3,4,3,6,6,9}   " + Arrays.toString(findPivot.findDiagonalOrder3(matrix3by3)));
        var a1 = new int[1][2];
        a1[0][0] = 1;
        a1[0][1] = 2;
//        Arrays.toString(findPivot.findDiagonalOrder3(a1));

        var a2 = new int[2][1];
        a2[0][0] = 1;
        a2[1][0] = 2;
//        System.out.println(Arrays.toString(findPivot.findDiagonalOrder3(a2)));

        int[][] a3 = {{2, 5}, {8, 4}, {0, -1}};
        System.out.println(Arrays.toString(findPivot.findDiagonalOrder(a3)));
    }
}
