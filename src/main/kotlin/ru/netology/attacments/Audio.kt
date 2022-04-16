package ru.netology.attacments

class Audio(
    //val type: ArrayList<String> = arrayListOf("document"), //вот тут то хотелось выбирать только из доступных в предке, но по факту проходит любая строка
    val idP: Int, //Идентификатор
    val album_id: Int, //Идентификатор альбома, в котором находится фотография
    val ownerId: Int, //Идентификатор владельца фотографии
    val artist: String?, //Исполнитель
    val title: String?, //Название композиции
    val duration: Int? //Длительность аудиозаписи в секундах
) : Attachment(arrayListOf("document"), idP, ownerId) {

}