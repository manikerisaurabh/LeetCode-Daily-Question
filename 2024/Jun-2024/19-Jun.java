public class 19-Jun {
    private boolean isSafe(int mid, int[] bloomDay, int m, int k) {
        int consecCount = 0, numOfBouquet = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                consecCount++;
            } else {
                consecCount = 0;
            }

            if (consecCount == k) {
                numOfBouquet++;
                consecCount = 0;
            }
        }
        return (numOfBouquet >= m);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1;

        int l = 1;
        int r = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (isSafe(mid, bloomDay, m, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
