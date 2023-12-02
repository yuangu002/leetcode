package others;

public class Roman2Integer {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'V':
                    res+=5;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'M':
                    res+=1000;
                    break;
                case 'I':
                    if (i+1 < s.length()){
                        if (s.charAt(i+1)=='V') {
                            res+=4;
                            i++;
                        }
                        else if (s.charAt(i+1)=='X') {
                            res+=9;
                            i++;
                        }
                        else res++;
                    }else res++;
                    break;
                case 'X':
                    if (i+1 < s.length()){
                        if (s.charAt(i+1)=='L') {
                            res+=40;
                            i++;
                        }
                        else if (s.charAt(i+1)=='C') {
                            res+=90;
                            i++;
                        }
                        else res+=10;
                    }else res+=10;
                    break;
                case 'C':
                    if (i+1 < s.length()){
                        if (s.charAt(i+1)=='D') {
                            res+=400;
                            i++;
                        }
                        else if (s.charAt(i+1)=='M') {
                            res+=900;
                            i++;
                        }
                        else res+=100;
                    }else res+=100;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
