package tech.zzhdev.oldways.ui.frame

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldways.R
import tech.zzhdev.oldways.data.FontSizeController
import tech.zzhdev.oldways.exception.UnmatchedSizeException
import tech.zzhdev.oldways.ui.cards.ECMCard
import tech.zzhdev.oldways.ui.cards.ECMCardContent
import tech.zzhdev.oldways.ui.screens.Screen
import tech.zzhdev.oldways.ui.theme.Purple200

@Composable
fun MainFrame(
    navController: NavHostController,
    mainPageNavController: NavHostController,
    appName: String,
    content: @Composable() () -> Unit
) {
    Scaffold(
        bottomBar = {
            FrameBottomBar(
                screenRoutes = arrayOf(
                    Screen.Education.route,
                    Screen.Communication.route,
                    Screen.EMall.route,
                    Screen.Connection.route,
                    Screen.PersonalInfo.route
                ),
                buttonLabels = arrayOf(
                    "教育",
                    "交流",
                    "商城",
                    "社交",
                    "我的"
                ),
                navController = navController
            )
        }
    ) {
        content()
    }
}

@Composable
fun FrameTopBar(appName: String) {
    val searchHint = remember {
        mutableStateOf("输入以搜索……")
    }
    Row(
        modifier = Modifier
        .background(Purple200)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Text(
//            modifier = Modifier
//                .weight(0.2f),
//            text = appName,
//            fontSize = 25.sp,
//            textAlign = TextAlign.Center,
//        )
        TextField(
            modifier = Modifier
                .weight(0.8f),
            value = searchHint.value,
            onValueChange = {
                searchHint.value = it
            },
            maxLines = 1
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
            fontSize = FontSizeController.subtitleL,
            textAlign = TextAlign.Center
        )
    }

}

/**
 * param screenRoutes and buttonLabels must have same size and same order
 * */
@Composable
fun FrameBottomBar(
    screenRoutes: Array<String>,
    buttonLabels: Array<String>,
    navController: NavHostController
) {
    val tag = "FrameBottomBar Buttons"
    if (screenRoutes.size != buttonLabels.size) {
        throw UnmatchedSizeException(
            message = "param screenRoutes and buttonLabels do not have same size"
        )
    }
    LazyRow(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(buttonLabels.size) {
            Button(
                onClick = {
                    Log.d(tag, "FrameBottomBar: navigating to ${screenRoutes[it]}")
                    navController.navigate(screenRoutes[it])
            }) {
                Text(text = buttonLabels[it])
            }
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame(
        navController = rememberNavController(),
        mainPageNavController = rememberNavController(),
        appName = "老方子"
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

@Preview
@Composable
fun FrameTopBarPreview() {
    FrameTopBar("老方子")
}

@Preview
@Composable
fun FrameBottomBarPreview() {
    FrameBottomBar(
        screenRoutes = arrayOf(
            Screen.Education.route,
            Screen.Communication.route,
            Screen.EMall.route,
            Screen.Connection.route,
            Screen.PersonalInfo.route
        ),
        buttonLabels = arrayOf(
            "教育",
            "交流",
            "商城",
            "社交",
            "我的"
        ),
        navController = rememberNavController()
    )
}