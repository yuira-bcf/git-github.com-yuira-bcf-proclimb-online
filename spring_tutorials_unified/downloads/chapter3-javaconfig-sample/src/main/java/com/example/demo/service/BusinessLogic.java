package com.example.demo.service;

/**
 * ビジネスロジックインターフェース
 *
 * 処理の型を定義するインターフェースです。
 * 実装クラスはこのインターフェースを実装します。
 */
public interface BusinessLogic {
    /**
     * 処理を実行する
     * @return 実行結果
     */
    String execute();
}
