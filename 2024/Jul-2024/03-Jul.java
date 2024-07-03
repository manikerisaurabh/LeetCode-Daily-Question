public class 03-Jul {
    private int minDiff(List<Integer> nums) {
        int n = nums.size();
        return Math.min(
                Math.min(nums.get(n - 1) - nums.get(3), nums.get(n - 2) - nums.get(2)),
                Math.min(nums.get(n - 3) - nums.get(1), nums.get(n - 4) - nums.get(0))
        );
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        
        Arrays.sort(nums);
        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        return minDiff(numsList);
    }
}
