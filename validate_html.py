#!/usr/bin/env python3
"""
HTMLファイルの構造検証スクリプト
開きタグと閉じタグの対応をチェックし、不整合を検出します
"""
import os
import re
from pathlib import Path
from collections import defaultdict

def validate_html_structure(file_path):
    """HTMLファイルの構造を検証"""
    errors = []
    tag_stack = []

    # 自己閉じタグ（開始タグのみ存在するタグ）
    self_closing = {'meta', 'link', 'img', 'br', 'hr', 'input', 'area', 'base', 'col', 'embed', 'param', 'source', 'track', 'wbr'}

    # コメントと文字列を除外してタグを抽出
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
        lines = content.split('\n')

    # タグパターン（開きタグと閉じタグ）
    tag_pattern = re.compile(r'<(/?)(\w+)(?:\s[^>]*)?>|<!--.*?-->', re.DOTALL)

    for line_num, line in enumerate(lines, 1):
        # コメントを除外
        line_without_comments = re.sub(r'<!--.*?-->', '', line)

        for match in tag_pattern.finditer(line_without_comments):
            full_match = match.group(0)

            # コメントはスキップ
            if full_match.startswith('<!--'):
                continue

            is_closing = match.group(1) == '/'
            tag_name = match.group(2).lower()

            # 自己閉じタグはスキップ
            if tag_name in self_closing:
                continue

            if is_closing:
                # 閉じタグの場合
                if not tag_stack:
                    errors.append({
                        'line': line_num,
                        'type': 'unexpected_closing',
                        'tag': tag_name,
                        'message': f'予期しない閉じタグ </{tag_name}> （対応する開きタグがありません）'
                    })
                elif tag_stack[-1]['tag'] != tag_name:
                    # タグが不一致
                    expected = tag_stack[-1]['tag']
                    errors.append({
                        'line': line_num,
                        'type': 'tag_mismatch',
                        'tag': tag_name,
                        'expected': expected,
                        'open_line': tag_stack[-1]['line'],
                        'message': f'タグの不一致: </{tag_name}> が見つかりましたが、<{expected}>（{tag_stack[-1]["line"]}行目）が開いています'
                    })
                    # スタックから削除
                    tag_stack.pop()
                else:
                    # 正しく閉じられた
                    tag_stack.pop()
            else:
                # 開きタグの場合
                tag_stack.append({
                    'tag': tag_name,
                    'line': line_num
                })

    # 閉じられていないタグをチェック
    for unclosed in tag_stack:
        errors.append({
            'line': unclosed['line'],
            'type': 'unclosed',
            'tag': unclosed['tag'],
            'message': f'閉じられていないタグ <{unclosed["tag"]}>'
        })

    return errors

def main():
    """メイン処理"""
    target_dir = Path('spring_tutorials_unified')

    if not target_dir.exists():
        print(f"エラー: ディレクトリ {target_dir} が見つかりません")
        return

    html_files = sorted(target_dir.glob('*.html'))

    print("=" * 80)
    print("HTMLファイル構造検証レポート")
    print("=" * 80)
    print()

    all_errors = {}
    total_errors = 0

    for html_file in html_files:
        errors = validate_html_structure(html_file)
        if errors:
            all_errors[html_file.name] = errors
            total_errors += len(errors)

    if not all_errors:
        print("✓ 全てのHTMLファイルの構造は正常です。")
    else:
        print(f"⚠️  {len(all_errors)}個のファイルで合計{total_errors}件のエラーが見つかりました。\n")

        for filename, errors in sorted(all_errors.items()):
            print(f"\n【{filename}】")
            print("-" * 80)
            for error in errors:
                if error['type'] == 'tag_mismatch':
                    print(f"  行 {error['line']:4d}: ❌ {error['message']}")
                    print(f"              期待: </{error['expected']}>  実際: </{error['tag']}>")
                else:
                    print(f"  行 {error['line']:4d}: ❌ {error['message']}")
            print()

    print("=" * 80)
    print(f"検証完了: {len(html_files)}ファイル検証済み")
    print("=" * 80)

if __name__ == '__main__':
    main()
