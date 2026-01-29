=============================================
  Getter・Setter & Lombok サンプルソースコード
=============================================

【概要】
Getter・Setterの役割とLombokの使い方を学ぶためのサンプルです。
各フォルダごとに実行して動作を確認できます。

【フォルダ構成】
chapter2-getter-setter/
├── 01_without_setter/   # Setterを使わない場合（問題点を確認）
├── 02_with_setter/      # Setterを使う場合（バリデーション付き）
├── 03_without_getter/   # Getterを使わない場合（問題点を確認）
├── 04_with_getter/      # Getterを使う場合（加工した値を返す）
├── 05_without_lombok/   # Lombokを使わない場合（従来の書き方）
├── 06_with_lombok/      # Lombokを使う場合（アノテーションで簡潔に）
├── 07_lombok_custom/    # Lombok + カスタムメソッドの併用
└── README.txt

=============================================
  各サンプルの実行方法
=============================================

■ 01〜05 の実行方法（Lombokなし）
------------------------------------------
各フォルダに移動して以下を実行：

  cd 01_without_setter
  javac *.java
  java Main

■ 06〜07 の実行方法（Lombok必要）
------------------------------------------
Lombokライブラリが必要です。
Spring Bootプロジェクトで使用するか、
以下の方法でLombokをセットアップしてください。

【方法1】Spring Boot プロジェクトで使用
  1. Spring Initializr (https://start.spring.io/) で
     プロジェクトを作成
  2. 依存関係に「Lombok」を追加
  3. src/main/java にファイルをコピー

【方法2】Mavenプロジェクトで使用
  pom.xmlに以下を追加：
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
      <scope>provided</scope>
  </dependency>

=============================================
  学習ポイント
=============================================

■ Setter の役割
- 値を設定する前にバリデーション（検証）ができる
- 不正な値（null、空文字、範囲外の数値）を拒否できる
- データの整合性を保護する

■ Getter の役割
- 値を取得する際に加工した値を返せる
- 処理を1箇所に集約してコードの重複を防ぐ
- 変更に強いコードになる

■ カプセル化
- フィールドをprivateにして直接アクセスを防ぐ
- Getter/Setterを通じてのみアクセスを許可
- プログラムの安全性と保守性が向上

■ Lombok のメリット
- @Getter/@Setter でGetter・Setterを自動生成
- ボイラープレートコード（定型的なコード）を削減
- カスタムメソッドと併用可能（同名メソッドは自動生成をスキップ）
