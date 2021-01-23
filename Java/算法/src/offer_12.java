import java.util.Scanner;
public class offer_12 {


    public static String intToRoman(int num)
    {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder str = new StringBuilder();
        for(int i=0;i<values.length&&num>0;i++){
            while(values[i]<=num){
                num -= values[i];
                str.append(symbols[i]);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String Str = intToRoman(num);
        System.out.println(Str);
    }
}
