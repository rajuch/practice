package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

    }
}
