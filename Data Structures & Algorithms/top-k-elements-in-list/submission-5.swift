class Solution {
    func topKFrequent(_ nums: [Int], _ k: Int) -> [Int] {
        // #1. Count frequency of each num
        var freqMap = [Int: Int]()
        for num in nums {
            freqMap[num, default: 0] += 1
        }

        // #2. Create buckets:
        //  - index = frequency
        //  - value = list of nums
        //  - nums.length = max possible frequency of nums
        var buckets = [[Int]](repeating: [], count: nums.count + 1)
        for (num, freq) in freqMap {
            buckets[freq].append(num)
        }

        // #3. Walk buckets frequency down to 1, in descending order,
        // collecting nums until we have k
        var result = [Int]()
        for freq in stride(from: nums.count, through: 1, by: -1) {
            if !buckets[freq].isEmpty {
                for num in buckets[freq] {
                    result.append(num)
                    if result.count == k {
                        return result
                    }
                }
            }
        }

        return result
    }
}
