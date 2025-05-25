package BitsManipulation;

public class BitsManipulationPractice {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,3,2,4};

        int xor = 0;
        for (int num : nums){
            xor ^= num;
            System.out.println(xor + ", "+ (xor & -xor));
        }
    }
}
