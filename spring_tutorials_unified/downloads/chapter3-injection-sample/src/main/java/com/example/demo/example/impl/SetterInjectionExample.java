package com.example.demo.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

/**
 * セッターメソッド経由で渡す（セッターインジェクション）
 *
 * 【ポイント】
 * - セッターメソッドに @Autowired を付与
 * - Springがセッターメソッドを呼び出して参照を渡す
 */
@Component
public class SetterInjectionExample implements Example {

    private SomeService someService;

    /**
     * @Autowired でセッターメソッドを指定
     * Springがこのメソッドを呼び出して参照を渡す
     */
    @Autowired
    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    @Override
    public void run() {
        System.out.println("【セッターメソッド経由で渡す（セッターインジェクション）】");
        someService.doService();
    }
}
