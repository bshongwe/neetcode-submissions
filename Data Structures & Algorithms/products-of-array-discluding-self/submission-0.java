class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int [n];

        int rL = 1;
        for (int i = 0; i < n; i++) {
            res[i] = rL;
            rL *= nums[i];
        }

        int rR = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rR;
            rR *= nums[i];
        }

        return res;
        
    }
}  


// ------------------------------------------
// Question details:
// --- Int array nums
// --- return an array >> answer[i] = prod of all
//     elems, except nums[i]
// --- should fit in 32-bit int, algorithm runs @ O(n)
//     without using division operation

// Example 1:
//     - Input: nums = [1, 2, 3, 4]
//     - Output: [24, 12, 8, 6]

// Example 2:
//     - Input: nums = [-1, 1, 0, -3, 3]
//     - Output: [0, 0, 9, 0, 0]