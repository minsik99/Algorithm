import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.equals("")) {
            return p;
        }
        return transform(p);
    }

    private String transform(String p) {
        if (p.equals("")) {
            return p;
        }

        int balance = 0;
        int index = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                index = i + 1;
                break;
            }
        }

        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isValid(u)) {
            return u + transform(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(transform(v));
            sb.append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }
    
    private boolean isValid(String u) {
        int balance = 0;
        for (char c : u.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}