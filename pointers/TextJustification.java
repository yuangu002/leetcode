package pointers;

import java.util.*;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words,
    the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left-justified, and no extra space is inserted between words.

    Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.
    

    Example 1:

    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
    [
    "This    is    an",
    "example  of text",
    "justification.  "
    ]
    Example 2:

    Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    Output:
    [
    "What   must   be",
    "acknowledgment  ",
    "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
    Note that the second line is also left-justified because it contains only one word.
    Example 3:

    Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
    Output:
    [
    "Science  is  what we",
    "understand      well",
    "enough to explain to",
    "a  computer.  Art is",
    "everything  else  we",
    "do                  "
    ]

 */
class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> ans = new ArrayList<>();
        while (left < words.length) {
            int mostRight = findRight(words, left, maxWidth);
            String line = justifyLine(words, left, mostRight, maxWidth);
            ans.add(line);
            left = mostRight + 1;
        }
        return ans;
    }

    private int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int sumLen = words[right++].length();
        while (right < words.length && sumLen + 1 + words[right].length() <= maxWidth) {
            sumLen = sumLen + 1 + words[right].length();
            ++right;
        }
        return right - 1;
    }

    private String justifyLine(String[] words, int left, int right, int maxWidth) {
        boolean isLastLine = (right == words.length - 1);
        int size = right - left;
        if (size == 0) {
            return fillLine(words[left], maxWidth);
        }
        int sumChar = countTotalLen(words, left, right);
        int spaceBetweenChar = isLastLine ? 1 : (maxWidth - sumChar) / size;
        int modSpace = isLastLine ? 0 : (maxWidth - sumChar) % size;
        StringBuffer sb = new StringBuffer(); 
        for (int i = left; i <= right; ++i) {
            sb.append(words[i]);
            if (i == right) {
                continue;
            }
            sb.append(getSpace(spaceBetweenChar));
            if (modSpace > 0) {
                sb.append(" ");
                modSpace--;
            }
        }
        
        return fillLine(sb.toString(), maxWidth);
    }

    private String fillLine(String s, int maxWidth) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < maxWidth - s.length(); ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getSpace(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int countTotalLen(String[] words, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; ++i) {
            cnt += words[i].length();
        }
        return cnt;
    }
}
