import java.util.Scanner;
public class offer_09 {

    public static boolean isPalindrome(int x) {
        String s = x+"";
        char [] s1=s.toCharArray();
        int n=s1.length;
        System.out.println(n);
        for(int i=0;i<n/2;i++){
            if(s1[i]==(s1[n-i-1])){

            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean b =isPalindrome(x);
        System.out.println(b);
    }
}
