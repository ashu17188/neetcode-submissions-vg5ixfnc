class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len =  nums.length;
        int  pref[] = new int[len];
        int suff[] = new int[len];

        pref[0] = 1;
        suff[len-1] = 1;
        int prd =1 ;
        for(int i =1; i< nums.length; i++){
            prd *=nums[i-1];
            pref[i] = prd;
        }
        prd =1;
        for (int i=len-2; i>=0; i--){
            prd *=nums[i+1];
            suff[i] = prd;
        }
        int res [] = new int[len];
        for(int i=0; i< len; i++){
            res[i] = pref[i] * suff[i];
        }
        return res;
    }
}  
