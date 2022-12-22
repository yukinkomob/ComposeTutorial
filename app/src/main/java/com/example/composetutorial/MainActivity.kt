package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // contentブロックを定義
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
                    color = Color.LightGray
                ) {
                    Greeting("Android2")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!!!") // コンポーズ可能な関数
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Greeting("Android Developer")
    }
}

/**
 * メッセージカードの関数
 * Rowにmodifierを追加し、パディングを全体8で設定
 * Imageにmodifierを追加し、sizeを40dp, clipをcircle shapeで設定
 * Imageの下に空間を8dp入れる
 * ColumnのTextとTextの間に空間を4dp入れる
 */
@Composable
fun MessageCard(msg: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Content Profile Picture",
        )
        Column {
            Text(text = msg.author)
            Text(text = msg.message)
        }
    }
}

data class Message(val author: String, val message: String)

/**
 * 関数をプレビューする
 * - Preview アノテーションを利用すること
 * - プレビュー可能なMessageCard関数を作成する
 */
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Android", "Jetpack Compose"))
}

@Preview
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.index_topc4),
        contentDescription = "Content Profile Picture",
    )
}