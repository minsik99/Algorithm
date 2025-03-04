class Solution {
    public int[] solution(String myString) {
        myString = "a" + myString + "a"; 
        String[] str = myString.split("x");
        int[] answer = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            if (i == 0 || i == str.length - 1) {
                answer[i] = str[i].length() - 1;
            } else {
                answer[i] = str[i].length();   
            }
        }
        return answer;
    }
}