public class 18-Jun {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       
        int max = 0;
        int i = -1;
        while (i++ < worker.length - 1) {
            int currentmax = 0;
            int j = -1;
            while (j++ < difficulty.length - 1) {
                 if (worker[i] >= difficulty[j]) {
                    currentmax = Math.max(currentmax, profit[j]);
                }
            }
            max += currentmax;
        }
        return max;

    }
}
