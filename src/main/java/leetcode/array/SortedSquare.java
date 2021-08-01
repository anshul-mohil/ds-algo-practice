package leetcode.array;


import java.util.Arrays;

public class SortedSquare {
    private int[] sortedSquares2(int[] a) {
//   find the index of all negative numbers.
//        square all negative number
//        place only negative number in already sorted list from last of an
//        array(maybe its easy to )


//        complexity of this approach will be n^2 due to possible array
//        movement due to insertion.

        return null;
    }

    private int[] sortedSquares(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = a[i] * a[i];
        int[] sortedSquares = new int[a.length];
        int i = a.length - 1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            if (a[s] < a[e]) {
                sortedSquares[i--] = a[e--];
            } else {
                sortedSquares[i--] = a[s++];
            }
        }
        return sortedSquares;
    }


    public void sortedSquare() {
        int[] test1 = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(test1)));
    }
}
