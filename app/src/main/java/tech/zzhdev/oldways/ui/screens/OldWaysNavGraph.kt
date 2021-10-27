package tech.zzhdev.oldways.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tech.zzhdev.oldways.ui.pages.*
import tech.zzhdev.oldways.ui.frame.MainFrame

@Composable
fun SetupMainPageNavGraph(
    mainPageNavController: NavHostController,
    contentNavController: NavHostController
) {
    NavHost(
        navController = mainPageNavController,
        startDestination = Screen.ContentScreen.route
    ) {

        composable(
            route = Screen.ContentScreen.route
        ) {
            MainFrame(
                navController = contentNavController,
                mainPageNavController = mainPageNavController,
                appName = "老方子"
            ) {
                SetupContentNavGraph(
                    mainPageNavController = mainPageNavController,
                    navController = contentNavController
                )
            }
        }

        composable(
            route = Screen.PassageScreen.route,
            arguments = listOf(
                navArgument(
                    name = ScreenArgumentKey.PASSAGE_ID
                ) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntity ->
            navBackStackEntity.arguments?.let {
                PassagePage(
                    mainPageNavController = mainPageNavController,
                    passageId = it.getInt(ScreenArgumentKey.PASSAGE_ID)
                )
            }
        }
    }
}

@Composable
fun SetupContentNavGraph(
    mainPageNavController: NavHostController,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Education.route
    ) {
        composable(
            route = Screen.Education.route
        ) {
            EducationPage(
                mainPageNavController = mainPageNavController,
                navController = navController
            )
        }

        composable(
            route = Screen.Communication.route
        ) {
            CommunicationPage(
                mainPageNavController = mainPageNavController,
                navController = navController
            )
        }

        composable(
            route = Screen.EMall.route
        ) {
            EMallPage(
                mainPageNavController = mainPageNavController,
                navController = navController
            )
        }

        composable(
            route = Screen.Connection.route
        ) {
            ConnectionPage(
                mainPageNavController = mainPageNavController,
                navController = navController
            )
        }

        composable(
            route = Screen.PersonalInfo.route
        ) {
            PersonalPage(
                mainPageNavController = mainPageNavController,
                navController = navController
            )
        }
    }
}