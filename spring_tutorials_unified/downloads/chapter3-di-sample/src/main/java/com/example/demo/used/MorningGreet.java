package com.example.demo.used;

import org.springframework.stereotype.Component;

/**
 * 朝の挨拶を行う
 *
 * @Component アノテーションを付与することで、
 * Spring FrameworkがこのクラスをDIコンテナに登録します。
 */
@Component
public class MorningGreet implements Greet {
    @Override
    public String greeting() {
        return "おはようございます";
    }
}
