class Solution {
    public String countAndSay(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        StringBuilder s = new StringBuilder("1");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.setLength(0);
            char prev = s.charAt(0);
            int c = 1;
            for (int j = 1; j < s.length(); j++) {
                if (prev == s.charAt(j)) {
                    ++c;
                } else {
                    sb.append(c).append(prev);
                    prev = s.charAt(j);
                    c = 1;
                }
            }
            sb.append(c).append(prev);
            s.setLength(0);
            s.append(sb);
        }
        return s.toString();
    }
}