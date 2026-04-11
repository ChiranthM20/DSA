class Solution {
    public int minimumDistance(int[] nums) {
       
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                for (int i = 2; i < indices.size(); i++) {
                    int distance = 2 * (indices.get(i) - indices.get(i - 2));
                    ans = Math.min(ans, distance);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}