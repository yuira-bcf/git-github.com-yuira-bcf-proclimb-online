package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.BusinessLogic;

/**
 * SpringBoot起動クラス
 *
 * 【ポイント】
 * - @Autowired: DIコンテナからBeanの参照を受け取る
 * - @Qualifier: 同じインターフェースを実装したBeanが複数ある場合、
 *               Bean名を指定して取得する
 */
@SpringBootApplication
public class JavaConfigSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaConfigSampleApplication.class, args)
            .getBean(JavaConfigSampleApplication.class).execute();
    }

    /**
     * "test" という名前のBeanを注入
     * → TestLogicImpl のインスタンスが渡される
     */
    @Autowired
    @Qualifier("test")
    private BusinessLogic testLogic;

    /**
     * "sample" という名前のBeanを注入
     * → SampleLogicImpl のインスタンスが渡される
     */
    @Autowired
    @Qualifier("sample")
    private BusinessLogic sampleLogic;

    /**
     * 実行
     */
    private void execute() {
        System.out.println("====================================");
        System.out.println("Java Config サンプル実行結果");
        System.out.println("====================================");
        System.out.println();
        System.out.println("【testLogic（@Qualifier(\"test\")）】");
        System.out.println("  → " + testLogic.execute());
        System.out.println();
        System.out.println("【sampleLogic（@Qualifier(\"sample\")）】");
        System.out.println("  → " + sampleLogic.execute());
        System.out.println();
        System.out.println("====================================");
    }
}
