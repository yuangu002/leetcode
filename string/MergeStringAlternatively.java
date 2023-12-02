package string;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

    Return the merged string
 */
public class MergeStringAlternatively {
    public String mergeStringAlternatively(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int m = word1.length();
        int n = word2.length();
        int i = 0, j = 0;

        while (sb.length() < m + n) {
            if (i < m) {
                sb.append(word1.charAt(i++));
            }
            if (j < n) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}