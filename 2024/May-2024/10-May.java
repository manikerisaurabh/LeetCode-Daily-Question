public class 10-May {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] x, int[] y) {
        double ratioX = (double) x[1] / x[0];
        double ratioY = (double) y[1] / y[0];
        return Double.compare(ratioX, ratioY);
    }
});
        
        for (int i = 0 ; i < n ; i++) {
            for  (int j = i+1 ; j < n ; j++) {
                maxHeap.add(new int[] {arr[i], arr[j]});
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        
        return maxHeap.peek();
    }
}
