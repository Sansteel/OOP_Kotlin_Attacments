package ru.netology.data

data class CommentsObj( //Информация о комментариях к записи
    var count: Int = 0, //количество комментариев
    var canPost: Boolean = true, // может ли текущий пользователь комментировать запись (1 — может
    val groupsCanPost: Boolean = false, // могут ли сообщества комментировать запись
    var canClose: Boolean = true, //может ли текущий пользователь закрыть комментарии к записи
    var canOpen: Boolean = true // может ли текущий пользователь открыть комментарии к записи
){
}