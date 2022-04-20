package ru.netology.attacments

import ru.netology.data.Post

abstract class Attachment(
    val attTypeArr: ArrayList<String> = arrayListOf<String>("audio","photo"), //тип вложения
    val id: Int, //Идентификатор юзера
    var owner_id: Int, //Идентификатор владельца вложения //todo присвоить значению id из Post

) {

}

