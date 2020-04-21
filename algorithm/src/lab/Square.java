package lab;

/**
 * @author lixinglin
 * @date 2020/4/21 5:16 下午
 * @since jdk 1.8
 */
public class Square {


    public static void main(String[] args) {
        int square = Square.square(2, 0);
        System.out.println(square);
    }

    public static int square(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * square(a, n - 1);
    }
}
