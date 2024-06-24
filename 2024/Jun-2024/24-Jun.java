public class 24-Jun {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int l = nums[i];
            if(l == 0 && q.size() % 2 == 0){
                q.add(i + k - 1);
                ans++;
            }else if(l == 1 && q.size() % 2 != 0){
                q.add(i + k - 1);
                ans++;
            }
            if(!q.isEmpty() && q.peek() == i){
                q.poll();
            }
        }
        if(!q.isEmpty()) return -1;
        return ans;
    }
}
