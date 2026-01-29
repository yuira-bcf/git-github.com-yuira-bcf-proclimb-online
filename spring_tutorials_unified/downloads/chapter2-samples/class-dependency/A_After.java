// クラス A（使う側）- 変更後
// クラスBからクラスCに変更した例
// ※型名と変数名の両方を変更する必要がある
public class A_After {
    public void xxx() {
        C c = new C();  // ← 型も変更
        c.methodX();    // ← 変数名も変更
    }

    public static void main(String[] args) {
        A_After a = new A_After();
        System.out.println("=== クラス依存（変更後）===");
        a.xxx();
    }
}
