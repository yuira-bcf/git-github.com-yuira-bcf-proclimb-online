package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.example.impl.FieldInjectionExample;
import com.example.demo.example.impl.SetterInjectionExample;
import com.example.demo.example.impl.ConstructorInjectionExample;
import com.example.demo.example.impl.ConstructorInjectionOmitExample;
import com.example.demo.example.impl.ConstructorInjectionLombokExample;

/**
 * Beanの参照を渡す方法 サンプルアプリケーション
 *
 * 5つの方法を比較できます：
 * 1. フィールドに渡す（フィールドインジェクション）
 * 2. セッターメソッド経由で渡す（セッターインジェクション）
 * 3. コンストラクタ経由で渡す（コンストラクタインジェクション）
 * 4. コンストラクタ経由で渡す（@Autowired省略版）
 * 5. コンストラクタ経由で渡す（Lombok使用版）
 */
@SpringBootApplication
public class InjectionSampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
            SpringApplication.run(InjectionSampleApplication.class, args);

        System.out.println();
        System.out.println("================================================");
        System.out.println("  Beanの参照を渡す方法 サンプル実行結果");
        System.out.println("================================================");
        System.out.println();

        // 1. フィールドに渡す
        context.getBean(FieldInjectionExample.class).run();
        System.out.println();

        // 2. セッターメソッド経由で渡す
        context.getBean(SetterInjectionExample.class).run();
        System.out.println();

        // 3. コンストラクタ経由で渡す
        context.getBean(ConstructorInjectionExample.class).run();
        System.out.println();

        // 4. コンストラクタ経由で渡す（@Autowired省略版）
        context.getBean(ConstructorInjectionOmitExample.class).run();
        System.out.println();

        // 5. コンストラクタ経由で渡す（Lombok使用版）
        context.getBean(ConstructorInjectionLombokExample.class).run();
        System.out.println();

        System.out.println("================================================");
        System.out.println("  ✅ 推奨：コンストラクタ経由（3, 4, 5）");
        System.out.println("  ❌ 非推奨：フィールドに渡す（1）");
        System.out.println("================================================");

        context.close();
    }
}
