=============================================
  第3章 DI（依存性の注入）サンプルプロジェクト
=============================================

【概要】
Spring FrameworkのDI（Dependency Injection）を
実際に動かして理解するためのサンプルです。

【プロジェクト構成】
chapter3-di-sample/
├── pom.xml                              # Maven設定
├── README.txt                           # このファイル
└── src/main/java/com/example/demo/
    ├── DiSampleApplication.java         # 起動クラス（使う側）
    └── used/
        ├── Greet.java                   # インターフェース
        ├── MorningGreet.java            # 実装クラス（朝の挨拶）
        └── EveningGreet.java            # 実装クラス（夕方の挨拶）

=============================================
  実行方法
=============================================

■ 方法1：IDEで実行
1. Eclipse/IntelliJ IDEA でプロジェクトをインポート
2. DiSampleApplication.java を実行

■ 方法2：コマンドラインで実行
1. プロジェクトルートで以下を実行：
   mvn spring-boot:run

■ 実行結果
============================
DIサンプル実行結果
============================
挨拶: おはようございます
============================

=============================================
  実装クラスの切り替え方法
=============================================

「使う側」クラス（DiSampleApplication.java）を
一切変更せずに、挨拶の内容を切り替えられます。

【手順】
1. MorningGreet.java の @Component をコメントアウト
   // @Component
   public class MorningGreet implements Greet {

2. EveningGreet.java の @Component のコメントを外す
   @Component  // ← コメントを外す
   public class EveningGreet implements Greet {

3. 再度実行すると「こんばんは」が表示される

【ポイント】
DiSampleApplication.java は変更していないのに、
出力結果が変わります。これがDIの威力です！

=============================================
  5つのルール
=============================================

1. インターフェースを利用して依存関係を作る
   → Greet インターフェースを使用

2. インスタンスを明示的に生成しない
   → new キーワードを使わない

3. アノテーションを「使われる側」クラスに付与する
   → @Component を付与

4. Spring Frameworkにインスタンス生成させる
   → コンポーネントスキャンで自動検出

5. 「使う側」クラスにアノテーションを付与する
   → @Autowired でインジェクション
