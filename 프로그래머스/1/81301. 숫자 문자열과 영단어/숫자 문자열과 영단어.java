class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = '0';
            if(isNumber(c)) {
                sb.append(c);
            } else {
                switch(c) {
                    case 'z': 
                        sb.append(0);
                        i += 3;
                        break;
                    case 'o':
                        sb.append(1);
                        i += 2;
                        break;
                    case 't':
                        c2 = s.charAt(i + 1);
                        if (c2 == 'w') {
                            sb.append(2);
                            i += 2;
                        } else {
                            sb.append(3);
                            i += 4;
                        }
                        break;
                    case 'f':
                        c2 = s.charAt(i + 1);
                        if (c2 == 'o') {
                            sb.append(4);
                            i += 3;
                        } else {
                            sb.append(5);
                            i += 3;
                        }
                        break;
                    case 's':
                        c2 = s.charAt(i + 1);
                        if (c2 == 'i') {
                            sb.append(6);
                            i += 2;
                        } else {
                            sb.append(7);
                            i += 4;
                        }
                        break;
                    case 'e':
                        sb.append(8);
                        i += 4;
                        break;
                    case 'n':
                        sb.append(9);
                        i += 3;
                        break;
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
    boolean isNumber(char c) {
        return c <= '9' && c >= '0';
    }
}