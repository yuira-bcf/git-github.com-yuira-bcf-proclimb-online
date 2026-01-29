/**
 * Setterを使う場合の例
 * バリデーション（値のチェック）により不正な値を拒否できる
 */
public class User {
    private String name;  // privateなので外部から直接アクセス不可
    private int age;

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }

    // Getter（値を取得するため）
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
