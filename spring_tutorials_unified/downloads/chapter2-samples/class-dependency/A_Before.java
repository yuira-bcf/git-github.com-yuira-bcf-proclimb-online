// クラス A（使う側）- 変更前
// クラスBを直接使用している例
public class A_Before {
    public void xxx() {
        B b = new B();
        b.methodX();
    }

    public static void main(String[] args) {
        A_Before a = new A_Before();
        System.out.println("=== クラス依存（変更前）===");
        a.xxx();
    }
}
