/**
 * Getterを使う場合の例
 * 加工した値を返すことができる
 */
public class User {
    private String lastName;   // privateなので外部から直接アクセス不可
    private String firstName;

    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    // 加工した値を返すGetter
    public String getFullName() {
        return lastName + " " + firstName;
    }
}
