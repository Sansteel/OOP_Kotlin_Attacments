package ru.netology.attacments

class Photo(
    //todo val type: ArrayList<String> = arrayListOf("photo"),
    val type: String = "photo",
    val idP: Int, //Идентификатор
    val album_id: Int?, //Идентификатор альбома, в котором находится фотография
    val ownerId: Int, //Идентификатор владельца фотографии
    val text: String?, //Текст описания фотографии
    val date: Int, //Дата добавления в формате Unixtime
    val width: Int, //Ширина оригинала фотографии в пикселах
    val height: Int //Высота оригинала фотографии в пикселах.
) : Attachment(arrayListOf(type), idP, ownerId) {

}