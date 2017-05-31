package java8;

class ParentEx {

    public ParentEx test() {
        System.out.println("in parent");
        return this;
    }

    public void test1() {
        System.out.println("in parent test1");
    }
}

public class Child extends ParentEx {

    public ParentEx ex() {
        return test();
    }

    public void cantCallFromParent() {
        System.out.println("hehe");
    }

    public static void main(String[] args) {
        Child child = new Child();
        Child ch1 = (Child)child.ex();
        ch1.cantCallFromParent();
    }
}
