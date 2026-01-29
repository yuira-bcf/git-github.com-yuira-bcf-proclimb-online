/**
 * Lombokを使う場合のメインクラス
 * 呼び出し側のコードはLombokなしの場合と全く同じ
 *
 * 【注意】このファイルはLombokライブラリが必要です
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();

        // Lombokあり・なしに関わらず、使い方は同じ
        user.setName("田中太郎");
        user.setAge(25);

        System.out.println("=== Lombokを使う場合 ===");
        System.out.println("名前: " + user.getName());  // 田中太郎
        System.out.println("年齢: " + user.getAge());   // 25
    }
}
