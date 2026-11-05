class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int min=nums[0];
        int max=nums[0];
        int ans=max;
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int temp=Math.max(curr,Math.max(curr*min,curr*max));
            min=Math.min(curr,Math.min(curr*min,curr*max));
            max=temp;
            ans=Math.max(max,ans);
        }
        return ans;
    }
}