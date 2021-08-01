package leetcode.array;

public class SortByParity {
    public static void main(String[] args) {
        var moveZeros = new MoveZeros();
        var m = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var m2 = new int[]{0, 1, 0, 3, 12};
        var m3 = new int[]{4, 5};
    }

    public int[] sortArrayByParity(int[] a) {
        int evenIndex = 0, oddIndex = a.length - 1;
        while (evenIndex != oddIndex) {
            if (a[evenIndex] % 2 != 0) {
                while (oddIndex > evenIndex & a[oddIndex] % 2 != 0)
                    oddIndex--;
                //swap odd with even
                int temp = a[evenIndex];
                a[evenIndex] = a[oddIndex];
                a[oddIndex] = temp;
            } else
                evenIndex++;
        }
        return a;
    }
}
