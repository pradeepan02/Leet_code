class Solution {
    public boolean isNumber(String s) {
        boolean seenDec = false;
        boolean seenExp = false;
        boolean seenDigit = false;

        if(s.equals("")) return false;

        for(int i = 0; i < s.length();i++){

            char c = s.charAt(i);

            if(Character.isDigit(c)) seenDigit = true;

            //encounting sign
            else if(c == '-' || c == '+'){
                if(i > 0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')) return false;
            }
            
            //encountering exponent
            else if(c == 'e' || c == 'E'){
                if(seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false;
            }

            //encountering decimal
            else if(c == '.'){
                if(seenDec || seenExp) return false;
                seenDec = true;
            }

            else return false;
        }
        return seenDigit;
    }
}