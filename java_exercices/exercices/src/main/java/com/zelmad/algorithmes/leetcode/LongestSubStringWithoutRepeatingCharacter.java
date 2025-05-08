package com.zelmad.algorithmes.leetcode;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abababababa";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                StringBuilder subStr = new StringBuilder(s.charAt(i) + "");
                for (int j = i + 1; j < s.length(); j++) {
                    if (subStr.indexOf(s.charAt(j) + "") != -1) {
                        if(subStr.length() > max)
                            max = subStr.length();
                        break;
                    } else {
                        subStr.append(s.charAt(j) + "");
                    }
                }
                max = (subStr.length() > max) ? subStr.length() : max;
            }
            max = (max == 0 && s.length() > 0) ? 1 : max;
            return max;
        }
    }
}