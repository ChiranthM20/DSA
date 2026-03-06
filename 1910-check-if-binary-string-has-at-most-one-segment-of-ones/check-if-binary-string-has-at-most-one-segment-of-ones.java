class Solution {
    public boolean checkOnesSegment(String s) {
        int firstOne = s.indexOf('1');
        int lastOne = s.lastIndexOf('1');
        
       
        if (firstOne == -1) {
            return true;
        }
        
       
        for (int i = firstOne; i <= lastOne; i++) {
            if (s.charAt(i) == '0') {
                return false; 
            }
        }
        
        return true;
    }
}