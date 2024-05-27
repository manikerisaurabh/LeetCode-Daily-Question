public class 27-May {
    public int specialArray(int[] nums) {
        int n=nums.length;
        int[] count=new int[n+1];
        for(int a:nums){
            int index=Math.min(a,n);
            count[index]++;
        }
        int total=0;
        for(int i=n-1;i>=0;i--){
            total += count[i+1];
            if(total==i+1)
                return i+1;
        }
        return -1;
    }
}
