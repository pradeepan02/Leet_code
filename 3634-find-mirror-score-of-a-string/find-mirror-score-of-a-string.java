class Solution {
        public long calculateScore(String s) {
        LinkedList<Integer>[] seen = new LinkedList[26];
        for (int i = 0; i < 26; ++i) {
            seen[i] = new LinkedList<>();
        }
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a';
            if (seen[25 - a].isEmpty()) {
                seen[a].add(i);
            } else {
                int j = seen[25 - a].pollLast();
                res += i - j;
            }
        }
        return res;
    }
}