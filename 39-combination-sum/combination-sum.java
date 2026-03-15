class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int start, 
                          List<Integer> current, List<List<Integer>> result) {
        // Base case: found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: exceeded target
        if (remaining < 0) {
            return;
        }
        
        // Try each candidate from start index
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Pass 'i' (not i+1) since we can reuse the same element
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}