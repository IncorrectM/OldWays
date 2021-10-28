package tech.zzhdev.oldways.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.zzhdev.oldways.R
import tech.zzhdev.oldways.data.ConstLayoutData
import tech.zzhdev.oldways.ui.cards.ECMCardContent
import tech.zzhdev.oldways.ui.frame.FrameTopBar
import tech.zzhdev.oldways.ui.cards.GeneralCard
import tech.zzhdev.oldways.ui.screens.Screen

@Composable
fun EducationPage(
    mainPageNavController: NavHostController,
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        topBar = {
            FrameTopBar(appName = ConstLayoutData.appName)
        }
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val ls = (0..10).toList()
            items(ls.size) {
                GeneralCard(
                    onClick = {
                        mainPageNavController.navigate(
                            Screen.PassageScreen.passPassageId(it)
                        )
                    }
                ){
                    ECMCardContent(
                        drawableId = R.drawable.s_pic,
                        title = "S$it",
                        description = "This is S$it"
                    )
                }
            }
        }
    }
}