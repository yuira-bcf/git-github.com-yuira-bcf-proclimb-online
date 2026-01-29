package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.BusinessLogic;
import com.example.demo.service.impl.SampleLogicImpl;
import com.example.demo.service.impl.TestLogicImpl;

/**
 * Java Configクラス
 *
 * 【ポイント】
 * - @Configuration: このクラスが設定クラスであることを示す
 * - @Bean: メソッドがBeanを返すことを示す
 *
 * この方法では、@Componentを使わずに明示的にnewして
 * DIコンテナにBeanを登録します。
 */
@Configuration
public class AppConfig {

    /**
     * TestLogicImpl を "test" という名前でBean登録
     *
     * @return TestLogicImpl のインスタンス
     */
    @Bean(name = "test")
    public BusinessLogic testLogic() {
        return new TestLogicImpl();
    }

    /**
     * SampleLogicImpl を "sample" という名前でBean登録
     *
     * @return SampleLogicImpl のインスタンス
     */
    @Bean(name = "sample")
    public BusinessLogic sampleLogic() {
        return new SampleLogicImpl();
    }
}
