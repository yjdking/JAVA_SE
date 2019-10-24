package newfeatures.java7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Decimal {
    // 32767
    private static short max = Short.MAX_VALUE;
    // testsh = 14;
    private static int testsh1 = 015;
    private static int testsh11 = 16;
    private static short testsh2 = 0b10100;
    private static short testsh3 = (short)32767;
    private static short testsh4 = 0b1010;


    public static void main(String[] args){
        Decimal decimal = new Decimal();
        System.out.println(testsh1);
        System.out.println(testsh2);
        System.out.println(testsh3);
        System.out.println(testsh4);

        try (BufferedReader a = new BufferedReader(new FileReader(""));
             BufferedReader b = new BufferedReader(new FileReader(""))
        ){

        } catch (Exception e) {

        }
    }

}
