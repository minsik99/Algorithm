import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            int num = numLog[i] - numLog[i - 1];
            switch(Math.abs(num)) {
                case 1:
                    if (num > 0) 
                        answer.append('w');
                    else 
                        answer.append('s');
                    break;
                case 10:
                    if (num > 0) 
                        answer.append('d');
                    else 
                        answer.append('a');
                    break;
            }
        }
        return answer.toString();
    }
}