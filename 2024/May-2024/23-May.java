public class 23-May {
    int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        solver(nums, k, 0, new ArrayList<>());
        return ans-1;
    }
    public void solver(int[] nums, int k, int i, List<Integer> subSet){
        if(i>=nums.length) {
            ans++;
            return;
        }
        // if take curr element
        if (isSafe(nums, subSet, i, k)) {
            subSet.add(nums[i]);
            solver(nums, k, i+1, subSet);
            subSet.remove(subSet.size() - 1);
        }
        // if not take curr element
        solver(nums, k, i + 1,subSet);
    }
    public boolean isSafe(int nums[], List<Integer> subSet, int idx, int k) {
        for (int i = 0; i < subSet.size(); i++) {
            if (Math.abs(nums[idx] - subSet.get(i)) == k) return false;
        }
        return true;
    }
}