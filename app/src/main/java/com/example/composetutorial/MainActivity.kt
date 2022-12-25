package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.SampleData
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

// 利用しない
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

/**
 * メッセージカードの関数
 * Rowにmodifierを追加し、パディングを全体8で設定
 * Imageにmodifierを追加し、sizeを40dp, clipをcircle shapeで設定
 * Imageの下に空間を8dp入れる
 * ColumnのTextとTextの間に空間を4dp入れる
 * content description を null
 * border を幅1.5dp, セカンダリ色指定、円形で設定
 * タイポグラフィを追加
 * isExpandedというStateを用意する
 */


/**
 * Messageを表すデータクラスを定義
 *  author: String
 *  body: String
 */


/**
 * 関数をプレビューする (previewMessageCard)
 * - Preview アノテーションを利用すること
 * - プレビュー可能なMessageCard関数を作成する
 * - プロジェクト内で作成したテーマを指定する
 * - Surfaceを使用する
 * @note Light Modeの場合、デフォルトの値がそのまま使われる？
 *      nameを"Light Mode"に設定
 * @note Dark Modeの場合、ダークモードの設定が行われる
 *      nameを"Dark Mode"に設定
 *      uiModeにConfiguration.UI_MODE_NIGHT_YESを設定
 *      showBackgroundにtrueを設定
 */


// 関数名：Conversation
// 引数：messages: List<Message>
// LazyColumnを利用する
//  messagesのitemをMessageCardに渡してそれをリストとして表示する


// 関数名：PreviewConversation
// プレビューとして表示する
// ComposeTutorialThemeを利用
// Conversationを利用
//   SampleDataを渡す

