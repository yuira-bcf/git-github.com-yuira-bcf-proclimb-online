/**
 * Lombokを使わない場合のメインクラス
 *
 * 【実行方法】
 * javac *.java
 * java Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();

        user.setName("田中太郎");
        user.setAge(25);

        System.out.println("=== Lombokを使わない場合 ===");
        System.out.println("名前: " + user.getName());  // 田中太郎
        System.out.println("年齢: " + user.getAge());   // 25
    }
}
