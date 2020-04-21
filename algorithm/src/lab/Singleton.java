package lab;

/**
 * @author lixinglin
 * @date 2020/4/20 11:25 下午
 * @since jdk 1.8
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    public static class SingletonHolder {
        private static final Singleton singleton = new Singleton();

    }



}
