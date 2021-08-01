package leetcode.arrayNdstrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        //
        int[][] a1=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(a1));
    }

    public List<Integer> spiralOrder(int[][] a) {
        if (a == null || a.length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        //Top, Left, Bottom and Right boundaries of array
        int minM = -1, minN = -1, m = a.length, n = a[0].length;
        //current row and col read positions.
        int currM = 0, currN = 0;
        //travers directions. values can be 0, 1, -1
        // where 0=no movement, 1=forward movement and -1=backward movement at column or row direction.
        int nDir = 1, mDir = 0;
        //Todo: check if m and n would be calculated only initially.
//        for (int i = 0; i < m * n; i++) {
        for (int i = 0; i < a.length * a[0].length; i++) {
            //read current position element
            result.add(a[currM][currN]);
            //Move to next cell based on next movement direction ie. mDir/nDir.
            currM += mDir;
            currN += nDir;
            //Right boundary violation
            if (currN == n) {
                currN = n - 1; //reset column back to valid column index
                //right boundary violation suggest that previous traversal was left to right row traversal. So mark minRow as consumed.
                minM += 1;
                //next col to read would be
                currM=minM+1;
                //After left to right traverse, next movement is downwards. ie. row++ at nth column.
                mDir=1;
                nDir=0;
            }
            //Bottom boundary violation.
            else if(currM==m){
                currM = m-1; // reset row back to valid max row index after bottom boundary violation.
                //Bottom boundary violation suggest that previous traversal was downwards, so mark maxColumn consumed.
                n -=1;
                currN=n-1;
                //After downward traverse, next movement right to left row traversal. ie. column-- on same max boundary row.
                mDir=0;
                nDir=-1;
            }
            else if(currN == minN){
                currN = minN+1; //reset column back to valid min row index after left boundary violation.
                //Left boundary violation suggest that previous traversal was right to left, so mark maxRow as consumed.
                m -=1;
                currM=m-1;
                //After left to right traversal, next movement would be upward. ie. row++ on same column.
                mDir=-1;
                nDir=0;
            }
            else if(currM == minM){
                currM = minM+1;
                minN +=1;
                currN=minN+1;
                mDir=0;
                nDir=1;
            }
        }
        return result;
    }
}
