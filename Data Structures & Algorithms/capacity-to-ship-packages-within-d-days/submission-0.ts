class Solution {
    /**
     * @param {number[]} weights
     * @param {number} days
     * @return {number}
     */
    shipWithinDays(weights: number[], days: number): number {
        let total = 0;
        let max = -Infinity;
        weights.forEach((w) => {
            total += w;
            max = Math.max(max, w);
        });

        const canShipWith = (cap: number): boolean => {
            let ships = 1;
            let currentCapacity = cap;

            weights.forEach((w) => {
                if (currentCapacity - w < 0) {
                    ships += 1;
                    currentCapacity = cap;
                }
                currentCapacity -= w;
            });
            return ships <= days;
        }
        
        let left = max;
        let right = total;
        let result = total;

        // Binary search
        while (left <= right) {
            const capacity = Math.trunc(left + (right - left) / 2); 
            if (canShipWith(capacity)) {
                result = Math.min(result, capacity);
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }
        return result;
    }
}
