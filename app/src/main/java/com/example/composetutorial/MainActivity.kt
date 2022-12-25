package com.example.composetutorial

import androidx.activity.ComponentActivity

// 利用しない
class MainActivity : ComponentActivity()

/**
 * メッセージカードの関数
 * Rowにmodifierを追加し、パディングを全体8で設定
 * Imageにmodifierを追加し、sizeを40dp, clipをcircle shapeで設定
 *   加えて、border を幅1.5dp, セカンダリ色指定、円形で設定
 * content description を null
 * Imageの右に空間を8dp入れる
 * isExpandedというStateを用意する（Columnで利用）
 * Columnを追加
 *  modifierにclickイベントを追加し、isExpandedの値を反転代入
 *  authorテキスト
 *      色を指定（secondaryVariant）
 *      タイポグラフィを指定（subtitle2）
 *  TextとTextの間に空間を4dp入れる
 *  bodyテキスト
 *      タイポグラフィを指定（body2）
 */


/**
 * Messageを表すデータクラスを定義
 *  author: String
 *  body: String
 */


// 関数名：Conversation
// 引数：messages: List<Message>
// LazyColumnを利用する
//  messagesのitemをMessageCardに渡してそれをリストとして表示する


/**
 * 関数をプレビューする (previewMessageCard)
 * - Preview アノテーションを利用すること（Composableも併せて必要）
 * - プレビュー可能なMessageCard関数を作成する
 * - プロジェクト内で作成したテーマを指定する
 * - Surfaceを使用する（ComposeTutorialThemeで囲うこと）
 * @note Light Modeの場合、デフォルトの値がそのまま使われる？
 *      nameを"Light Mode"に設定
 * @note Dark Modeの場合、ダークモードの設定が行われる
 *      nameを"Dark Mode"に設定
 *      uiModeにConfiguration.UI_MODE_NIGHT_YESを設定
 *      showBackgroundにtrueを設定
 */


// 関数名：PreviewConversation
// プレビューとして表示する
// ComposeTutorialThemeを利用
// Conversationを利用
//   SampleDataを渡す

