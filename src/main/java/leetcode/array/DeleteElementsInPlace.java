package leetcode.array;

import java.util.Arrays;

public class DeleteElementsInPlace {
    public int removeElement(int[] nums, int val) {
        int lastIndex = nums.length-1;
        int i=0;
        while(i<=lastIndex){
            if(nums[i]==val){
                if(nums[lastIndex]==val){
                    lastIndex--;
                }
                else {
                    nums[i]=nums[lastIndex--];
                }
            }
            else {
                i++;
            }
        }
        // total remaining elements
        return lastIndex+1;
    }

    public static void main(String[] args) {
        var deleteElementsInPlace = new DeleteElementsInPlace();
        var m = new int[]{0,1,2,2,3,0,4,2};
        var m2 = new int[]{1};
        var m3 = new int[]{4,5};


        var i = deleteElementsInPlace.removeElement(m, 2);
        var j = deleteElementsInPlace.removeElement(m2, 1);
        var k = deleteElementsInPlace.removeElement(m3, 5);
        System.out.println(Arrays.toString(m)+ " with 2 " + " elements remaining: " + i);
        System.out.println(Arrays.toString(m2)+ " with 1 "+ " elements remaining: " + j);
        System.out.println(Arrays.toString(m3)+ " with 5 "+ " elements remaining: " + k);
    }
}
