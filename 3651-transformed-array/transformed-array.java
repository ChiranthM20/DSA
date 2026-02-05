class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            // If value is 0, copy directly
            if (nums[i] == 0) {
                result[i] = 0;
            } 
            else {
                // Calculate new index
                int newIndex = (i + nums[i]) % n;

                // Fix negative modulo
                if (newIndex < 0) {
                    newIndex += n;
                }

                result[i] = nums[newIndex];
            }
        }

        return result;
    }
}