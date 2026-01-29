/**
 * Setterを使う場合のメインクラス
 *
 * 【実行方法】
 * javac *.java
 * java Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("田中太郎");  // OK
        user.setAge(25);           // OK

        System.out.println("=== Setterを使う場合 ===");
        System.out.println("名前: " + user.getName());
        System.out.println("年齢: " + user.getAge());

        // 不正な値は設定されない（バリデーションで拒否）
        user.setName("");   // 無視される
        user.setAge(-5);    // 無視される ← データが保護される

        System.out.println("\n--- 不正な値を設定しようとした後 ---");
        System.out.println("名前: " + user.getName() + " (変わらない)");
        System.out.println("年齢: " + user.getAge() + " (変わらない)");
    }
}
