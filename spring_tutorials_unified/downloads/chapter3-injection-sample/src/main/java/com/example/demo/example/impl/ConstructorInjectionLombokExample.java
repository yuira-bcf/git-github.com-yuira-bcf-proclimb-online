package com.example.demo.example.impl;

import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

import lombok.RequiredArgsConstructor;

/**
 * コンストラクタ経由で渡す（Lombok使用版）
 *
 * 【ポイント】
 * - @RequiredArgsConstructor でコンストラクタを自動生成
 * - finalフィールドを引数に持つコンストラクタが自動で作られる
 * - コンストラクタを書く必要がなくなり、さらにシンプル
 */
@Component
@RequiredArgsConstructor
public class ConstructorInjectionLombokExample implements Example {

    /** finalフィールド → Lombokがコンストラクタを自動生成 */
    private final SomeService someService;

    // コンストラクタは @RequiredArgsConstructor が自動生成するので不要

    @Override
    public void run() {
        System.out.println("【コンストラクタ経由で渡す（Lombok使用版）】");
        someService.doService();
    }
}
