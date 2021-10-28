package tech.zzhdev.oldways.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldways.data.AgePeriod
import tech.zzhdev.oldways.data.FontSizeController
import tech.zzhdev.oldways.data.Passage

@Composable
fun PassagePage(
    mainPageNavController: NavHostController,
    passageId: Int
) {
    // TODO: 修改为记住状态
    val passage = getPassageById(passageId)
    Scaffold(
        topBar = {
            PassagePageTopBar(
                mainPageNavController = mainPageNavController,
                title = passage.title
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Author ${passage.author}",
                    textAlign = TextAlign.Right,
                    fontSize = FontSizeController.markS
                )
            }
            Divider()
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = passage.content,
                fontSize = FontSizeController.passage
            )
        }
    }
}

@Composable
fun PassagePageTopBar(
    mainPageNavController: NavHostController,
    title: String
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
//                .fillMaxHeight()
                .weight(0.8f),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = FontSizeController.articleTitle
        )
    }
}

@Preview
@Composable
fun PassagePagePreview() {
    PassagePage(
        // TODO: 修改这些占位用的参数
        mainPageNavController = rememberNavController(),
        passageId = 123
    )
}

@Preview(showBackground = true)
@Composable
fun PassagePageTopBarPreview() {
    PassagePageTopBar(
        mainPageNavController = rememberNavController(),
        title = "Hello world!"
    )
}

fun getPassageById(passageId: Int): Passage {
    // TODO: 从服务器获取文章
    return Passage(
        title = "How to use this app...",
        author = "ZZHDEV",
        content = "Article: $passageId - Banana!",
        fitAge = AgePeriod.OneToSix
    )
}