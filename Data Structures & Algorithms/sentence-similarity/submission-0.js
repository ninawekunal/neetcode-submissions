class Solution {
    /**
     * @param {string[]} sentence1
     * @param {string[]} sentence2
     * @param {string[][]} similarPairs
     * @return {boolean}
     */
    areSentencesSimilar(s1, s2, pairs) {
        if (s1.length !== s2.length) return false;

        const set = new Set();
        pairs.map((pair) => {
            const key = pair[0] + "-" + pair[1];
            set.add(key);
        });

        console.log(set);
        for (let i = 0; i < s1.length; i++) {
            if (s1[i] === s2[i]) continue;
            const key1 = s1[i] + "-" + s2[i];
            const key2 = s2[i] + "-" + s1[i];
            console.log(key1, key2, set.has(key1), set.has(key2));
            if (!set.has(key1) && !set.has(key2)) {
                return false;
            }
        }
        return true;
    }
}
