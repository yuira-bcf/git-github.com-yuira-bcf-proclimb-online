package com.example.demo.used;

// import org.springframework.stereotype.Component;

/**
 * 夕方の挨拶を行う
 *
 * 【切り替え方法】
 * MorningGreet の @Component をコメントアウトし、
 * このクラスの @Component のコメントを外すと、
 * 「こんばんは」が表示されるようになります。
 *
 * ポイント：DiSampleApplication.java（使う側）は
 * 一切変更せずに、挨拶の内容を切り替えられます！
 */
// @Component  // ← コメントを外すとこちらが使われる
public class EveningGreet implements Greet {
    @Override
    public String greeting() {
        return "こんばんは";
    }
}
