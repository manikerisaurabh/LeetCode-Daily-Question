class Solution {
    public String customSortString(String order, String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    ans.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            while (count > 0) {
                ans.append(c);
                count--;
            }
        }

        return ans.toString();
    }
}