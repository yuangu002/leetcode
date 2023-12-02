package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = "";
        int l = strs.length;
        int ptr = 0;
        int shortest = getShortestStr(strs);
        while (ptr < shortest){
            int[] count = new int[26];
            for (int i = 0; i < l; i++){
                count[strs[i].charAt(ptr)-'a']++;
            }
            if (count[strs[0].charAt(ptr)-'a'] == l) res = res + strs[0].charAt(ptr);
            else break;
            ptr++;
        }
        return res;
    }

    private int getShortestStr(String[] strs){
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++){
            if (res > strs[i].length()) res = strs[i].length();
        }
        return res;
    }
}
