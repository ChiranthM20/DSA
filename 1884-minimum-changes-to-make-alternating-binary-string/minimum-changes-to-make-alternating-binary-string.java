class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int countStart0 = 0; 

        for (int i = 0; i < n; i++) {
        
            char expected = (i % 2 == 0) ? '0' : '1';
            
            if (s.charAt(i) != expected) {
                countStart0++;
            }
        }
        return Math.min(countStart0, n - countStart0);
    
    }
}