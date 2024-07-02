public class 02-Jul {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> track = new HashMap<>();
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;

        for (int x : nums1) {
            track.put(x, track.getOrDefault(x, 0) + 1);
        }

        for (int x : nums2) {
            if (track.getOrDefault(x, 0) > 0) {
                temp[index++] = x;
                track.put(x, track.get(x) - 1);
            }
        }

        return Arrays.copyOf(temp, index);
    }
}
