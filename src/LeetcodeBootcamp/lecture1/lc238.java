package LeetcodeBootcamp.lecture1;

import java.util.Arrays;

public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
//        Create a new array for products ahead
        int[] ans=new int[n];
        Arrays.fill(ans,1);

//        Multiple left and right separately
        int left =1;
        int right =1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*= left;
            ans[j]*= right;
            left *=nums[i];
            right *=nums[j];
        }
        return ans;
    }
}
