package design.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoratorEx {

    public static void main(String[] args) throws IOException {
        InputStream in = new ConvertToCapital(new BufferedInputStream(new FileInputStream("test.txt")));
        int c;
        while ((c =in.read()) != -1) {
            System.out.print((char)c);
        }
        in.close();
    }
}
