package ru.netology.service

import ru.netology.attacments.Attachment

class AttService(
    private var ownerId: Int //передача поля из Post
) {
    var attachments = emptyArray<Attachment>() // пустой массив постов
    var count = 0 //счетчик вложений

    fun add(att: Attachment): Attachment { //метод для добавления
        att.owner_id = ownerId
        attachments += att //добавляем
        count++
        return attachments.last()
    }

    fun print() {
        println("Некоторые сведения об имеющихся вложениях:")
        for ((index) in attachments.withIndex()) {
            println(attachments[index].attTypeArr + attachments[index].id + attachments[index].owner_id)
        }
    }

}