package tech.zzhdev.oldways.ui.pages

import tech.zzhdev.oldways.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldways.data.FontSizeController
import tech.zzhdev.oldways.data.User
import tech.zzhdev.oldways.ui.cards.GeneralCard
import tech.zzhdev.oldways.ui.pages.setting.FontSetting

@Composable
fun PersonalPage(
    mainPageNavController: NavHostController,
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        topBar = {
            // TODO: 设置用户
            PersonalPageTopBar(User.EXAMPLE_USER)
        }
    ) {
        PersonalPageSettings(
            mainPageNavController = mainPageNavController,
            contentNavController = navController
        )
    }
}

@Composable
fun PersonalPageTopBar(user: User) {
    GeneralCard {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 头像
            Image(
                modifier = Modifier
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.s_pic),
                contentDescription = "Profile Photo"
            )
            Column(
                modifier = Modifier
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 昵称
                Text(
                    modifier = Modifier
//                        .fillMaxWidth()
                        .weight(0.2f),
                    text = user.nickname,
                    fontSize = FontSizeController.subtitle,
                )
                Divider()
                // 个人简介
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f),
                    text = user.personalIntroduction,
                    fontSize = FontSizeController.markL
                )
                Divider()
                // 注册时间
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.1f),
                    text = user.registerTime.toString(),
                    fontSize = FontSizeController.markS
                )
            }
        }
    }
}

@Composable
fun PersonalPageSettings(
    mainPageNavController: NavHostController,
    contentNavController: NavHostController
) {
    Column {
        Divider(
            modifier = Modifier.padding(top = 10.dp)
        )
        FontSetting()
    }
}

@Preview
@Composable
fun PersonalPageSettingsPreview() {
    PersonalPageSettings(
        mainPageNavController = rememberNavController(),
        contentNavController = rememberNavController()
    )
}

@Preview
@Composable
fun PersonalPagePreview() {
    PersonalPage(rememberNavController(), rememberNavController())
}