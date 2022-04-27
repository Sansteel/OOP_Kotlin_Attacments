package ru.netology.data

import ru.netology.attacments.Attachment
import java.util.*

data class Comment( //Информация о комментариях к записи на стене
//    //поля отсюда https://dev.vk.com/method/wall.createComment
//    val postId: Int, //Идентификатор записи на стене
//    val ownerId: Int, //Идентификатор пользователя ... к которой необходимо добавить комментарий
//    val fromGroup: Int = 0, // Идентификатор сообщества, от имени которого публикуется комментарий
//    val message: String?, //Текст комментария. Обязательный параметр, если не передан параметр attachments
//    val replyToCommentval: Int, // Идентификатор комментария, в ответ на который должен быть добавлен новый комментарий.
//    val attachments: Attachment, //Список объектов, приложенных к комментарию
//    val stickerId: Int = 0, // Идентификатор стикера.
//    val guidval: String, //Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария.

    //описание полей отсюда https://dev.vk.com/reference/objects/comment
    val id: Int, //Идентификатор комментария
    val fromId: Int, //Идентификатор автора комментария
    val date: Long, //Дата создания комментария в формате Unixtime
    val text:String, // Текст комментария
    val donut:Any? = null, //Информация о VK Donut //todo
    val replyToUser: Int = 0, //Идентификатор пользователя  в ответ которому оставлен  комментарий(если применимо)
    val replyToComment: Int = 0, //Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachment? = null, //Медиавложения комментария
    val parentsStack: Array<Comment>?, //Массив идентификаторов родительских комментариев
    val thread:Any?=null, //Информация о вложенной ветке комментариев

    //кажется поля ниже лишние
//    var count: Int = 0, //количество комментариев
//    var canPost: Boolean = true, // может ли текущий пользователь комментировать запись (1 — может
//    val groupsCanPost: Boolean = false, // могут ли сообщества комментировать запись
//    var canClose: Boolean = true, //может ли текущий пользователь закрыть комментарии к записи
//    var canOpen: Boolean = true, // может ли текущий пользователь открыть комментарии к записи
){

    override fun equals(other: Any?): Boolean { //добавлено по предложению IDEA для поля parentsStack
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Comment

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}