class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>();
        
        // Try each cell as potential rhombus center
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Try all possible rhombus sizes
                for (int size = 0; size < Math.min(m, n); size++) {
                    // Check if rhombus fits within grid boundaries
                    if (i - size < 0 || i + size >= m || j - size < 0 || j + size >= n) {
                        break;
                    }
                    
                    int sum = getRhombusSum(grid, i, j, size);
                    sums.add(sum);
                    
                    // Keep only top 3 largest sums
                    if (sums.size() > 3) {
                        sums.pollFirst();
                    }
                }
            }
        }
        
        // Convert TreeSet to array in descending order
        int[] result = new int[sums.size()];
        int idx = result.length - 1;
        for (int sum : sums) {
            result[idx--] = sum;
        }
        return result;
    }
    
    private int getRhombusSum(int[][] grid, int cx, int cy, int size) {
        // Size 0: just the center cell itself
        if (size == 0) {
            return grid[cx][cy];
        }
        
        int sum = 0;
        
        // Top edge: from top corner to right corner
        for (int k = 0; k < size; k++) {
            sum += grid[cx - size + k][cy + k];
        }
        
        // Right edge: from right corner to bottom corner
        for (int k = 0; k < size; k++) {
            sum += grid[cx + k][cy + size - k];
        }
        
        // Bottom edge: from bottom corner to left corner
        for (int k = 0; k < size; k++) {
            sum += grid[cx + size - k][cy - k];
        }
        
        // Left edge: from left corner to top corner
        for (int k = 0; k < size; k++) {
            sum += grid[cx - k][cy - size + k];
        }
        
        return sum;
    }
}