package ru.netology.data

import ru.netology.attacments.Attachment
import ru.netology.service.AttService

data class Post(
    val id: Int, //Идентификатор записи
    var text: String, //Текст записи
    val date: Int, //Время публикации записи в формате unixtime
    val ownerId: Int, //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int = ownerId, //Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int = ownerId, //Идентификатор администратора, который опубликовал запись
    // (возвращается только для сообществ при запросе с ключом доступа администратора).
//    val replyOwnerId: Int, // Идентификатор владельца записи, в ответ на которую была оставлена текущая
//    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean = false, // 1, если запись была создана с опцией «Только для друзей»
    var comments: CommentsObj? = null, // нет комментов в начале
    //val copyright: CopyrightObj, //todo
    val likes: LikesObj?, //todo
    val reposts: RepostsObj?, //todo
    val views: ViewsObj?, //todo
    val postType: String = "post", //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    val signerId: Int = ownerId, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    var canPin: Boolean = true, //может ли текущий пользователь закрепить запись (1 — может).
    val canDelete: Boolean = true, //может ли текущий пользователь удалить запись (1 — может)
    var canEdit: Boolean = true, //может ли текущий пользователь редактировать запись (1 — может
    var isPinned: Boolean = false, //Информация о том, что запись закреплена
    var markedAds: Boolean = false, //содержит ли запись отметку «реклама» (1 — да
    var isFavorite: Boolean = false, //true, если объект добавлен в закладки у текущего пользователя
    //    val donut: DonutObj, //todo
    val postponedID: Int = 0, //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val original: Post?,
    var attachermnts: AttService?

)
{
    //   constructor(id: Int, text: String, friendsOnly: Boolean) : this()
}
