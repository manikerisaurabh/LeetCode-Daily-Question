public class 08-May {
    public String[] findRelativeRanks(int[] score) {
        // Create a map to store each score's original index
        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], i);
        }

        // Sort the scores in descending order
        Arrays.sort(score);

        // Create a result array to store the ranks
        String[] result = new String[score.length];
        for (int i = score.length - 1; i >= 0; i--) {
            // Assign ranks based on the position of each score in the sorted array
            int rank = score.length - i;
            if (rank == 1) {
                result[scoreMap.get(score[i])] = "Gold Medal";
            } else if (rank == 2) {
                result[scoreMap.get(score[i])] = "Silver Medal";
            } else if (rank == 3) {
                result[scoreMap.get(score[i])] = "Bronze Medal";
            } else {
                result[scoreMap.get(score[i])] = String.valueOf(rank);
            }
        }

        return result;
    }
}
