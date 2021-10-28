package tech.zzhdev.oldways.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tech.zzhdev.oldways.data.ConstLayoutData

@Composable
fun GeneralCard(content: @Composable() () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(ConstLayoutData.generalCardHeight),
        elevation = 6.dp,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Yellow
        ),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(19.dp),
        content = content,
    )
}

@Composable
fun GeneralCard(
    onClick: () -> Unit,
    content: @Composable() () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(ConstLayoutData.generalCardHeight)
            .clickable(onClick = onClick)
            ,
        elevation = 6.dp,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Yellow
        ),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(19.dp),
        content = content,
    )
}