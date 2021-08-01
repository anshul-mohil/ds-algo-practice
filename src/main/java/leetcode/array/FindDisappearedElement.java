package leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class FindDisappearedElement {
    public static void main(String[] args) {
        var findDisappearedNumbers = new FindDisappearedElement();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(null));
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{}));
        System.out.println("Array: {3,2,1}" + findDisappearedNumbers.findDisappearedNumbers(new int[]{3, 2, 1}));
        System.out.println("Array: {1,1,2}" + findDisappearedNumbers.findDisappearedNumbers(new int[]{1, 1, 2}));
        System.out.println("Array: {1,1,2}" + findDisappearedNumbers.findDisappearedNumbers(new int[]{5, 1, 2, 3, 2, 3, 2}));


    }

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
     * some elements appear twice and others appear once.
     * <p>
     * Find all the elements of [1, n] inclusive that do not appear
     * in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * You may assume the returned list does not count as extra space.
     *
     * @param a
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] a) {
        var missingElements = new LinkedList<Integer>();
        if (a == null || a.length == 0)
            return missingElements;
        for (int i = 0; i < a.length; i++)
            while (a[i] != i + 1 && a[i] != 0)
                swap(a, i, a[i] - 1);
        return missingElements(a);
    }

    //a[i]!=i=1 is unnecessary condition if array is not flawed
    private List<Integer> missingElements(int[] a) {
        var missingElements = new LinkedList<Integer>();

        for (int i = 0; i < a.length; i++)
            if (a[i] == 0 || a[i] != i + 1)
                missingElements.add(i + 1);
        return missingElements;
    }

    private void swap(int[] a, int fromIndex, int toIndex) {
        if (a[toIndex] == a[fromIndex])
            a[fromIndex] = 0;
        else {
            var temp = a[toIndex];
            a[toIndex] = a[fromIndex];
            a[fromIndex] = temp;
        }
    }
}
