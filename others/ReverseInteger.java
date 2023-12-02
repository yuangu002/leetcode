package others;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseInteger {
    // a mathematical solution: not elegant though
    // Get every digit and its corresponding divisor; get the sum of each pair's product
    // use a stack to pop each divisor out as the order is reverse
    class Solution1 {
        public int reverse(int x) {
            if (x < 10 && x > -10) return x;
            int sign = 1;
            if (x < 0) sign = -1;
            long y = Math.abs(x);
            ArrayList<Long> digit = new ArrayList<>();
            Stack<Long> div = new Stack<>();
            long divisor = 1;
            while (y != 0){
                long d = (y/divisor)%10;
                digit.add(d);
                div.push(divisor);
                y = y - d*divisor;
                divisor *= 10;
            }
            long res=0;
            for (int i = 0; i < digit.size(); i++){
                res = res + digit.get(i) * div.pop();
                // "res < 0" resolves the "Integer.MIN" case
                if (res > Integer.MAX_VALUE || res < 0) return 0;
            }
            int result = ((int) res);
            return sign*result;
        }
    }

    // the most elegant solution
    // 1326 -> 1326/10 = 132 -> 132/10 = 13 -> 13/10 = 1 -> 1/10 = 0
    class Solution2 {
        public int reverse(int x){
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
                x /= 10;
            }
            return ((int)res);
        }
    }
}
