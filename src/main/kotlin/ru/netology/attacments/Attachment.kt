package ru.netology.attacments

import ru.netology.data.Post

sealed class Attachment(
    internal val attType: String, //тип вложения
    val postId: Int, // номер поста, которому будем добавлять вложение
    val id: Int, //Идентификатор вложения
    var owner_id: Int, //Идентификатор владельца вложения

) {}

