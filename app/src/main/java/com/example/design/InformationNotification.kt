package com.example.design

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import java.util.*

/**
 * お知らせ項目
 * リストの項目は下記のようにする
 *  丸型のアイコンを表示する
 *  通知メッセージを表示する
 *      最大３行まで表示する
 *      メッセージが収まらない場合は、末尾を「...」とする
 *  画像がある場合は、メッセージの下に画像を貼り付ける
 *      画像のサイズは、横幅をメッセージと揃え、縦幅は横幅の1/3くらいにする
 *  リストは投稿年月日の情報を持ち、画像の下部に左寄せで表示する
 *      文字色は灰色とする
 */
@Composable
fun NotificationScreen(notifications: List<NotificationData>) {
    Column {
        Text("お知らせ")
        Spacer(modifier = Modifier.height(10.dp))

    }
}

private fun getBeforeWeekDate(): Date {
    val cal = Calendar.getInstance()
    cal.time = Date()
    cal.add(Calendar.DATE, -6)
    return cal.time
}

@Composable
fun NotificationList(notifications: List<NotificationData>) {
    LazyColumn {
        item {
            Text(
                "今週",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(all = 12.dp)
            )
        }
        notifications.filter { it.postDate.after(getBeforeWeekDate()) }
            .map { item { NotificationItem(notification = it) } }
        // todo 月毎に表示
    }
}

@Preview
@Composable
fun PreviewNotificationList() {
    ComposeTutorialTheme() {
        Surface() {
            NotificationList(notifications = SampleNotificationList.sample)
        }
    }
}

@Composable
fun NotificationItem(notification: NotificationData) {
    Row {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = notification.iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column() {
            if (notification.title != null) Text(
                notification.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                notification.message,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                notification.postDate.toString(),
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview
@Composable
fun PreviewNotificationItem() {
    ComposeTutorialTheme() {
        Surface() {
            NotificationItem(
                notification = NotificationData(
                    title = "タイトル",
                    message = "メッセージ",
                    iconRes = R.drawable.profile_picture,
                    imageRes = R.drawable.tree01,
                    postDate = Date()
                )
            )
        }
    }
}

/**
 * サンプルデータ
 *
 * メッセージ文字列
 * 画像drawable
 * 投稿年月日
 */
object SampleNotificationList {
    val sample = listOf(
        NotificationData(
            message = "転職・副業意欲を入力｜意欲を入力すると、会社から応募への返信やスカウトが届きやすくなります",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 12, 25, 0, 0, 0)
        ),
        NotificationData(
            message = "あなたにオススメの募集です。ツクリンク株式会社「好きな場所で効率的に働き、プロダクトで産業構造を改革します。今回の募集はこれまでのものとは異なり、中核を担う人材を特別に招聘する意図があります。あなたの実力を発揮できる場としてぜひ当社を選択して頂けると非常に嬉しく思います。",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 12, 1, 0, 0, 0)
        ),
        NotificationData(
            title = "LENIS 合同会社が募集を公開",
            message = "LENIS合同会社が新しい募集「コミュニケーションが得意な方必見！仕事も遊びも全力でメリハリのある生活を送りませんか？弊社は沖縄に基盤を置いて活動する事業会社になります。沖縄の多数のベンチャーと連携して製品の企画開発をし、プライベートでは沖縄の美しいビーチでサーフィンなどを楽しむことができます。",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 11, 25, 0, 0, 0)
        ),
        NotificationData(
            message = "転職・副業意欲を入力｜意欲を入力すると、会社から応募への返信やスカウトが届きやすくなります",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 11, 25, 0, 0, 0)
        ),
        NotificationData(
            message = "転職・副業意欲を入力｜意欲を入力すると、会社から応募への返信やスカウトが届きやすくなります",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 10, 25, 0, 0, 0)
        ),
        NotificationData(
            message = "転職・副業意欲を入力｜意欲を入力すると、会社から応募への返信やスカウトが届きやすくなります",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2022, 9, 25, 0, 0, 0)
        ),
        NotificationData(
            message = "転職・副業意欲を入力｜意欲を入力すると、会社から応募への返信やスカウトが届きやすくなります",
            iconRes = R.drawable.profile_picture,
            imageRes = R.drawable.tree01,
            postDate = Date(2021, 12, 25, 0, 0, 0)
        ),
    )
}

data class NotificationData(
    val title: String? = null,
    val message: String,
    val iconRes: Int,
    val imageRes: Int,
    val postDate: Date
)
