import java.nio.charset.Charset;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        String text = "aa";
        String pattern = "a";
        System.out.println(Pattern.matches(pattern, text));
    }
}
