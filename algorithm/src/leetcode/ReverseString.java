package leetcode;

/**
 * 输入 abc.%%.123.ff
 * 输出 ff-123-%%-abc
 *
 * @author lixinglin
 * @date 2020/4/8 2:09 下午
 * @since jdk 1.8
 */
public class ReverseString {

    public static void main(String[] args) {
        String string = "abc.%%.123.ff";
        String reverse = ReverseString.reverse(string);

        System.out.print(reverse);
    }

    public static String reverse(String string) {

        StringBuilder result = new StringBuilder();

        String[] arrays = string.split("\\.");

        for (int i = arrays.length - 1; i >= 0; i--) {
            if (arrays[i] == null) {
                result.append("-");
                continue;
            }
            result.append(arrays[i]).append("-");
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }


}
