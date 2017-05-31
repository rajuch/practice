package misc;

abstract class AbstractEx1 {
    int val;
    public AbstractEx1() {
        System.out.println("In parent default constructor");
    }
    public AbstractEx1(int val) {
        System.out.println("in parent parameer constructor");
        this.val = val;
    }
    void print() {

    }
}

class Child extends AbstractEx1 {

    public Child() {
        System.out.println("In child default");
    }
    public Child(int val) {
        super(val);
        System.out.println("in child parameter");
    }

    public void print() {
        val = 10;
        try {
            System.out.println("some thing");
            return;
        } finally {
            System.out.println("in finally");
        }

    }
}

public class AbstractEx {

    public static void main(String[] args) {
        AbstractEx1 obj = new Child();
        AbstractEx1 obj1 = new Child(10);

        int[] abc = new int[5];
        System.out.println(abc);

        obj1.print();
    }
}


