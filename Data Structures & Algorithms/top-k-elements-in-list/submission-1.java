class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // #1. Count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // #2. Create buckets:
        //  - index = frequency
        //  - value = list of nums
        //  - nums.length = max possible frequency of nums
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // #3. Walk buckets frequency down to 1, in descending order,
        // collecting nums until we have k
        List<Integer> result = new ArrayList<>();
        for (int freq = nums.length; freq >= 1 && result.size() < k; freq--) {
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    result.add(num);
                    if (result.size() == k) {
                        break;
                    }
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}
