package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.SomeService;

/**
 * サービス実装クラス
 */
@Component
public class SomeServiceImpl implements SomeService {
    @Override
    public void doService() {
        System.out.println("SomeServiceImpl が実行されました");
    }
}
