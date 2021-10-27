package tech.zzhdev.oldways.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object OldWaysFontSizeController {
    var baseSize = 10
    var incrementStep = 5

    val articleTitleL = getLevel(11)
    val articleTitle = getLevel(10)
    val articleTitleS = getLevel(9)

    fun getLevel(level: Int): TextUnit {
        return (baseSize + (level - 1) * incrementStep).sp
    }
}

@Preview(showBackground = true)
@Composable
fun fontSizePreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "articleTitleL",
            fontSize = OldWaysFontSizeController.articleTitleL
        )
    }
}