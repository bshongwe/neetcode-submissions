
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int num : nums)
        {
            if(seen.contains(num))
            {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}