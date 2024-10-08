package LeetcodeBootcamp.lecture1;

public class lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                if (max < count) {
                    max = count;
                }

            } else {
                count = 0;
            }

        }
        return max;
    }
}