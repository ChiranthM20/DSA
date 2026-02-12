class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; // position for next non-zero

        // Move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        // Fill remaining positions with 0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}