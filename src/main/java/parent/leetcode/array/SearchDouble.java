package parent.leetcode.array;

import java.util.HashSet;

//todo: Need better solution, for sure... Maybe in next try
public class SearchDouble {
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length<2){
            return false;
        }
        var foundElement = new HashSet();
        int i =0;
        while(arr.length>i){
            double i1 = arr[i] / 2.0;
//todo: division automatically trim the number to floor check
            if((i1 == Math.floor(i1)//is divided value integer
                    && foundElement.contains((int)Math.floor(i1))//if int, does this value seen before
            )|| foundElement.contains(arr[i]*2) //is curr is double of some seen value
            ){
                return true;
            }
            foundElement.add(arr[i++]);
        }
        return false;
    }
    public static void main(String[] args) {
        var searchDouble = new SearchDouble();
        var m = new int[]{0,1,2,2,3,0,4,2};
        var m2 = new int[]{10,2,5,3};

        var m3 = new int[]{3,1,7,11};
        var m4 = new int[]{7,1,14,11};
//        var b = searchDouble.checkIfExist(m4);
        var b = searchDouble.checkIfExist(m3);
//        var b = searchDouble.checkIfExist(m2);
    }
}
