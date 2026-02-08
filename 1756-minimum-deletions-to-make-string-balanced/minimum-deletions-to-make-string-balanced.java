class Solution {
    public int minimumDeletions(String s) {
    int bCount = 0;     // number of 'b's seen
    int deletions = 0; // min deletions so far

    for (char c : s.toCharArray()) {
        if (c == 'b') {
            bCount++;
        } else { // c == 'a'
            deletions = Math.min(deletions + 1, bCount);
        }
    }

    return deletions;
    }
}