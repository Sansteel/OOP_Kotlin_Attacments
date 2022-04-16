package ru.netology.data

class LikesObj( //Информация о лайках к записи, объект с полями
    count: Int = 0, //число пользователей, которым понравилась запись
    var userLikes: Boolean = true, //наличие отметки «Мне нравится» от текущего пользователя (1 — есть
    var canLike: Boolean = true, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может
    var canPublish: Boolean = true //информация о том, может ли текущий пользователь сделать репост записи (1 — может
){
    var count = count
    get() {
        return field
    }
    set(value) {
        if (value<0) {return}
        field=value
    }
}
