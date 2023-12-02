package others;
import java.util.*;
public class BaseConverter {

    public static String convert(int x, int base) {
        // x = 654
        // x = 6 * 10^2 + 5 * 10^1 + 4 * 10^0
        if (x < base) {
            return "" + x;
        }
        int curDigit = x % base;

        return "" + convert(x/base, base) + curDigit;
    }

    public static String convert(int x, int base, boolean iterative) {
        if (!iterative) {
            return convert(x, base);
        }

        Stack<String> stack = new Stack<>();

        while (x > 0) {
            int last = x % base;
            stack.push(String.valueOf(last));
            x /= base;
        }

        // x < base
        StringBuffer sb = new StringBuffer();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(15, 2, true));
    }
}