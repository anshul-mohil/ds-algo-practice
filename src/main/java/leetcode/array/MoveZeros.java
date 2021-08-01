package leetcode.array;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] a) {
        int insertionIndex = 0;
        int searchIndex = 0;
        while (searchIndex < a.length) {
            if (a[insertionIndex] == 0) {
                while (searchIndex < a.length && a[searchIndex] == 0) {
                    searchIndex++;
                }
            }
            if (searchIndex < a.length && insertionIndex != searchIndex) {
                a[insertionIndex] = a[searchIndex];
                a[searchIndex] = 0;
            }
            insertionIndex++;
            searchIndex++;
        }
    }

    public static void main(String[] args) {
        var moveZeros = new MoveZeros();
        var m = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var m2 = new int[]{0, 1, 0, 3, 12};
        var m3 = new int[]{4, 5};
        moveZeros.moveZeroes(m2);
        System.out.println(Arrays.toString(m2));
            }
}
