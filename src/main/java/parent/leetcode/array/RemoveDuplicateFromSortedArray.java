package parent.leetcode.array;

public class RemoveDuplicateFromSortedArray {

        public int removeDuplicates(int[] a) {

            if(a.length ==0 || a.length == 1){
                return a.length;
            }
            int currIndex=0, nextVal=a[currIndex++]+1, newLen=1;
            while(currIndex < a.length){
                if(a[currIndex]>=nextVal){
                    a[newLen++]=a[currIndex];
                    nextVal=a[currIndex]+1;
                }
                currIndex++;
            }
            return newLen;
        }
    public static void main(String[] args) {
        var removeDuplicateFromSortedArray = new RemoveDuplicateFromSortedArray();
        var m = new int[]{0,1,2,2,3,0,4,2};
        var m2 = new int[]{1};
        var m3 = new int[]{4,5};

    }
}
