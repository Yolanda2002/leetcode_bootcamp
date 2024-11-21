package LeetcodeBootcamp.lecture8;

public class lc416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i : nums) sum += i;
        int target = sum / 2;

        if (target * 2 != sum) return false;

        int[][] f = new int[n][target + 1];
        for (int j = 0; j <= target; j++) {
            f[0][j] = j >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                int no = f[i-1][j];
                int yes = j >= t ? f[i-1][j-t] + t : 0;
                f[i][j] = Math.max(no, yes);
            }
        }
        return f[n-1][target] == target;
    }
}
