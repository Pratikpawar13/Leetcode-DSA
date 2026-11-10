class Solution {
    public boolean canJump(int[] nums) {
        int finall=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=finall) finall=i;
        }
        return finall==0?true:false;
    }
}