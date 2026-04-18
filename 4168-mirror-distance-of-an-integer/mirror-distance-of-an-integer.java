class Solution {
    public int mirrorDistance(int n) {
        // Step 1: Calculate the reverse of n
        int original = n;
        int reversed = 0;
        
        while (n > 0) {
            int lastDigit = n % 10;
            reversed = (reversed * 10) + lastDigit;
            n /= 10;
        }
        
        // Step 2: Calculate the absolute difference
        return Math.abs(original - reversed);
    }
}