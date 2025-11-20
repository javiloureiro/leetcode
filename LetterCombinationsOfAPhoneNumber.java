class Solution {

    Map<Character, String> map = new HashMap<>();


    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");   

        dfs(0, digits, new StringBuilder());
        return result;
    }

    public void dfs (int index, String digits, StringBuilder curr){

        if(curr.length() == digits.length()){
            result.add(curr.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for(int i = 0; i < letters.length(); i++){
            curr.append(letters.charAt(i));
            dfs(index + 1, digits, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
