package leetcode.arrayNdstrings;

public class LargestNumber {
    public static void main(String[] args) {
        var findPivot = new LargestNumber();
        System.out.println(findPivot.dominantIndex(null));
        System.out.println(findPivot.dominantIndex(new int[]{}));
        System.out.println("Array: {0, 0, 0, 1}" + findPivot.dominantIndex(new int[]{0, 0, 0, 1}));
//        System.out.println("Array: {1,2,3, 2, 1}" + findPivot.dominantIndex(new int[]{1,2,3, 2, 1}));
//        System.out.println("Array: {-1,-3,3, -4, 0}" + findPivot.dominantIndex(new int[]{-1,-3,3, -4, 0}));
    }

    public int dominantIndex(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < a.length; i++)
            if (max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
        for (int x : a)
            if (x != max && x * 2 > max)
                return -1;

        return maxIndex;
    }
}
