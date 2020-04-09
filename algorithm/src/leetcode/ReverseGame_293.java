package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。
 * 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜
 * <p>
 * 输入: s = "++++"
 * 输出:
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 *
 * @author lixinglin
 * @date 2020/4/8 2:14 下午
 * @since jdk 1.8
 */
public class ReverseGame_293 {

    public static void main(String[] args) {
        String s = "++++";
        List<String> reverse = ReverseGame_293.reverse(s);

        System.out.print(reverse.toString());
    }

    public static List<String> reverse(String s) {
        ArrayList<String> resultList = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                resultList.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }

        }
        return resultList;
    }

}
