package java8;

public enum Singleton {
    INSTANCE;

    private int a;
    private int b;

    Singleton() {

    }
    public void print() {
        System.out.println(a + b);
    }

    public void set(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
