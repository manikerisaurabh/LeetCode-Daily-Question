/*
====================================================== 2225. Find Players With Zero or One Losses    ======================================================


Problem Statement : You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

                    Return a list answer of size 2 where:

                    answer[0] is a list of all players that have not lost any matches.
                    answer[1] is a list of all players that have lost exactly one match.
                    The values in the two lists should be returned in increasing order.

                    Note:

                    You should only consider the players that have played at least one match.
                    The testcases will be generated such that no two matches will have the same outcome.


Examples : 

                    Example 1:
                    Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
                    Output: [[1,2,10],[4,5,7,8]]
                    Explanation:
                    Players 1, 2, and 10 have not lost any matches.
                    Players 4, 5, 7, and 8 each have lost one match.
                    Players 3, 6, and 9 each have lost two matches.
                    Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].


                    Example 2:
                    Input: matches = [[2,3],[1,3],[5,4],[6,4]]
                    Output: [[1,2,5,6],[]]
                    Explanation:
                    Players 1, 2, 5, and 6 have not lost any matches.
                    Players 3 and 4 each have lost two matches.
                    Thus, answer[0] = [1,2,5,6] and answer[1] = [].
*/


public class 15-Jan {
    public List<List<Integer>> findWinners(int[][] mat) {
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        List<List<Integer>> e = new ArrayList<>();
        for (int[] i : mat) {
            if (a.containsKey(i[0])) {
                a.put(i[0], a.getOrDefault(i[0], 0) + 1);
            } else {
                a.put(i[0], 1);
            }
        }
        for (int[] i : mat) {
            if (b.containsKey(i[1])) {
                b.put(i[1], b.getOrDefault(i[1], 0) + 1);
            } else {
                b.put(i[1], 1);
            }
        }
        System.out.print(b);
        for (int k : a.keySet()) {
            if (!b.containsKey(k)) {
                c.add(k);
            }
        }
        for (Map.Entry<Integer, Integer> s : b.entrySet()) {
            if (s.getValue() == 1) {
                d.add(s.getKey());
            }
        }
        Collections.sort(c);
        Collections.sort(d);
        e.add(c);
        e.add(d);
        return e;
    }
}
