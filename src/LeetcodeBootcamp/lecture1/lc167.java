package LeetcodeBootcamp.lecture1;

//HW1_1

public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
//        use two pointers
        int i=0, j=numbers.length-1;
        while (i<j) {
            int sum=numbers[i]+numbers[j];
            if (sum==target){
                return new int[]{i+1,j+1};
            }
            else if (sum<target){
                i++;
            }
            else{
                j--;
            }
        }
    return null;
    }
}
