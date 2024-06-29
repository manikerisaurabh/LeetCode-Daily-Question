public class 29-Jun {
    private List<Integer> merge(List<Integer> parent, List<Integer> child) {
        List<Integer> sortedList = new ArrayList<>();
        int n = parent.size(), m = child.size(), i = 0, j = 0;
        while (i < n && j < m) {
            if (parent.get(i) < child.get(j)) {
                while (i + 1 < n && parent.get(i).equals(parent.get(i + 1))) i++;
                sortedList.add(parent.get(i));
                i++;
            } else if (parent.get(i) > child.get(j)) {
                while (j + 1 < m && child.get(j).equals(child.get(j + 1))) j++;
                sortedList.add(child.get(j));
                j++;
            } else {
                while (i + 1 < n && parent.get(i).equals(parent.get(i + 1))) i++;
                while (j + 1 < m && child.get(j).equals(child.get(j + 1))) j++;
                sortedList.add(child.get(j));
                i++;
                j++;
            }
        }

        while (i < n) {
            while (i + 1 < n && parent.get(i).equals(parent.get(i + 1))) i++;
            sortedList.add(parent.get(i));
            i++;
        }

        while (j < m) {
            while (j + 1 < m && child.get(j).equals(child.get(j + 1))) j++;
            sortedList.add(child.get(j));
            j++;
        }
        return sortedList;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> sortedAncestors = new HashMap<>();

        int[] degree = new int[n];
        Map<Integer, List<Integer>> gr = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[v]++;
            gr.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int node = 0; node < n; node++) {
            if (degree[node] == 0) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int node = q.poll();

                List<Integer> anc = sortedAncestors.getOrDefault(node, new ArrayList<>());
                for (int child : gr.getOrDefault(node, new ArrayList<>())) {
                    degree[child]--;
                    List<Integer> par = Arrays.asList(node);
                    sortedAncestors.put(child, merge(sortedAncestors.getOrDefault(node, new ArrayList<>()), sortedAncestors.getOrDefault(child, new ArrayList<>())));
                    sortedAncestors.put(child, merge(sortedAncestors.get(child), par));
                    if (degree[child] == 0) q.offer(child);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            ans.add(sortedAncestors.getOrDefault(node, new ArrayList<>()));
        }
        return ans;
    }
}
