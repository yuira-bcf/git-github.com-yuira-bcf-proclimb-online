package com.example.demo.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

/**
 * コンストラクタ経由で渡す（コンストラクタインジェクション）
 *
 * 【ポイント】
 * - コンストラクタに @Autowired を付与
 * - フィールドに final を付けられる（不変性）
 * - 推奨される方法
 */
@Component
public class ConstructorInjectionExample implements Example {

    /** finalで変更不可 */
    private final SomeService someService;

    /**
     * コンストラクタ経由で参照を受け取る
     * Springがインスタンス生成時に引数として参照を渡す
     */
    @Autowired
    public ConstructorInjectionExample(SomeService someService) {
        this.someService = someService;
    }

    @Override
    public void run() {
        System.out.println("【コンストラクタ経由で渡す（コンストラクタインジェクション）】");
        someService.doService();
    }
}
