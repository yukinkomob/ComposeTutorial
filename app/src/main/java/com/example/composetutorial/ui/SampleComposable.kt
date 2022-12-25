package com.example.composetutorial.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Preview
@Composable
fun PreviewText() {
    Text("test")
}

/**
 * 画面構成
 * リスト
 *  項目（タップすると本文が一行表示 <-> 複数行表示で切り替わる）
 *      画像
 *          丸型
 *          ボーダーあり（色、太さ、丸型）
 *      タイトル
 *          色指定あり
 *          タイポグラフィ指定
 *      本文（複数行表示可能）
 *          タイポグラフィ指定
 */


/**
 * リスト項目：メッセージカード
 * Row
 *  Image
 *  Column
 *      Text: author
 *      Text: body
 */
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExtended by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExtended = !isExtended }) {
            Text(
                msg.author,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                msg.body,
                maxLines = if (isExtended) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(msg = Message("Mike", "Good Engineer"))
        }
    }
}

/**
 * 値：メッセージデータ
 *  author
 *  body
 */
data class Message(val author: String, val body: String)

/**
 * リスト：会話
 *  メッセージカードをリストとして表示する
 */
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn() {
        messages.map { item { MessageCard(msg = it) } }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme() {
        Surface() {
            Conversation(messages = SampleData.conversationSample.map { Message(it.author, it.body) })
        }
    }
}