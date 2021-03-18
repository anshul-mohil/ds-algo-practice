package parent.leetcode.arrayNdstrings;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] a) {
        int carry=1;
        boolean isAll9s=true;
        for (int x:a) {
            if(x!=9)
                isAll9s=false;
        }
        int[] newArr = null;
        if(isAll9s)
            newArr = new int[a.length+1];
        else
            newArr= new int[a.length];
        for (int i = a.length-1; i > -1; i--) {
            int newDigit = a[i]+carry;
            carry=0;
            if(newDigit==10){
                newArr[i]=0;
                carry=1;
            }
            else
                newArr[i]=newDigit;
            if(i==0 && carry==1)
                newArr[i]=1;
        }
        return newArr;
    }
    public static void main(String[] args) {
        var findPivot = new PlusOne();
        System.out.println("Array: {0, 0, 0, 1}" + Arrays.toString(findPivot.plusOne(new int[]{0, 0, 0, 1})));
        System.out.println("Array: {0, 0, 0, 1}" + Arrays.toString(findPivot.plusOne(new int[]{4, 7, 9, 1})));
        System.out.println("Array: {9, 9,9, 9}" + Arrays.toString(findPivot.plusOne(new int[]{9, 9,9, 9})));
    }
}
