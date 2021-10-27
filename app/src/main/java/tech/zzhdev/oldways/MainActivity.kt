package tech.zzhdev.oldways

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldways.ui.screens.SetupMainPageNavGraph
import tech.zzhdev.oldways.ui.theme.OldWaysTheme

class MainActivity : ComponentActivity() {
    lateinit var contentNavController: NavHostController
    lateinit var mainPageNavController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OldWaysTheme {
                mainPageNavController = rememberNavController()
                contentNavController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SetupMainPageNavGraph(
                        mainPageNavController = mainPageNavController,
                        contentNavController = contentNavController
                    )
                }
            }
        }
    }
}