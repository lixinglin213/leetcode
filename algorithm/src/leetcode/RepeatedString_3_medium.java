package leetcode;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author lixinglin
 * @date 2020/4/19 10:54 下午
 * @since jdk 1.8
 */
public class RepeatedString_3_medium {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = RepeatedString_3_medium.lengthOfLongestSubstring(str);
        System.out.print(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        String sub = "";
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            String charStr = s.charAt(i) + "";

            if (tmp.contains(charStr)) {
                if (tmp.length() > sub.length()) {
                    sub = tmp;
                }
                i = i - tmp.length() + 1;
                tmp = "";
            }
            tmp += s.charAt(i);
        }
        return tmp.length() > sub.length() ? tmp.length() : sub.length();
    }

}
