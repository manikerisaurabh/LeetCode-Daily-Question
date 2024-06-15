public class 15-Jun {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
    int[][] projects =new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] =capital[i];
            projects[i][1] =profits[i];

        }        
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->Integer.compare(b, a));        
        int currentCapital = w;
        int projectIndex = 0;
        for (int i = 0; i < k; i++) {

            while (projectIndex < n && projects[projectIndex][0] <= currentCapital) {
                maxHeap.add(projects[projectIndex][1]);
                projectIndex++;
        }
            if (maxHeap.isEmpty()) {
                break;
            }
            currentCapital += maxHeap.poll();

        }
        return currentCapital;
    }
}
