// クラス A（使う側）
// インターフェースを型として使用することで、
// 実装クラスの変更が容易になります
public class A {
    public void xxx() {
        // インターフェースを型として宣言
        I i = new B();  // ← ここだけ変更すればOK（new C() に変更可能）
        i.methodX();
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("=== インターフェース依存 ===");
        a.xxx();

        System.out.println("\n【ポイント】");
        System.out.println("BからCに変更する場合、new B() → new C() の1箇所のみ変更");
        System.out.println("変数の型(I)とメソッド呼び出し(i.methodX())は変更不要です");
    }
}
