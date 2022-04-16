package ru.netology.service

import ru.netology.attacments.Attachment
import ru.netology.data.Post

class AttService {
    var attachments = emptyArray<Attachment>() // пустой массив постов
    var count = 0 //счетчик вложений

    fun add(att: Attachment): Attachment { //метод для создания
        attachments += att //добавляем
        count++
        return attachments.last()
    }

    fun print() {
        println("Некоторые сведения об имеющихся вложениях:")
        for ((index, attachment) in attachments.withIndex()) {
            println(attachments.last().attTypeArr + attachments.last().id + attachments.last().owner_id)
        }
    }

}