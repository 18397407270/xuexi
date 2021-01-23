import java.util.Scanner;
public class Bu_ma {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        changeBu(a);
    }

    /*private static void To_two_jinzhi1(int a) {
        for(int i = 31;i >= 0; i--) {
            System.out.print(a >>> i & 1);
        }
    }*/

   /* private static int To_two_jinzhi(int a) {
        int a2=0;
        int a3=0;
        int i = 0;
        while(a!=0){
            a2=a%2;
            a = a/2;
            a3 +=a2*Math.pow(10,i);
            i++;
        }
        return a3;
    }*/

    private static void changeBu(int a) {


    }
}
