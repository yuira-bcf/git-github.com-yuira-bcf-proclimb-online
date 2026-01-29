package com.example.demo.service.impl;

import com.example.demo.service.BusinessLogic;

/**
 * サンプル用ビジネスロジック実装クラス
 *
 * 【ポイント】
 * - @Component アノテーションを付けていません
 * - Java Config（AppConfig）でBean登録します
 */
public class SampleLogicImpl implements BusinessLogic {
    @Override
    public String execute() {
        return "SampleLogicImpl が実行されました";
    }
}
