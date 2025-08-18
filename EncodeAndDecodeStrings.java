class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
       for (int i = 0; i < strs.size(); i++){
            sb.append(";").append(strs.get(i));
       } 

       return sb.toString();
    }

    public List<String> decode(String str) {
       List<String> list = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       char cNext = '\0';
       boolean end = false;

       for(int i = 0; i< str.length(); i++){
        char c = str.charAt(i);

        if(i < str.length()-1){
            cNext = str.charAt(i+1);
        }else{
            end = true;
        }
        

        if(c != ';'){
            sb.append(c);
        }

        if (cNext == ';' || end){
            list.add(sb.toString());
            sb = new StringBuilder();
        }
       }

        return list;
    }
}
