import lombok.Getter;
import lombok.Setter;

/**
 * Lombokを使う場合（約8行）
 * @Getter と @Setter を付けるだけで自動生成される
 *
 * 【注意】このファイルはLombokライブラリが必要です
 * Mavenの場合、pom.xmlに以下を追加：
 * <dependency>
 *     <groupId>org.projectlombok</groupId>
 *     <artifactId>lombok</artifactId>
 *     <scope>provided</scope>
 * </dependency>
 */
@Getter
@Setter
public class User {
    private String name;
    private int age;
}
