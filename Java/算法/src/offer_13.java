import java.util.Scanner;
public class offer_13 {

    public  static int getvalue(char s){
        if(s=='M'){
            return 1000;
        }else if(s=='D'){
            return 500;
        }else if(s=='C'){
            return 100;
        }else if(s=='L'){
            return 50;
        }else if(s=='X'){
            return 10;
        }else if(s=='V'){
            return 5;
        }else{
            return 1;
        }
    }
    public static int RomanToint(String s)
    {
        int sum=0;
        int pre = getvalue(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int cur = getvalue(s.charAt(i));

            if(pre<cur){
                sum-=pre;
            }else{
                sum+=pre;
            }
            pre = cur;
        }
        sum+=pre;
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int r = RomanToint(s);
        System.out.println(r);

    }
}
