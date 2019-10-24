package newfeatures.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinally {

    public static void test() throws Exception{
        try {
            throw new IOException("Aaaaaaaaaa");
        } catch (Exception e) {
            // e.getSuppressed();
            throw new IOException("bbbbbbbbbbbbb");
            // e.printStackTrace();
        } finally {
            throw new IOException("cccccccccccccc");
        }
    }
    public static void main(String[] args) throws Exception{
        test();


//        } catch (Exception e) {
//            e.printStackTrace();
//        }
/*        try (BufferedReader a = new BufferedReader(new FileReader(""));
             BufferedReader b = new BufferedReader(new FileReader(""))
        ){

        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

}
