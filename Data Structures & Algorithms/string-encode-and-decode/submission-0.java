class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder("");

        List<Integer> sizeList = new ArrayList<>();
        for(String str: strs){
            int len = str.length();
            sb.append(len);
            sb.append(",");

        }
        sb.append("#");
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() ==0 ){
            return Collections.emptyList();
        }

        int i=0;
        List<Integer> sizeList = new ArrayList<>();
        while(str.charAt(i)!='#'){
            StringBuilder cur =new StringBuilder();
            while(str.charAt(i)!=','){
                cur.append(str.charAt(i));
                i++;
            }

            int size = Integer.parseInt(cur.toString());
            sizeList.add(size);
            i++;
        }
        
        i++;
        List<String> res = new ArrayList<>();
        for(int size: sizeList){
            String output = str.substring(i, size+i);
            i +=size;
            res.add(output);

        }
        return res;
    }
}
