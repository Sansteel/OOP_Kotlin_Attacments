package ru.netology.service

import ru.netology.attacments.Attachment

class AttService(
//    private var ownerId: Int, //передача владельца  из Post
//    private var postID: Int // передача номера поста из Post //fixme чегото я тут перемудрил
) {
    var attachments = emptyArray<Attachment>() // пустой массив постов
    var count = 0 //счетчик вложений

    fun add(att: Attachment, post_id: Int): Attachment { //метод для добавления вложения
        //att.owner_id = ownerId
        if (att.postId == post_id) {
            attachments += att //добавляем
            count++
        }
        return attachments.last()
    }

    fun print() {
        println("Некоторые сведения об имеющихся вложениях: (тип, № вложения, ID вложения, ID владельца вложения")
        for ((index) in attachments.withIndex()) {
            println(attachments[index].attType + " " + attachments[index].id + " " + attachments[index].owner_id)
        }
    }

}