class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        
        for (int x : aliceSizes) sumA += x;
        for (int x : bobSizes) sumB += x;
        
        int delta = (sumA - sumB) / 2;
        
        java.util.HashSet<Integer> bobSet = new java.util.HashSet<>();
        for (int x : bobSizes) {
            bobSet.add(x);
        }
        
        for (int x : aliceSizes) {
            int target = x - delta;
            if (bobSet.contains(target)) {
                return new int[] { x, target };
            }
        }
        
        return new int[0];
    }
}