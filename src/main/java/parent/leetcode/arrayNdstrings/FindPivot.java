package parent.leetcode.arrayNdstrings;

public class FindPivot{
    public int pivotIndex(int[] a) {
        if(a == null || a.length==0)
            return -1;
        int sum=0;
        for (int i = 0; i < a.length; i++)
            sum=sum+a[i];

        int leftSum=0;
        for (int i = 0; i < a.length; i++) {
            int rightSum=sum-(leftSum+a[i]);
            if(rightSum==leftSum)
                return i;
            leftSum=leftSum+a[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        var findPivot = new FindPivot();
        System.out.println(findPivot.pivotIndex(null));
        System.out.println(findPivot.pivotIndex(new int[]{}));
        System.out.println("Array: {3,2,1}" + findPivot.pivotIndex(new int[]{3, 2, 1}));
        System.out.println("Array: {1,2,3, 2, 1}" + findPivot.pivotIndex(new int[]{1,2,3, 2, 1}));
        System.out.println("Array: {-1,-3,3, -4, 0}" + findPivot.pivotIndex(new int[]{-1,-3,3, -4, 0}));
    }
}