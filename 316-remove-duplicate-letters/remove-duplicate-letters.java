class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] stack = new char[len];
        int r = 0;
        int[] cnts = new int[26];
        boolean[] enter = new boolean[26];
        char[] str = s.toCharArray();
        for (char ch : str) {
            cnts[ch-'a']++;
        }
        for (char ch : str) {
            if (!enter[ch - 'a']) {
                while (r > 0 && stack[r-1] > ch && cnts[stack[r-1] - 'a'] > 0) {
                    enter[stack[r - 1] - 'a'] = false;
                    r--;
                }
                stack[r++] = ch;
				enter[ch - 'a'] = true;
            }
            cnts[ch - 'a']--;
        }
        return String.valueOf(stack, 0, r);
    }
}