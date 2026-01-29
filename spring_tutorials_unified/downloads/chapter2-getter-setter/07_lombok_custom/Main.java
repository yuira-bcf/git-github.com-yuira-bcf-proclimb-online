/**
 * Lombok + カスタムメソッドの使用例
 *
 * 【注意】このファイルはLombokライブラリが必要です
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();

        // Lombokが自動生成したSetter
        user.setLastName("田中");
        user.setFirstName("太郎");

        // カスタムSetter（バリデーション付き）
        user.setAge(25);    // OK：設定される
        user.setAge(-5);    // NG：無視される

        System.out.println("=== Lombok + カスタムメソッド ===");

        // Lombokが自動生成したGetter
        System.out.println("姓: " + user.getLastName());     // 田中
        System.out.println("名: " + user.getFirstName());    // 太郎
        System.out.println("年齢: " + user.getAge());        // 25

        // カスタムGetter（加工した値を返す）
        System.out.println("フルネーム: " + user.getFullName());  // 田中 太郎

        System.out.println("\n【ポイント】");
        System.out.println("- lastName, firstName: Lombokが自動生成");
        System.out.println("- setAge(): カスタムメソッドが優先（バリデーション付き）");
        System.out.println("- getFullName(): 新しいメソッドを追加");
    }
}
