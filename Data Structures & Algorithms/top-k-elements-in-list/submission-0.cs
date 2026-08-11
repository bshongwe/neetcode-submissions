public class Solution
{
    public int[] TopKFrequent(int[] nums, int k)
    {
        // Count the frequency of each number
        Dictionary<int, int> frequency = new Dictionary<int, int>();

        foreach (int num in nums)
        {
            if (frequency.ContainsKey(num))
            {
                frequency[num]++;
            }
            else
            {
                frequency[num] = 1;
            }
        }

        // Create buckets based on frequency
        List<int>[] buckets = new List<int>[nums.Length + 1];

        foreach (var pair in frequency)
        {
            int num = pair.Key;
            int count = pair.Value;

            if (buckets[count] == null)
            {
                buckets[count] = new List<int>();
            }

            buckets[count].Add(num);
        }

        // Get the k most frequent elements
        List<int> result = new List<int>();

        for (int count = nums.Length; count >= 1; count--)
        {
            if (buckets[count] == null)
            {
                continue;
            }

            foreach (int num in buckets[count])
            {
                result.Add(num);

                if (result.Count == k)
                {
                    return result.ToArray();
                }
            }
        }

        return result.ToArray();
    }
}

// Top K Frequent Elements
// CHALLENGE: Given an integer array nums and an integer k, return
//            the k most frequent elements within the array. The
//            test cases are generated such that the answer is
//            always unique. You may return the output in any
//            order.

// Example 1:
//          Input: nums = [1,2,2,3,3,3], k = 2
//          Output: [2,3]

// Example 2:
//          Input: nums = [7,7], k = 1
//          Output: [7]

// Constraints:
//          1 <= nums.length <= 10^4.
//          -1000 <= nums[i] <= 1000
//          1 <= k <= number of distinct elements in nums.

// -------------------------------------------------------

// Understanding the Problem:
// 	1. Count how many times each number appears in nums.
// 	2. Return the k numbers that appear most often.

// For nums = [1,2,2,3,3,3], k = 2:
//          * Frequencies: 1 → 1, 2 → 2, 3 → 3
// 	        * The 2 most frequent are 2 and 3 → Output: [2, 3]

// Key task of the challenge:
//          How efficiently you can find the "top k"
//          without fully sorting everything?