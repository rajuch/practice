import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighRadiusTest implements Comparable {

    private Integer a;

    public static void main(String[] args) {
        HighRadiusTest obj = new HighRadiusTest();
        obj.a = 3;
        HighRadiusTest obj1 = new HighRadiusTest();
        obj1.a = 2;
        List<HighRadiusTest> list = new ArrayList<>();
        list.add(obj);
        list.add(obj1);
        Collections.sort(list);
        for (HighRadiusTest ob : list) {
            System.out.println(ob.a);
        }
    }

    @Override
    public int compareTo(Object o) {
        HighRadiusTest o1 = (HighRadiusTest)o;
        if (this.a == o1.a) {
            return 0;
        } else if (this.a > o1.a) {
            return -1;
        } else {
            return 1;
        }

    }
}
