public class 20-May {
    public int subsetXORSum(int[] nums) {
        return sumXor(nums, 0, 0);
    }
    
    private int sumXor(int[] nums, int i, int cur){
        if(i == nums.length)   return cur;
        return sumXor(nums, i+1, cur) + sumXor(nums, i+1, cur^nums[i]);
    }
}
