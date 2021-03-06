package parent.leetcode.array;

public class ReplaceWithGreatestOnRight {
    public int[] replaceElements(int[] a) {
        int lastIndex = a.length-1;
        if(a == null || lastIndex == -1)
            return a;
//        not needed, has been handled in while
//        if(lastIndex == 0)
//            return new int[]{-1};
        int max = a[lastIndex];
        a[lastIndex]=-1;
        int currIndex = lastIndex-1;


        while (currIndex>-1){
            if(a[currIndex]>max){
                int temp = a[currIndex];
                a[currIndex--]=max;
                max=temp;
            }
            else
                a[currIndex--]=max;
        }
        return a;
    }
    public static void main(String[] args) {
        var removeDuplicateFromSortedArray = new ReplaceWithGreatestOnRight();
        var m = new int[]{0,1,2,2,3,0,4,2};
        var m2 = new int[]{1};
        var m3 = new int[]{4,5};
        removeDuplicateFromSortedArray.replaceElements(m);
    }
}
