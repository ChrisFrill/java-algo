package main.java;

public class StringCommon {

    static int longestCommonSubsequence(String s1, String s2) {
        int[][] lsc = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lsc[i + 1][j + 1] = lsc[i][j] + 1;
                } else {
                    lsc[i + 1][j + 1] = Math.max(lsc[i + 1][j], lsc[i][j + 1]);
                }
            }
        }
        return lsc[s1.length()][s2.length()];
    }

    static int longesCommonSubstring(String s1, String s2) {
        // Create a table to store lengths of longest common suffixes of substrings.
        // Note that lcs[i][j] contains length of longest common suffix of s1[0..i-1] and s2[0..j-1].
        // The first row and first column entries have no logical meaning, they are used only for simplicity of program
        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];

        // To store length of the longest common substring
        int result = 0;

        // Following steps build lcs[s1+1][s2+1] in bottom up fashion
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (s1.toCharArray()[i - 1] == s2.toCharArray()[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    result = Integer.max(result, lcs[i][j]);
                } else
                    lcs[i][j] = 0;
            }
        }
        return result;
    }
}
