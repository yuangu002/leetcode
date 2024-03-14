package pointers;

/**
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

    For example, a string such as "substitution" could be abbreviated as (but not limited to):

    "s10n" ("s ubstitutio n")
    "sub4u4" ("sub stit u tion")
    "12" ("substitution")
    "su3i1u2on" ("su bst i t u ti on")
    "substitution" (no substrings replaced)
    The following are not valid abbreviations:

    "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
    "s010n" (has leading zeros)
    "s0ubstitution" (replaces an empty substring)
    Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

    A substring is a contiguous non-empty sequence of characters within a string.

    Example 1:

    Input: word = "internationalization", abbr = "i12iz4n"
    Output: true
    Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").

    Example 2:
    Input: word = "apple", abbr = "a2e"
    Output: false
    Explanation: The word "apple" cannot be abbreviated as "a2e".
 */
class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIdx = 0;
        int abbrIdx = 0;
        int wordLen = word.length();
        int abbrLen = abbr.length();
        while (wordIdx < wordLen && abbrIdx < abbrLen) {
            if (!Character.isDigit(abbr.charAt(abbrIdx))) {
                if (word.charAt(wordIdx++) == abbr.charAt(abbrIdx++)) {
                    continue;
                } else {
                    return false;
                }
            }
            int d = 0;
            if (abbr.charAt(abbrIdx) == '0') {
                return false;
            }
            while (abbrIdx < abbrLen && Character.isDigit(abbr.charAt(abbrIdx))) {
                d = d * 10 + (abbr.charAt(abbrIdx) - '0');
                abbrIdx++;
            }
            wordIdx += d;
        }
        return wordIdx == wordLen && abbrIdx == abbrLen;
    }
}
