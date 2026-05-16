class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        let right = 1;
        let index = 0;

        for(let num of nums)
        {
            for(let k of nums.slice(right))
            {
                if (index === right)
                {
                    continue;
                }

                if (num == k)
                {
                    return true;
                }
            }
            index += 1;
            right += 1;

        }
        return false;
    }
}
