/**
 * Getterを使う場合のメインクラス
 *
 * 【実行方法】
 * javac *.java
 * java Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("田中", "太郎");

        System.out.println("=== Getterを使う場合 ===");

        // Getterを呼ぶだけでフルネームを取得できる
        System.out.println("フルネーム: " + user.getFullName());  // 田中 太郎

        // どこでも同じメソッドを呼ぶだけ（コードの重複なし）
        System.out.println("フルネーム: " + user.getFullName());  // 田中 太郎

        System.out.println("\n【メリット】");
        System.out.println("- 加工処理を1箇所に集約");
        System.out.println("- 変更時はGetterのみ修正");
    }
}
