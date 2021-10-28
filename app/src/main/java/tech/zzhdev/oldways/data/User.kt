package tech.zzhdev.oldways.data

import java.util.*

data class User(val nickname: String, val personalIntroduction: String = "他什么都没有写在这。", val registerTime: Date) {
    companion object {
        val EXAMPLE_USER = User(
            nickname = "老爷子",
            personalIntroduction = "这个人很懒，什么都没有写……",
            registerTime = Date()
        )
    }
}