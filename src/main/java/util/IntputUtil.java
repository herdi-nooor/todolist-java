package util;

import java.util.Scanner;

public class IntputUtil {

    private static Scanner scan = new Scanner(System.in);

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scan.nextLine();
        return data;
    }

    public static boolean isString(String info){
        String angka = "[\\p{Digit}&&[1234567890]]+";
        if (info.matches(angka)){
            return false;
        }else {
            return true;
        }
    }

}
