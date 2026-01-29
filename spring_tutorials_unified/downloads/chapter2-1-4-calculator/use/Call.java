package use;

import used.AddCalc;
import used.Calculator;

/**
 * インターフェース依存を確認するためのクラス
 *
 * 【実行方法】
 * 1. プロジェクトルートで: javac used/*.java use/*.java
 * 2. 実行: java use.Call
 *
 * 【切り替え方法】
 * AddCalc → SubCalc に変更する場合:
 * - import文: import used.AddCalc; → import used.SubCalc;
 * - インスタンス生成: new AddCalc() → new SubCalc()
 */
public class Call {
    public static void main(String[] args) {
        // 加算クラスをインスタンス化
        Calculator calculator = new AddCalc();
        // メソッドを実行
        Integer result = calculator.calc(10, 5);
        // 結果の表示
        System.out.println("計算結果は「" + result + "」です。");
    }
}
