class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums: number[], k: number): number[] {
        // #1. Count frequency of each number
        const freqMap = new Map<number, number>();
        for (const num of nums) {
            freqMap.set(num, (freqMap.get(num) || 0) + 1);
        }

        // #2. Create buckets:
        //  - index = frequency
        //  - value = list of nums
        //  - nums.length = max possible frequency of nums
        const buckets: number[][] = new Array(nums.length + 1);
        for (const [num, freq] of freqMap) {
            if (!buckets[freq]) {
                buckets[freq] = [];
            }
            buckets[freq].push(num);
        }

        // // #3. Walk buckets frequency down to 1, in descending order,
        // collecting nums until we have k
        const result: number[] = [];
        for (let freq = nums.length; freq >= 1 && result.length < k; freq--) {
            if (buckets[freq]) {
                for (const num of buckets[freq]) {
                    result.push(num);
                    if (result.length === k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
