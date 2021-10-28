package tech.zzhdev.oldways.data

sealed class AgePeriod(val value: String) {
    object OneToSix: AgePeriod(value = "1 - 6")
    object SixToTwelve: AgePeriod(value = "6 - 12")
    object TwelveToEighteen: AgePeriod(value = "12 - 18")
}
