package leetcode.array;

public class MaxConsecutiveOnes {
    public void maxConsecutiveOnes() {
        int[] binaryValueArray = new int[15];
        binaryValueArray[0] = 0;
        binaryValueArray[1] = 1;
        binaryValueArray[2] = 0;
        binaryValueArray[3] = 1;
        binaryValueArray[4] = 1;
        binaryValueArray[5] = 1;
        binaryValueArray[6] = 0;
        binaryValueArray[7] = 0;
        binaryValueArray[8] = 1;
        binaryValueArray[9] = 1;
        binaryValueArray[10] = 1;
        binaryValueArray[11] = 1;
        binaryValueArray[12] = 0;
        binaryValueArray[13] = 0;
        binaryValueArray[14] = 1;
        System.out.println(findMaxConsecutiveOnes(binaryValueArray));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        var maxNum = 0;
        var currSum = 0;
        for (int value : nums) {
            if (value == 0)
                currSum = 0;
            else {
                currSum++;
                if (maxNum < currSum)
                    maxNum = currSum;
            }
        }
        return maxNum;
    }
}
