public class Integer2Roman {
    class Solution {
        public String intToRoman(int num) {
            String[] qian = {"", "M", "MM", "MMM"};
            String[] bai = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] shi = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] ge = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return qian[num/1000]+bai[(num%1000)/100]+shi[(num%100)/10]+ge[num%10];
        }
    }
}