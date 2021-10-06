package _06_ReflecrtionAPI;

public class TestClass {

    private int privateInt;
    public int publicInt;

    public TestClass(int pri, int pub) {
        this.privateInt = pri;
        this.publicInt = pub;
    }

    private int getPrivateInt() {
        return privateInt;
    }

    public int getPublicInt() {
        return publicInt;
    }

}
