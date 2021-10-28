package tech.zzhdev.oldways.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object FontSizeController {
    const val MAX_BASE_SIZE = 20

    var baseSize = 10
    var incrementStep = 2

    val articleTitleL
        get() = getLevel(17)
    val articleTitle
        get() = getLevel(15)
    val articleTitleS
        get() = getLevel(13)

    val subtitleL
        get() = getLevel(13)
    val subtitle
        get() = getLevel(11)
    val subtitleS
        get() = getLevel(9)

    val passageL
        get() = getLevel(9)
    val passage
        get() = getLevel(7)
    val passageS
        get() = getLevel(5)

    val markL
        get() = getLevel(5)
    val mark
        get() = getLevel(3)
    val markS
        get() = getLevel(1)

    private fun getLevel(level: Int): TextUnit {
        return (baseSize + (level - 1) * incrementStep).sp
    }

    fun changeBaseSize(rate: Float) {
        this.baseSize = (MAX_BASE_SIZE * rate).toInt()
    }

    fun getCurrentRate(): Float = (this.baseSize.toFloat() / MAX_BASE_SIZE.toFloat())
}

@Preview(showBackground = true)
@Composable
fun FontSizePreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MaterialThemeH1",
            fontSize = MaterialTheme.typography.h1.fontSize
        )
        Text(
            text = "articleTitleL",
            fontSize = FontSizeController.articleTitleL
        )
        Text(
            text = "articleTitle",
            fontSize = FontSizeController.articleTitle
        )
        Text(
            text = "articleTitleS",
            fontSize = FontSizeController.articleTitleS
        )
        Text(
            text = "articleTitleL",
            fontSize = FontSizeController.articleTitleL
        )
    }
}