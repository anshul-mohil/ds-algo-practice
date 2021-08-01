package leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //converting elements to indexes
        m--;
        n--;

        for (int i = nums1.length-1; i >=0 && n>=0; i--) {

            if(m<0){
                nums1[i] = nums2[n--];
            }
            else if(nums1[m] > nums2[n]){
                nums1[i] = nums1[m--];
            }
            else {
                nums1[i]= nums2[n--];
            }
        }
    }
    public static void main(String[] args) {
        var mergeSortedArray = new MergeSortedArray();
//        var test1 = new int[]{0, 10, 0, 10, 0};
//        var test1 = new int[]{1,0,2,3,0,4,5,0};
        var m = new int[]{-10,20,30,0,0,0};
        var n = new int[]{10,20,40};
//        [-10,10,20,20,30,40]

        mergeSortedArray.merge(m,3,n,3);
        System.out.println(Arrays.toString(m));

//
//         new int[]{-10,20,30,0,0,0};
//         new int[]{10,20,40};

        var ints1 = new int[]{10};
        var ints = new int[]{};
        mergeSortedArray.merge(ints1,1,ints,0);
        System.out.println(Arrays.toString(ints1));


        var em = new int[]{0};
        var one = new int[]{10};
        mergeSortedArray.merge(em, 0, one, 1);
        System.out.println(Arrays.toString(em));



    }
}
