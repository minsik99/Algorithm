import java.util.*;

class Solution {
    static Map<String, String> parentMap = new HashMap<>();
    static Map<String, Integer> profitMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        for (int i = 0; i < n; i++) {
            parentMap.put(enroll[i], referral[i].equals("-") ? "center" : referral[i]);
            profitMap.put(enroll[i], 0);
        }
        profitMap.put("center", 0);
        
        for (int i = 0; i < seller.length; i++) {
            distributeProfit(seller[i], amount[i] * 100);
        }   
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        
        return answer;
    }
    
    void distributeProfit(String name, int profit) {
        if (name.equals("center") || profit < 1) return;
        
        int giveToParent = profit / 10;
        int keep = profit - giveToParent;
        
        profitMap.put(name, profitMap.get(name) + keep);
        
        distributeProfit(parentMap.get(name), giveToParent);
    } 
}