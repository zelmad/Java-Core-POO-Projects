package com.zelmad.algorithmes.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            String result = String.valueOf(s.charAt(0));
            for(int i=0; i<s.length()-1; i++){
                for(int j=i+1;j<s.length(); j++){
                    String t = s.substring(i, j+1);
                    if(isPalindrome(t) && t.length() > result.length())
                        result = t;
                }
            }
            return result;
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while(left < right) {
                if (s.charAt(left++) != s.charAt(right--))
                    return false;
            }
            return true;
        }
    }
}
