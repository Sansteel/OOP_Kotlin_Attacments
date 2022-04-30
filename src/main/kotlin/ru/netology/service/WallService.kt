package ru.netology.service

import ru.netology.data.*
import ru.netology.exeptions.PostNotFoundException

class WallService {
    private var posts = emptyArray<Post>() // пустой массив из постов
    private var comments = emptyArray<Comment>()

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
                )  //поля Post которые должны наследоваться от исходника
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
            //if (posts[index].comments?.count != null) {println("Комментов=" + posts[index].comments?.count)}
            if (posts[index].attachermnts != null) {
                println("Вложения: " + posts[index].attachermnts!!.count + " шт")
                posts[index].attachermnts!!.print() //некоторые сведения о вложениях
            }
            println("\n")
        }
    }

    fun findByID(id: Int): Post? {
        for (post in posts) {
            if (post.id == id) return post
        }
        return null
    }

    fun createComment(
        comment: Comment,
        postId: Int, //Идентификатор записи на стене
    ) {
        try {
            for ((index, post) in posts.withIndex()) {
                if (post.id == postId) comments += comment
            }
        } catch (e: PostNotFoundException) {
            println("Пост не нейден")
        }
    }
}
