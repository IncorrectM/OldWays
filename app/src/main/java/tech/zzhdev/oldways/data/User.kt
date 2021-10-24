package tech.zzhdev.oldways.data

import java.util.*

data class User(val nickname: String, val personalIntroduction: String = "他什么都没有写在这。", val registerTime: Date) {
    companion object {
        val EXAMPLE_USER = User(
            nickname = "BobLovesAlice",
            personalIntroduction = "This people is lazy and left nothing here.",
            registerTime = Date()
        )
    }
}