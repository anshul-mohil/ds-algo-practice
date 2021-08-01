package leetcode.array;

import java.util.HashMap;

public class HeightChecker {
    public static void main(String[] args) {
        var heightChecker = new HeightChecker();
        var m2 = new int[]{0, 1, 0, 3, 12};
        var m3 = new int[]{4, 5};
//        System.out.println(heightChecker.heightChecker(new int[]{1, 1, 2, 2, 3, 0, 4, 2}));
//        System.out.println(heightChecker.heightChecker(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(heightChecker.heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(heightChecker.heightChecker(new int[]{9, 2, 8, 3, 8, 4, 6, 6, 8, 3, 3, 1, 2, 8, 9, 6, 6, 5, 3, 2}));
    }

    public int heightChecker(int[] a) {
        var frequencyMap = new HashMap<Integer, Integer>();

        var globalMin = Integer.MAX_VALUE;
        //find minimum element and capture frequency of elements
        for (int i = 0; i < a.length; i++) {
            if (a[i] < globalMin)
                globalMin = a[i];
            if (frequencyMap.containsKey(a[i]))
                frequencyMap.put(a[i], frequencyMap.get(a[i]) + 1);
            else
                frequencyMap.put(a[i], 1);
        }

        int curIndex = 0;
        int countIncorrectItems = 0;
        int curMin = globalMin;

        while (curIndex < a.length) {
            //looping through element occurrence
            var frequencyOfCurMinElement = frequencyMap.get(curMin) == null ? 0 : frequencyMap.get(curMin);
            for (int i = 0; i < frequencyOfCurMinElement; i++)
                if (a[curIndex + i] != curMin)
                    countIncorrectItems++;
            if (frequencyOfCurMinElement != 0)
                curIndex = curIndex + frequencyOfCurMinElement;
            curMin++;
        }
        return countIncorrectItems;
    }
}
