package ru.netology.attacments

import ru.netology.data.Post

abstract class Attachment(
    //val attType: String, //тип вложения
    val attTypeArr: ArrayList<String> = arrayListOf<String>("audio","photo"),
    val id: Int, //Идентификатор юзера
    var owner_id: Int, //Идентификатор владельца вложения //todo присвоить значению id из Post

) {

}

