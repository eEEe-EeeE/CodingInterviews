package question2.solution;

// 饿汉模式
public class Singleton2 {
    private Singleton2() {
        System.out.println("I'm Singleton2.");
    }

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance() {
        return instance;
    }
}
