import java.util.Scanner;
class Test {
    /*
     1 5 6
     8 4 3
     2 7 9
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] ss = {
                "156843279",
                "182547639",
                "639547182",
                "972348651",
                "651348972",
                "281745936",
                "936745281",
                "279843156"
        };
        String a = input.next();
        for(int i=0;i<ss.length;i++){
            if(equal(ss[i],a)){
                System.out.println(ss[i].substring(0,3));
                System.out.println(ss[i].substring(3,6));
                System.out.println(ss[i].substring(6,9));
            }
        }

    }

    public static boolean equal(String ss, String a) {
        for(int i=0;i<ss.length();i++){
            if(ss.charAt(i)==a.charAt(i)) continue;
            if(a.charAt(i)=='0') continue;
            return false;
        }
        return true;

    }
}
