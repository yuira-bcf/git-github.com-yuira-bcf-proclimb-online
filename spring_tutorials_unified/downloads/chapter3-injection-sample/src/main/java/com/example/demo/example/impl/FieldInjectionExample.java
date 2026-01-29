package com.example.demo.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

/**
 * フィールドに渡す（フィールドインジェクション）
 *
 * 【ポイント】
 * - フィールドに @Autowired を付与
 * - Springが直接フィールドに参照を代入
 * - コードはシンプルだが非推奨
 */
@Component
public class FieldInjectionExample implements Example {

    /**
     * @Autowired でBeanの参照を受け取る
     * Springが someService = 0x1234 のように参照を代入
     */
    @Autowired
    private SomeService someService;

    @Override
    public void run() {
        System.out.println("【フィールドに渡す（フィールドインジェクション）】");
        someService.doService();
    }
}
