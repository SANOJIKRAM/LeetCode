class Solution {
    public int removeDuplicates(int[] nums) {
        
        int next=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1]){
                nums[next]=nums[i];
                next++;
            }
        }
        return next;
    }
}

