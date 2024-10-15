package LeetcodeBootcamp.lecture2;

public class lc8 {
    public int myAtoi(String s) {

        // Suppose everything is long.
        long num = 0;
        int n = s.length();

        // Skip spaces
        int i = 0;
        while (i < n && s.charAt(i) == ' ')
            i++;
        if (i == n)
            return 0;

        // Signedness
        int flag = 1;
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Skip zero
        while (i < n && s.charAt(i) == '0')
            i++;
        if (i == n)
            return 0;

        // Read Number
        for (; i < n; i++) {
            char c = s.charAt(i);

            if (c < '0' || c > '9') break;

            // Get Unsigned new number
            num = num * 10 + (c - '0');

            // See Overflow
            long v = num * flag;
            if (v >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (v <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (num * flag);


    }
}
