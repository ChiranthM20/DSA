class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        // suffixMin[i] = minimum value in nums[i...n-1]
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int minSum = Integer.MAX_VALUE;

        // i is the start of the 2nd subarray
        for (int i = 1; i <= n - 2; i++) {
            minSum = Math.min(minSum, nums[i] + suffixMin[i + 1]);
        }

        return nums[0] + minSum;
    }
}