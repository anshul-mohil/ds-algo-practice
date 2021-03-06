package parent.leetcode.array;

public class EvenDigits {
    public void evenNumberDigit(){
        int[] evenDigitsNumber = new int[]{100000,12,345,2,6,7896,9_99_99};
        System.out.println(findNumbers(evenDigitsNumber));
    }
    public int findNumbers(int[] nums) {
        int count=0;
        for (int number: nums) {
            if(isEvenNumberDigits(number))
                count++;
        }
        return count;
    }
    private boolean isEvenNumberDigits(int num){
        if((num/10>0 && num/10<10) || (num/1_000 >0 && num/1_000<10) || (num/1_00_000 >0 && num/1_00_000<10)){
            return true;
        }
        else {
            return false;
        }
    }
}
