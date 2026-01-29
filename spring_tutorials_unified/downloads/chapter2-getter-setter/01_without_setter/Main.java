/**
 * Setterを使わない場合のメインクラス
 *
 * 【実行方法】
 * javac *.java
 * java Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.name = "田中太郎";  // 直接代入
        user.age = 25;

        System.out.println("=== Setterを使わない場合 ===");
        System.out.println("名前: " + user.name);
        System.out.println("年齢: " + user.age);

        // 問題：不正な値もそのまま設定されてしまう
        user.name = "";     // 空文字もOK
        user.age = -5;      // 負の値もOK ← バグの原因になる

        System.out.println("\n--- 不正な値を設定後 ---");
        System.out.println("名前: '" + user.name + "' (空文字)");
        System.out.println("年齢: " + user.age + " (負の値!)");
    }
}
