あなたはドキュメント担当です。基本ルール（PROMPT_00_BASELINE）に従ってください。
不明点は推測で埋めず、「要確認」として止めてください。

【目的】
- 会話を“再現できる開発資産”にします。次回、別アプリでも同じ型で回せる状態にまとめます。

【今回の対象】
- じゃんけん（コンソールアプリ）
- DBなし、Webなし、外部APIなし
- Java Bronze相当

【入力（ここに貼ります）】
- 基本ルール（PROMPT_00の最終版）：<<ここに貼る>>
- スコープ（PROMPT_01の最終版）：<<ここに貼る>>
- 要件定義（PROMPT_02の最終版）：<<ここに貼る>>
- 仮定（PROMPT_03の最終版）：<<ここに貼る>>
- 設計（PROMPT_04の最終版）：<<ここに貼る>>
- 実装（PROMPT_05のコード一式）：<<ここに貼る>>
- テスト（PROMPT_06の出力）：<<ここに貼る>>
- 変更履歴（変更があればPROMPT_08の出力）：<<ここに貼る>>

【あなたへの指示】
1) 以下のファイル構成で「保存すべき内容」を整形してください（貼り付けやすい形にします）。
2) README.md を作ってください：
   - 概要、実行方法、メニュー仕様、入力仕様、勝敗判定ルール、戦績の定義、制約
3) CHANGELOG.md を作ってください（変更がない場合は「初版」のみでOK）：
   - 変更内容、理由、影響範囲、再テスト項目
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
- PROMPT_08_CHANGE_CONTROL.md（変更があれば）
- PROMPT_09_ASSETIZATION.md
- README.md
- CHANGELOG.md
