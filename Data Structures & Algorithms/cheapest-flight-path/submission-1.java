class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // edges => k + 1;
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Bellman ford
        // relax k + 1 times
        for (int i = 0; i <= k; i++) {
            // relax all edges now
            int[] next = Arrays.copyOf(prices, n);

            for (int[] flight: flights) {
                int s = flight[0];
                int d = flight[1];
                int price = flight[2];

                if (prices[s] == Integer.MAX_VALUE) continue;

                if (next[d] > prices[s] + price) {
                    next[d] = prices[s] + price;
                }
            }
            prices = next;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1: prices[dst];
    }
}
