package design.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertToCapital extends FilterInputStream {

    public ConvertToCapital(InputStream in) {
        super(in);
    }
    @Override
    public int read() throws IOException {
        int c = in.read();
        return c == -1 ? c : Character.toUpperCase(c);
    }
}
