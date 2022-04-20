package ru.netology.attacments

class Photo(
    private val idP: Int, //Идентификатор
    private val ownerId: Int, //Идентификатор владельца фотографии
    val album_id: Int?, //Идентификатор альбома, в котором находится фотография
    val text: String?, //Текст описания фотографии
    val date: Int, //Дата добавления в формате Unixtime
    val width: Int, //Ширина оригинала фотографии в пикселах
    val height: Int //Высота оригинала фотографии в пикселах.
) : Attachment(arrayListOf("photo"), idP, ownerId) {

}