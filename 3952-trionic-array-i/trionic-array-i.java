class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 1;

        // 1️⃣ Strictly increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        // Need at least one increase
        if (i == 1) return false;

        // 2️⃣ Strictly decreasing
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }
        // Need at least one decrease
        if (i == n || nums[i - 1] >= nums[i - 2]) return false;

        // 3️⃣ Strictly increasing again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        // Must reach the end
        return i == n;
    }
}