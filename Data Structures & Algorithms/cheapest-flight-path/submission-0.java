class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        // Initialize distances
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] newPrices = Arrays.copyOf(prices, n);

            for (int[] flight: flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (prices[from] != Integer.MAX_VALUE) {
                    newPrices[to] = Math.min(newPrices[to], prices[from] + price);
                }
            }

            prices = Arrays.copyOf(newPrices, n);
            System.out.println("prices: " + Arrays.toString(prices));
        }
        if (prices[dst] != Integer.MAX_VALUE) return prices[dst];
        return -1;
    }
}
