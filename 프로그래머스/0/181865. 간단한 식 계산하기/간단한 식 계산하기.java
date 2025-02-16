class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] command = binomial.split(" ");
        int a = Integer.parseInt(command[0]);
        int b = Integer.parseInt(command[2]);
        switch(command[1]) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
        }
        return answer;
    }
}