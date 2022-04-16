package ru.netology.data

data class RepostsObj(
    var count: Int = 0, //число пользователей, скопировавших запись
    var userReposted: Boolean = false //наличие репоста от текущего пользователя (1 — есть
) {}
