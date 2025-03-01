class Solution {
    public int maxFrequency(int[] nums, int k) {
        int[] cnt=new int[51];
        int res=0;
        for(int a: nums){
            cnt[a] = Math.max(cnt[a], cnt[k]) + 1;
            res=Math.max(res, cnt[a]-cnt[k]);
        }
        return cnt[k] + res;
    }
}