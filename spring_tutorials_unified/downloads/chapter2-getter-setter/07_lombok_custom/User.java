import lombok.Getter;
import lombok.Setter;

/**
 * Lombok + カスタムSetter・Getter
 * Lombokを使いながら、特定のフィールドだけカスタムメソッドを定義
 *
 * 【ポイント】
 * - lastName, firstName: Lombokが自動生成
 * - age: カスタムSetter（バリデーション付き）が優先される
 * - getFullName(): 新しいメソッドを追加
 *
 * 【注意】このファイルはLombokライブラリが必要です
 */
@Getter
@Setter
public class User {
    private String lastName;
    private String firstName;
    private int age;

    // ========================================
    // カスタムSetter：バリデーション付き
    // ========================================
    // Lombokの自動生成より優先される
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }

    // ========================================
    // カスタムGetter：加工した値を返す
    // ========================================
    // 新しいメソッドを追加
    public String getFullName() {
        return lastName + " " + firstName;
    }
}
