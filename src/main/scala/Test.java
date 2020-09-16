import java.io.File;

public class Test {

    public static native void hello();

    public static native int sum(int a, int b);

    public static void main(String[] args) {
        File f = new File("BPlusTree/src/mylib.dll");
        System.load(f.getAbsolutePath());
        Test.hello();
        //System.out.println(Test.sum(20, 22));
    }
}