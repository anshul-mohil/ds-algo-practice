package parent.leetcode.array;

import java.util.Arrays;

public class DuplicateZero {
    public void duplicateZerosImproved(int[] a) {
        if(a==null){
            return;
        }
        int lastValidElementsIndex = a.length-1;
        int shift = 0;
        boolean foundFirstValidElement = false;
//        O(n)
        for (int i=lastValidElementsIndex; i>=0; i--) {
            if(a[i] !=0 && !foundFirstValidElement){
                foundFirstValidElement = true;
                lastValidElementsIndex = i;
            }
            else if(a[i] == 0 && foundFirstValidElement){
                shift++;
            }
        }
        if(shift==0)
            return;
        //now shifting elements = shift + lastElementIndex
        for (int i = lastValidElementsIndex; i >=0; i--) {
            int shiftElementsIndex = i + shift;
            if(shiftElementsIndex < a.length){
                a[shiftElementsIndex] = a[i];
                if(a[i]==0){
                    a[--shiftElementsIndex] = 0;
                    shift--;
                }
            }
            else if(shiftElementsIndex == a.length && a[i]==0){
                shift--;
                a[shiftElementsIndex-1]=0;
            }
            else if(shiftElementsIndex > a.length && a[i]==0){
                shift--;
            }
        }


    }
//[1, 0, 2, 3, 0, 4, 5, 0]
//[1, 0, 0, 2, 3, 4, 0, 4]
    public static void main(String[] args) {
//        var test1 = new int[]{0, 10, 0, 10, 0};
//        var test1 = new int[]{1,0,2,3,0,4,5,0};
//        var test1 = new int[]{0,0,0,0,0,0,0};
        var test1 = new int[]{0,1,7,6,0,2,0,7};
        var duplicateZero = new DuplicateZero();
        System.out.println(Arrays.toString(test1));
        duplicateZero.duplicateZerosImproved(test1);
        System.out.println(Arrays.toString(test1));
    }
}
