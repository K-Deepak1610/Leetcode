class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            return result;
        }
        Map<Character,Integer> map = new HashMap<>();

        for(char c :p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int left = 0;
        int count = p.length();
        for(int right=0;right<s.length();right++){
            char rightChar = s.charAt(right);
            int val = map.getOrDefault(rightChar,0);
            if(val>0){ 
                count--;
            }
            map.put(rightChar,val-1);
            int length = right - left + 1;
            if(length > p.length()){
            char leftChar = s.charAt(left);
            int lefVal = map.getOrDefault(leftChar,0);
            if(lefVal >=0){
                count++;
            }    
            map.put(leftChar,lefVal+1);
            left++;
        }
        if(count==0){
            result.add(left);
    }
}
    return result;
}
}