package tech.zzhdev.oldways.ui.pages.setting

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import tech.zzhdev.oldways.data.ConstLayoutData
import tech.zzhdev.oldways.data.FontSizeController

@Composable
fun FontSetting() {
    val sliderProgress = remember {
        mutableStateOf(FontSizeController.getCurrentRate())
    }
    Card(
        modifier = Modifier
            .height(ConstLayoutData.settingCardHeight)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "字体大小调节",
                textAlign = TextAlign.Center
            )
            Slider(
                value = sliderProgress.value,
                onValueChange = {
                    Log.d(
                        "Font Slider",
                        "FontSetting: Font Size adjusted to $it"
                    )
                    FontSizeController.changeBaseSize(it)
                    sliderProgress.value = it
                }
            )
        }
    }
}

@Preview
@Composable
fun FontSettingPreview() {
    FontSetting()
}