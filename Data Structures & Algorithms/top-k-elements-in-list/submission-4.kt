class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // #1. Count frequency of each num
        val freqMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        // #2. Create buckets:
        //  - index = frequency
        //  - value = list of nums
        //  - nums.length = max possible frequency of nums
        val buckets = Array<MutableList<Int>?>(nums.size + 1) { null }
        for ((num, freq) in freqMap) {
            if (buckets[freq] == null) {
                buckets[freq] = mutableListOf()
            }
            buckets[freq]?.add(num)
        }

        // #3. Walk buckets frequency down to 1, in descending order,
        // collecting nums until we have k
        val result = mutableListOf<Int>()
        for (freq in nums.size downTo 1) {
            val currentBucket = buckets[freq]
            if (currentBucket != null) {
                for (num in currentBucket) {
                    result.add(num)
                    if (result.size == k) {
                        break
                    }
                }
            }
            if (result.size == k) break
        }

        return result.toIntArray()
    }
}
