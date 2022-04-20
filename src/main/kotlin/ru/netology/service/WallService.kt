package ru.netology.service

import ru.netology.data.Post

class WallService {
    var posts = emptyArray<Post>() // пустой массив из постов

    fun add(post: Post): Post { //метод для создания записи должен выглядеть вот так (на вх и вых Post)
        posts += post //добавляем пост в наш массив
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (oldPost.id == newPost.id) {
                posts[index] = newPost.copy(
                    ownerId = oldPost.ownerId, date = oldPost.date,
                    comments = oldPost.comments
                )  //в ксобках пишем поля Post которые должны наследоваться
                return true
            }
        }
        return false
    }

    fun print() {
        for ((index, post) in posts.withIndex()) {
            println("Пост ${index + 1}: id=" + posts[index].id + " Date unixtime: " + posts[index].date)
            println("text=" + posts[index].text)
            println("owner id=" + posts[index].ownerId)
            if (posts[index].comments?.count != null) {println("Комментов=" + posts[index].comments?.count)}
            if (posts[index].attachermnts != null) {
                println("Вложения: " + posts[index].attachermnts!!.count + " шт")
                posts[index].attachermnts!!.print() //некоторые сведения о вложениях
            }
            println("\n")
        }
    }
}
