package leetcode;

/**
 * @author lixinglin
 * @date 2020/4/6 5:07 下午
 * @since jdk 1.8
 */
public class Hanoi {

    static int count;

    static String DESC = "第%s次移动：将第%s个盘子从%s------->%s";

    public static void main(String[] args) {
        Hanoi.hanoi(3, 'a', 'b', 'c');

    }

    public static void hanoi(int count, char a, char b, char c) {

        if (count == 1) {
            move(1, a, c);
        } else {
            hanoi(count - 1, a, c, b);
            move(count, a, c);
            hanoi(count - 1, b, a, c);
        }


    }

    public static void move(int disk, char a, char b) {
        System.out.println(String.format(DESC, ++count, disk, a, b));
    }

}
