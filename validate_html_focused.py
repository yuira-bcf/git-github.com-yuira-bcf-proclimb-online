#!/usr/bin/env python3
"""
HTMLファイルの構造検証スクリプト（HTML要素に焦点）
div/nav/section などの主要なHTML要素の開閉をチェック
"""
import os
import re
from pathlib import Path

def validate_html_structure(file_path):
    """HTMLファイルの構造を検証（主要なHTML要素のみ）"""
    errors = []
    tag_stack = []

    # 検証対象のHTML要素（SVGタグは除外）
    html_tags = {
        'html', 'head', 'body', 'div', 'nav', 'header', 'footer', 'section', 'article',
        'aside', 'main', 'ul', 'ol', 'li', 'table', 'thead', 'tbody', 'tr', 'td', 'th',
        'form', 'button', 'select', 'textarea', 'label', 'span', 'p', 'h1', 'h2', 'h3',
        'h4', 'h5', 'h6', 'a', 'strong', 'em', 'code', 'pre', 'blockquote', 'dl', 'dt', 'dd',
        'script', 'style', 'title'
    }

    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
        lines = content.split('\n')

    # タグパターン
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

            # HTML要素のみを対象とする
            if tag_name not in html_tags:
                continue

            if is_closing:
                # 閉じタグの場合
                if not tag_stack:
                    errors.append({
                        'line': line_num,
                        'type': 'unexpected_closing',
                        'tag': tag_name,
                        'message': f'予期しない閉じタグ </{tag_name}> （対応する開きタグがありません）',
                        'line_content': line.strip()
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
                        'message': f'タグの不一致: </{tag_name}> が見つかりましたが、<{expected}>（{tag_stack[-1]["line"]}行目）が開いています',
                        'line_content': line.strip()
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
    print("HTMLファイル構造検証レポート（HTML要素のみ）")
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

            # タグ不一致のエラーのみ詳細表示
            mismatch_errors = [e for e in errors if e['type'] == 'tag_mismatch']
            unexpected_errors = [e for e in errors if e['type'] == 'unexpected_closing']
            unclosed_errors = [e for e in errors if e['type'] == 'unclosed']

            if mismatch_errors:
                print("  【タグ不一致】")
                for error in mismatch_errors:
                    print(f"    行 {error['line']:4d}: ❌ {error['message']}")
                    print(f"                期待: </{error['expected']}>  実際: </{error['tag']}>")
                    print(f"                内容: {error['line_content'][:70]}")
                    print()

            if unexpected_errors:
                print("  【予期しない閉じタグ】")
                for error in unexpected_errors:
                    print(f"    行 {error['line']:4d}: ❌ {error['message']}")
                    print(f"                内容: {error['line_content'][:70]}")
                    print()

            if unclosed_errors:
                print("  【閉じられていないタグ】")
                for error in unclosed_errors[:10]:  # 最初の10個のみ表示
                    print(f"    行 {error['line']:4d}: ❌ {error['message']}")
                if len(unclosed_errors) > 10:
                    print(f"    ... 他 {len(unclosed_errors) - 10} 件")
                print()

    print("=" * 80)
    print(f"検証完了: {len(html_files)}ファイル検証済み")
    print("=" * 80)

if __name__ == '__main__':
    main()
