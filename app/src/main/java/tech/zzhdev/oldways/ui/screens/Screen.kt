package tech.zzhdev.oldways.ui.screens

object ScreenArgumentKey {
    const val FROM = "from"
    const val PASSAGE_ID = "psgId"
}

sealed class Screen(val route: String) {
    object Education: Screen(
        route = "educationScreen"
    )

    object Communication: Screen(
        route = "communicationScreen"
    )

    object EMall: Screen(
        route = "e-mallScreen"
    )

    object Connection: Screen(
        route = "connectionScreen"
    )

    object PersonalInfo: Screen(
        route = "personalInfoScreen"
    )

    object ContentScreen: Screen(
        route = "contentScreen"
    )

    object PassageScreen: Screen(
        route = "passageScreen/{${ScreenArgumentKey.PASSAGE_ID}}"
    ) {
        fun passPassageId(passageId: Int): String {
            return this.route.replace("{${ScreenArgumentKey.PASSAGE_ID}}", passageId.toString())
        }
    }
}
