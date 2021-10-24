package tech.zzhdev.oldways.pages

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.zzhdev.oldways.R
import tech.zzhdev.oldways.ui.theme.Purple200

@Composable
fun MainFrame(appName: String) {
    Scaffold(
        topBar =  {
            FrameTopBar(appName)
        },
        bottomBar = {
            FrameBottomBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val ls = (0..10).toList()
            items(ls.size) {
                ECMCard {
                    ECMCardContent(
                        drawableId = R.drawable.s_pic,
                        title = "S$it",
                        description = "This is S$it")
                }
            }
        }
    }
}

@Composable
fun FrameTopBar(appName: String) {
    val searchHint = remember {
        mutableStateOf("输入以搜索……")
    }
    Row(modifier = Modifier
        .background(Purple200)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(0.2f),
            text = appName,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
        )
        TextField(
            modifier = Modifier
                .weight(0.6f),
            value = searchHint.value,
            onValueChange = {
                searchHint.value = it
            }
        )
        Text(
            modifier = Modifier
                .border(
                    BorderStroke(
                        1.dp,
                        color = Color.Black
                    )
                )
                .weight(0.2f),
            text = "0 ~ 6",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun FrameBottomBar() {
    val tag = "FrameBottomBarButton"
    val buttons = listOf(
        "教育","交流","商城","社交","我的"
    )
    LazyRow(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(buttons.size) {
            Button(
                onClick = {
                    // TODO: module navigation
                    Log.d(tag, "FrameBottomBar: ${buttons[it]} clicked")
            }) {
                Text(text = buttons[it])
            }
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame("老方子")
}

@Preview
@Composable
fun FrameTopBarPreview() {
    FrameTopBar("老方子")
}

@Preview
@Composable
fun FrameBottomBarPreview() {
    FrameBottomBar()
}