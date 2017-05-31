package misc;

import java.util.Date;

public class FinalEx {

    private final int id;
    private final String name;
    private final Date date;

    public FinalEx(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = new Date(date.getTime());
    }
}
