class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            return result;
        }
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> pMap = new HashMap<>();

        for(char c :p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int left = 0;
        int count = p.length();
        for(int right=0;right<s.length();right++){
            char rightChar = s.charAt(right);
            sMap.put(rightChar,sMap.getOrDefault(rightChar,0)+1);

            if(pMap.containsKey(rightChar) && sMap.get(rightChar)<=pMap.get(rightChar)){
                count--;
            }
            int length = right - left + 1;
            if(length > p.length()){
                char leftChar = s.charAt(left);
                if(pMap.containsKey(leftChar) && sMap.get(leftChar)<=pMap.get(leftChar)){
                    count++;
                }
            sMap.put(leftChar,sMap.get(leftChar)-1);
            left++;
        }
        if(count==0){
            result.add(left);
    }
}
    return result;
}
}