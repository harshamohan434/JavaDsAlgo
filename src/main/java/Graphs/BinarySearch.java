package Graphs;

public class BinarySearch {
    public static boolean binarySearch(int[] input, int n){
        int left=0, right = input.length-1;

        while (left<right){
            int mid = (left+right)/2;
            if (n == input[mid]) return true;

            else if (n < input[mid]) right = mid -1;
            else left = mid+1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,4,7,11,15};
        System.out.println(binarySearch(input, 7));
    }
}
