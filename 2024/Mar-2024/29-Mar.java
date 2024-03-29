public class 29-Mar {

    public long countSubarrays(int[] nums, int k) {
        int max=0;
        int n=nums.length,left=0;
        for(int val:nums){
            max=Math.max(max,val);
        }
        long res=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                cnt++;
            }
            while(left<=i&&cnt>=k){
                if(nums[left]==max){
                    cnt--;
                }
               res+=n-i;
               left++;
            }
        }
        return res;
    }
}