public class offer_14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int n = strs[0].length();
        String s= "";
        //["flower","flower","flower","flower"]
        int min= strs[0].length();
        for(int i=1;i< strs.length;i++){
            if(strs[i].length()<min){
                min = strs[i].length();
            }
        }
        for(int i=0;i<min;i++){
            for(int j=1;j< strs.length;j++){
                    if(strs[j-1].charAt(i)==strs[j].charAt(i)){ }
                else{ return s; }
            }
            s+=strs[0].charAt(i);
        }
        return s;
    }
    public static void main(String[] args) {
        String [] s1 = {"caa","","a","acb"};
        String s = longestCommonPrefix(s1);
        System.out.println(s);
    }
}
