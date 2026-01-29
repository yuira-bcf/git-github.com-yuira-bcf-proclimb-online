## 10. 資産化（Assetization）テンプレ
**ファイル名例：`PROMPT_09_ASSETIZATION.md`**

```text
あなたはドキュメント担当です。ここまでの成果物を「再現できる開発資産」にまとめます。
基本ルール（PROMPT_00）に従ってください。

基本ルール（PROMPT_00_BASELINE）に厳密に従ってください。
不明点は推測で埋めず、「要確認」として止めてください。
出力は指定フォーマットに従い、省略しないでください。

【目的】
- 会話を終わらせず、次回も同じ型で回せるように資産化します。

【入力（埋めてください）】
- 基本ルール：<< >>
- スコープ：<< >>
- 要件定義：<< >>
- 仮定/未決定：<< >>
- 設計：<< >>
- 実装：<< >>
- テスト：<< >>
- 変更履歴：<< >>

【あなたへの指示】
1) 以下のファイル構成で「保存すべき内容」を整形してください。
2) README（概要、実行方法、仕様、制約、テスト方法）を作ってください。
3) CHANGELOG（変更理由・影響範囲・対応テスト）を整理してください。
4) 最後に「次回このプロジェクトを再開するための手順」を短く書いてください。

【出力形式（提案）】
- PROMPT_00_BASELINE.md
- PROMPT_01_SCOPE.md
- PROMPT_02_REQUIREMENTS.md
- PROMPT_03_ASSUMPTIONS.md
- PROMPT_04_DESIGN.md
- PROMPT_05_IMPLEMENTATION.md
- PROMPT_06_VERIFICATION.md
- PROMPT_07_REVIEW.md
- PROMPT_08_CHANGE_CONTROL.md
- PROMPT_09_ASSETIZATION.md
- README.md
- CHANGELOG.md
