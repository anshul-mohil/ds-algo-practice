package leetcode.arrayNdstrings;

import java.util.Arrays;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(b.length()==0)
            return a;
        int[] aBinary = new int[a.length()];
        int[] bBinary = new int[b.length()];
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        Arrays.setAll(aBinary, i -> Integer.parseInt( Character.toString(aChar[i])));
        Arrays.setAll(bBinary, i ->  Integer.parseInt( Character.toString(bChar[i])));

        StringBuilder result = new StringBuilder();
        int ai=aBinary.length-1, bi=bBinary.length-1;
        Integer carry=0;
        while(ai!=-1 && bi!=-1){
            int val = aBinary[ai--]+bBinary[bi--]+carry;
            if(val==2){
                val=0;
                carry=1;
            }
            else if(val==3){
                val=1;
                carry=1;
            }
            else {
                carry=0;
            }
            result.append(val);
        }
        int[] longerBinary=null;
        int longerBinaryCurrIndex=-1;
        if(ai==-1) {
            longerBinary = bBinary;
            longerBinaryCurrIndex=bi;
        }
        else if(bi==-1) {
            longerBinary = aBinary;
            longerBinaryCurrIndex = ai;
        }
        if(longerBinary!=null){
            while(longerBinaryCurrIndex!=-1){
                int val = longerBinary[longerBinaryCurrIndex--] + carry;
                if(val==2){
                    val=0;
                    carry=1;
                }
                else{
                    carry=0;
                }
                result.append(val);
            }
        }
        else if(bi==-1){
        }

        if(carry==1)
            result.append("1");

        return result.reverse().toString();
    }

    private void addCarryToRemainingArray(int[] longerBinary, StringBuilder result, int longerBinaryCurrIndex, Integer carry) {

    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
//        String s = addBinary.addBinary("11", "1");
        String s = addBinary.addBinary("101111", "10");
        System.out.println(s);



    }
}
