/**
 * Lombokを使わない場合（従来の書き方）
 * 手動でGetter・Setterを記述（約25行）
 */
public class User {
    private String name;
    private int age;

    // Getter: nameの値を取得
    public String getName() {
        return name;
    }

    // Setter: nameに値を設定
    public void setName(String name) {
        this.name = name;
    }

    // Getter: ageの値を取得
    public int getAge() {
        return age;
    }

    // Setter: ageに値を設定
    public void setAge(int age) {
        this.age = age;
    }
}
