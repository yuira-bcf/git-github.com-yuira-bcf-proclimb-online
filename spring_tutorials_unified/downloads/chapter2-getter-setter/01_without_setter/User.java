/**
 * Setterを使わない場合の例
 * publicフィールドに直接アクセスするため、不正な値も設定されてしまう
 */
public class User {
    public String name;  // publicなので外部から直接アクセス可能
    public int age;
}
