package LeetcodeBootcamp.lecture2;

public class lc151 {
        public String reverseWords(String s) {
            s = s.trim();
            // Two Pointers
            int j = s.length() - 1, i = j;

            StringBuilder sb = new StringBuilder();

            while (i >= 0) {
                // Find the first space
                while (i >= 0 && s.charAt(i) != ' ') i--;

                // Find the word
                sb.append(s.substring(i + 1, j + 1) + " ");

                // Go to the next word
                while (i >= 0 && s.charAt(i) == ' ') i--;

                j = i;
            }

            // Return String
            return sb.toString().trim();
        }

}
