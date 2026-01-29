/**
 * Getterを使わない場合のメインクラス
 *
 * 【実行方法】
 * javac *.java
 * java Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.lastName = "田中";
        user.firstName = "太郎";

        System.out.println("=== Getterを使わない場合 ===");

        // 問題：フルネームを取得するたびに結合処理を書く必要がある
        String fullName1 = user.lastName + " " + user.firstName;
        System.out.println("フルネーム1: " + fullName1);  // 田中 太郎

        // 別の場所でも同じ処理を書く必要がある（コードの重複）
        String fullName2 = user.lastName + " " + user.firstName;
        System.out.println("フルネーム2: " + fullName2);  // 田中 太郎

        System.out.println("\n【問題点】");
        System.out.println("- 使う側で毎回同じ処理を書く必要がある");
        System.out.println("- フォーマット変更時に全箇所修正が必要");
    }
}
