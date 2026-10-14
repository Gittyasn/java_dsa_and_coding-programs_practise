class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int halfLen = (m + n + 1) / 2;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = halfLen - i;

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if we have partitioned correctly
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // If total length is odd
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // If total length is even
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } else if (nums1LeftMax > nums2RightMin) {
                // Too many elements from nums1's left side, move left
                high = i - 1;
            } else {
                // Too few elements from nums1's left side, move right
                low = i + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}