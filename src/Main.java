import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = 0;
        int h = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            if (height[i] <= height[j]) {
                area = Math.max(area, (j - i) * height[i]);
                ++i;
            } else {
                area = Math.max(area, (j - i) * height[j]);
                --j;
            }
        }

        System.out.println(area);
    }
}
