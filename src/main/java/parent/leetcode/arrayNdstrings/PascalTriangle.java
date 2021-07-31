package parent.leetcode.arrayNdstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int a) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            if(i==0){
                pascalTriangle.add(Collections.singletonList(1));
                continue;
            }
            List<Integer> subList = new ArrayList<>(i+1);
            List<Integer> prevList = pascalTriangle.get(i - 1);
//            for (int j = 0; j <= i; j++) {
            //For clarity say while j < i+1;
            for (int j = 0; j < i+1; j++) {
                if(j==0)
                    subList.add(1);
                else if(j==i)
                    subList.add(1);
                else{
                    int pascalVal = prevList.get(j-1) + prevList.get(j);
                    subList.add(pascalVal);
                }
            }
            pascalTriangle.add(subList);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
//        List<List<Integer>> generate = pascalTriangle.generate(1);
//        System.out.println(generate.toString());
//        List<List<Integer>> generate1 = pascalTriangle.generate(2);
//        System.out.println(generate1.toString());
        List<List<Integer>> generate2 = pascalTriangle.generate(5);
        System.out.println(generate2.toString());


    }
}
