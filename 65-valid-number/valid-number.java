import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        String regex = "^[+-]?(((\\d+\\.\\d*)|(\\.\\d+))|(\\d+))([e|E][+-]?\\d+)?$";
        return Pattern.matches(regex, s);
    }
}