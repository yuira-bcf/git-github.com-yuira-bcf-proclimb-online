=============================================
  2-1-4 インターフェース依存のプログラム作成
  サンプルソースコード
=============================================

【概要】
「計算処理」のインターフェースを使用したインターフェース依存の
実践的なサンプルです。加算(AddCalc)と減算(SubCalc)の実装を
簡単に切り替えられることを確認できます。

【ファイル構成】
chapter2-1-4-calculator/
├── used/                    # 使われる側パッケージ
│   ├── Calculator.java     # インターフェース
│   ├── AddCalc.java        # 加算の実装クラス
│   └── SubCalc.java        # 減算の実装クラス
├── use/                     # 使う側パッケージ
│   └── Call.java           # メインクラス
└── README.txt

【コンパイル方法】
プロジェクトルート（このREADMEがあるフォルダ）で実行:

  javac used/*.java use/*.java

【実行方法】
  java use.Call

【実行結果（加算の場合）】
  計算結果は「15」です。

【切り替え方法】
Call.java を編集して、AddCalc を SubCalc に変更します:

変更前:
  import used.AddCalc;
  Calculator calculator = new AddCalc();

変更後:
  import used.SubCalc;
  Calculator calculator = new SubCalc();

再度コンパイル・実行すると:
  計算結果は「5」です。

【ポイント】
- インターフェース「Calculator」を型として使用
- 実装クラスの変更は1箇所（new部分）のみ
- 変数の型(Calculator)とメソッド呼び出し(calc)は変更不要
- これが「インターフェース依存」のメリットです
