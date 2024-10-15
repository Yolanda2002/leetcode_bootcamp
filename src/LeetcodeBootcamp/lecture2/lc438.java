package LeetcodeBootcamp.lecture2;

import java.util.ArrayList;
import java.util.List;

public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // Count the number of alphabets
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        // Finding the left and right of List
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a']--;
            while (cnt[s.charAt(r) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // Make sure the size
            if (r - l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }
}
