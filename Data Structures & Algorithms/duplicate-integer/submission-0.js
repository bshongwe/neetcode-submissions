class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        const numbers = new Set();
        for (let num of nums)
        {
            if (numbers.has(num))
            {
                return true;
            }
            else
            {
                numbers.add(num);
            }
        }
        return false;
    }
}
