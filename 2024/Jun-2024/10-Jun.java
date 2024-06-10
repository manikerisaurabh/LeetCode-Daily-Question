public class 10-Jun {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h : heights) {
            count[h]++;
        }

        int ans = 0, id = 1;
        for (int i = 0; i < heights.length; i++) {
            while (count[id] == 0) {
                id++;
            }

            if (heights[i] != id) {
                ans++;
            }
            count[id]--;
        }
        return ans;
    }
}
