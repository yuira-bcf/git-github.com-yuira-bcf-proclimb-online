package com.example.demo.service.impl;

import com.example.demo.service.BusinessLogic;

/**
 * テスト用ビジネスロジック実装クラス
 *
 * 【ポイント】
 * - @Component アノテーションを付けていません
 * - Java Config（AppConfig）でBean登録します
 */
public class TestLogicImpl implements BusinessLogic {
    @Override
    public String execute() {
        return "TestLogicImpl が実行されました";
    }
}
