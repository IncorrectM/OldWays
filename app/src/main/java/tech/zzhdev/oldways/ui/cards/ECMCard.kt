package tech.zzhdev.oldways.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldways.R
import tech.zzhdev.oldways.ui.pages.general.GeneralCard

@Composable
fun ECMCard(
    content: @Composable () -> Unit
) {
    GeneralCard(content = content)
}

@Composable
fun ECMCardContent(
    drawableId: Int,
    title: String,
    description: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(),
            painter = painterResource(id = drawableId),
            contentDescription = "A picture")
        Column(
            modifier = Modifier
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),
                text = title,
            )
            Divider()
            Text(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth(),
                text = description,
            )
        }
    }
}

@Preview
@Composable
fun ECMCardPreview() {
    ECMCard {
        ECMCardContent(
            drawableId = R.drawable.s_pic,
            title = "Char 'S'",
            description = "A letter looks like 's' !!!")
    }
}