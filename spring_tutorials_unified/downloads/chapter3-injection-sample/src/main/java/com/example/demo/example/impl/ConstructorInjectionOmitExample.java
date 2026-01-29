package com.example.demo.example.impl;

import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

/**
 * コンストラクタ経由で渡す（@Autowired省略版）
 *
 * 【ポイント】
 * - Spring 4.3以降、コンストラクタが1つだけなら @Autowired を省略可能
 * - コードがさらにシンプルになる
 * - 推奨される書き方
 */
@Component
public class ConstructorInjectionOmitExample implements Example {

    /** finalで変更不可 */
    private final SomeService someService;

    /**
     * @Autowired を省略（コンストラクタが1つだけなので自動認識される）
     */
    public ConstructorInjectionOmitExample(SomeService someService) {
        this.someService = someService;
    }

    @Override
    public void run() {
        System.out.println("【コンストラクタ経由で渡す（@Autowired省略版）】");
        someService.doService();
    }
}
