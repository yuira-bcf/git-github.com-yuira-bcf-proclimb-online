=============================================
  第3章 Java Config サンプルプロジェクト
=============================================

【概要】
Spring FrameworkのJava Configを使用した
Bean定義の方法を学ぶためのサンプルです。

@Componentを使わずに、設定クラス（AppConfig）で
明示的にnewしてBeanを登録する方法を確認できます。

【プロジェクト構成】
chapter3-javaconfig-sample/
├── pom.xml                                    # Maven設定
├── README.txt                                 # このファイル
└── src/main/java/com/example/demo/
    ├── JavaConfigSampleApplication.java       # 起動クラス
    ├── config/
    │   └── AppConfig.java                     # Java Config（設定クラス）
    └── service/
        ├── BusinessLogic.java                 # インターフェース
        └── impl/
            ├── TestLogicImpl.java             # 実装クラス1
            └── SampleLogicImpl.java           # 実装クラス2

=============================================
  実行方法
=============================================

■ 方法1：VSCodeで実行
1. VSCodeでフォルダを開く
2. JavaConfigSampleApplication.java を開く
3. main メソッドの上に表示される「Run」をクリック

■ 方法2：コマンドラインで実行
1. プロジェクトルートで以下を実行：
   mvn spring-boot:run

■ 実行結果
====================================
Java Config サンプル実行結果
====================================

【testLogic（@Qualifier("test")）】
  → TestLogicImpl が実行されました

【sampleLogic（@Qualifier("sample")）】
  → SampleLogicImpl が実行されました

====================================

=============================================
  @Component と Java Config の違い
=============================================

【@Component を使う方法】
- クラス自身に @Component を付ける
- Springが自動でスキャンして new してくれる
- シンプルで手軽

【Java Config を使う方法】
- 設定クラス（@Configuration）を作成
- @Bean メソッドで明示的に new して返す
- 複数のBeanに名前を付けて区別できる
- サードパーティのライブラリのクラスもBean登録できる

=============================================
  ポイント
=============================================

1. @Configuration
   クラスに付けて「これは設定クラスです」と宣言

2. @Bean(name = "xxx")
   メソッドに付けて「このメソッドの戻り値をBeanとして登録」
   name属性でBean名を指定

3. @Qualifier("xxx")
   同じインターフェースを実装したBeanが複数ある場合、
   Bean名を指定して取得する

=============================================
  学習のヒント
=============================================

1. AppConfig.java の @Bean メソッドを確認
   → どのクラスがどの名前で登録されているか

2. JavaConfigSampleApplication.java の @Qualifier を確認
   → どの名前のBeanを取得しているか

3. 実行結果で、正しいクラスが呼ばれていることを確認
