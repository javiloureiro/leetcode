class Solution {
    List<List<String>> result = new ArrayList<>();


    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<String>());
        return result;
    }

    public void dfs(int start, String s, List<String> path){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }


        for(int end = start; end < s.length(); end++){

            String sub = s.substring(start, end + 1);

            if(isPalindrome(sub)){
                path.add(sub);
                dfs(end + 1, s, path);
                path.remove(path.size() - 1);
            }

        }
    }

    public boolean isPalindrome(String sub){
        int i = 0;
        int j = sub.length() - 1;

        while(i<j){
            if(sub.charAt(i) != sub.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
