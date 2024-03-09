public int getCommon(int[] nums1, int[] nums2) {

    Set<Integer> set = new HashSet<>();

    for (int e : nums1) {
        set.add(e);
    }

    for (int ans : nums2) {
        if (set.contains(ans)) {
            return ans;
        }
    }
    return -1;
}