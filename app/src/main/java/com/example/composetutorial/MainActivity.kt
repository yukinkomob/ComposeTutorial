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

// content としてConversationを受け取り、SampleDataを渡す
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // todo テーマ内をConversationで置き換える
        setContent { // contentブロックを定義
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    Text("Android2")
                }
            }
        }
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
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Content Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // todo remember関数の値をisExpandedに保管する（再利用する）
        // todo 値自体はMutableState<Boolean>型にfalseを渡す形

        // todo Columnをclickする度にisExpandedの値が反転すること
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            // todo Surfaceで囲ってやること
            // todo     shapeにmediumを設定すること
            // todo     elevationは1dpを設定すること
            // todo Textは下記のように設定する
                // text: message bodyを設定
                // modifier: paddingを全体に4dp設定
                // maxLines:
                    // isExpanded:  Int.MAX_VALUE
                    // !isExpanded: 1
                // style: typography.body2を設定
            Text(
                text = msg.body,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

/**
 * Messageを表すデータクラスを定義
 *  author: String
 *  body: String
 */
data class Message(val author: String, val body: String)

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
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
            )
        }
    }
}

// 関数名：Conversation
// 引数：messages: List<Message>
// LazyColumnを利用する
//  messagesのitemをMessageCardに渡してそれをリストとして表示する
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        messages.map { item { MessageCard(it) } }
    }
}

// 関数名：PreviewConversation
// プレビューとして表示する
// ComposeTutorialThemeを利用
// Conversationを利用
//   SampleDataを渡す
@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}
