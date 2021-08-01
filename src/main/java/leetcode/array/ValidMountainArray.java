package leetcode.array;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
//        array length should be
        if(arr == null || arr.length<3)
            return false;
        boolean isAsc = true;
        for (int next = 1; next < arr.length; next++) {
            if(isAsc && arr[next]<arr[next-1])
                isAsc = false;
            else if (!isAsc && arr[next]>=arr[next-1])
                return false;
        }

        return isAsc?false:true;
    }

    public boolean validMountainArray2(int[] a) {
//        array length should be
        if(a == null || a.length<3)
            return false;
        int curr = 0;
        int lastIndex = a.length-1;
        while(curr<lastIndex-1 && a[curr]<a[curr+1]){
            curr++;
        }
//if encounter values were in opposite order or all values are in asc then
        if(curr == 0 || curr == lastIndex)
            return false;
        while(curr<lastIndex && a[curr]>a[curr+1]){curr++;}
        if(curr==lastIndex)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        var validMountainArray = new ValidMountainArray();
        var m = new int[]{0,1,2,2,3,0,4,2};
        var m2 = new int[]{3,5,5};
        var m5 = new int[]{1,3,2};

        var m3 = new int[]{3,1,7,11};
        var m4 = new int[]{7,1,14,11};
//        System.out.println(validMountainArray.validMountainArray2(m2));
        System.out.println(validMountainArray.validMountainArray2(m5));
    }
}
