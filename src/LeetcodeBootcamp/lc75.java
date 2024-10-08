package LeetcodeBootcamp;

public class lc75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
//        Use two pointers
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
//            If find 2,then switch space with p2
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
//            If find 0, then switch space with p0
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
