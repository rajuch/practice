package java8;

public class B {

    protected int i = 0;
    static int s = 5;

    public B test() {
        printName();
        return null;
    }

    public void printName() {

    }

    private void names(Object... values) {
        System.out.println(values);
    }


    public static void main(String[] args) {
        B ob  = new B();
        ob.test();
        ob.names("raju", "fdfas");
    }
}
