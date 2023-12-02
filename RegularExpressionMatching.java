
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sp, int pp) {
        if (pp >= p.length()) {
            return sp >= s.length();
        }
        
        boolean firstMatch = sp < s.length() && (p.charAt(pp) == s.charAt(sp) || p.charAt(pp) == '.');
        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            return isMatch(s, p, sp, pp + 2) || (firstMatch && isMatch(s, p, sp + 1, pp));
        } else {
            return firstMatch && isMatch(s, p, sp + 1, pp + 1);
        }
    }
}
