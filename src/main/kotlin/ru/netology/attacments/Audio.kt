package ru.netology.attacments

class Audio(
    private val idP: Int, //Идентификатор
    private val ownerId: Int, //Идентификатор владельца фотографии
    val album_id: Int, //Идентификатор альбома, в котором находится фотография
    val artist: String?, //Исполнитель
    val title: String?, //Название композиции
    val duration: Int? //Длительность аудиозаписи в секундах
) : Attachment(arrayListOf("audio"), idP, ownerId) {

}