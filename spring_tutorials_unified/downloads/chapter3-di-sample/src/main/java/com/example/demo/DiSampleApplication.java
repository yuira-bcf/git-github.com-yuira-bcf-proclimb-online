package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.used.Greet;

/**
 * SpringBoot起動クラス
 *
 * 【DIのポイント】
 * - @Autowired で Greet インターフェースを注入
 * - new キーワードを使わない（インスタンス生成はSpringに任せる）
 * - 実装クラスの切り替えは、このクラスを変更せずに行える
 */
@SpringBootApplication
public class DiSampleApplication {

    /**
     * SpringBoot起動
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        SpringApplication.run(DiSampleApplication.class, args)
            .getBean(DiSampleApplication.class).execute();
    }

    /**
     * 注入される箇所(インターフェース)
     *
     * ここには @Component が付与された実装クラスの
     * インスタンスが自動的に注入されます。
     */
    @Autowired
    private Greet greet;

    /**
     * 実行
     */
    private void execute() {
        String msg = greet.greeting();
        System.out.println("============================");
        System.out.println("DIサンプル実行結果");
        System.out.println("============================");
        System.out.println("挨拶: " + msg);
        System.out.println("============================");
    }
}
