class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] neg=new int[nums.length/2];
        int n=0;
        int[] pos=new int[nums.length/2];
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) neg[n++]=nums[i];
            if(nums[i]>0) pos[m++]=nums[i];
        }
        int res[]=new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length/2;i++){
              res[index++]=pos[i];
              res[index++]=neg[i];
        }
        return res;
    }
}