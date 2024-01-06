/*
====================================================== 1235. Maximum Profit in Job Scheduling    ======================================================


Problem Statement : We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

                    You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

                    If you choose a job that ends at time X you will be able to start another job that starts at time X.


Examples : 

                    Example 1:
                    Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
                    Output: 120
                    Explanation: The subset chosen is the first and fourth job. 
                    Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.


                    Example 2:
                    Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
                    Output: 150
                    Explanation: The subset chosen is the first, fourth and fifth job. 
                    Profit obtained 150 = 20 + 70 + 60.


                    Example 3:
                    Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
                    Output: 6
*/

public class 06-Jan {
    static class Job implements Comparable<Job> {
        int start, end, profit;
        public Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
        @Override
        public int compareTo(Job that) {
            return Integer.compare(this.end, that.end);
        }
    }


    private int search(List<Job> jobs, int i, int curStart) {
        int left = 0, right = i;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs.get(mid).end <= curStart) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Job cur = jobs.get(i - 1);
            int maxValidIdx = search(jobs, i, cur.start); 
            dp[i] = Math.max(dp[i - 1], dp[maxValidIdx] + cur.profit);
        }
        return dp[n];
    }
    
}
