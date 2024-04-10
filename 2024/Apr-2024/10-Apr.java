public class 10-Apr {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int n = deck.length;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.offer(i);
        }

        Arrays.sort(deck);

        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            ans[queue.poll()] = deck[i];

            queue.offer(queue.poll());
        }
        return ans;
    }
}
