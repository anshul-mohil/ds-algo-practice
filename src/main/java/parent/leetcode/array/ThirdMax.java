package parent.leetcode.array;

public class ThirdMax {
    public static void main(String[] args) {
        var thirdMax = new ThirdMax();
        System.out.println(thirdMax.thirdMax(null));
        System.out.println(thirdMax.thirdMax(new int[]{}));
//        System.out.println(thirdMax.thirdMax(new int[]{5,10,-100,3,6,40000,200}));
        System.out.println("Array: {3,2,1}" + thirdMax.thirdMax(new int[]{3, 2, 1}));
        System.out.println("Array: {3,2}" + thirdMax.thirdMax(new int[]{3, 2}));
        System.out.println("Array: {1,2}" + thirdMax.thirdMax(new int[]{1, 2}));
        System.out.println("Array: {1,1,2}" + thirdMax.thirdMax(new int[]{1, 1, 2}));


    }

    /**
     * This is solved with the help of windowing template.
     * Created window between globalMax and currMax, and
     * gradually descreasing window during each pass.
     * <p>
     *
     * @param a
     * @return
     */
    public int thirdMax(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        //Todo: Important bit.. faced few bugs in initial try(think closely why!)
        int maxIterations = Math.min(a.length, 3);
        var globalMax = Integer.MAX_VALUE;
        var ifAtleast3UniqueElementsExist = findIfAtleast3UniqueElementsExist(a);
        if (a.length < 3 || !ifAtleast3UniqueElementsExist)
            return findMaxElementInArray(a, globalMax);
        while (maxIterations-- > 0)
            globalMax = findMaxElementInArray(a, globalMax);
        return globalMax;
    }

    private boolean findIfAtleast3UniqueElementsExist(int[] a) {
        Integer e,f,g;
        e=f=g=null;
        for (int i = 0; i < a.length; i++) {
            if(e==null || a[i]==e)
                e=a[i];
            else if(f==null || a[i]==f)
                f=a[i];
            else if(g==null || a[i]==g)
                g=a[i];
        }
        return e != null && f != null && g != null;
    }

    private int findMaxElementInArray(int[] a, int globalMax) {
        var currMax = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > currMax && a[i] < globalMax)
                currMax = a[i];
        }
        return currMax;
    }
}
