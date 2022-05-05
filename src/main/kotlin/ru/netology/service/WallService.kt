package ru.netology.service

import ru.netology.data.*
import ru.netology.exeptions.PostNotFoundException
import java.lang.NullPointerException

class WallService {
    var posts = emptyArray<Post>() // пустой массив из постов
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
            try {
                //if (posts[index].comments!!.isNotEmpty()) { //это дублирвоание, чекается через try
                        println("Комменты: " + posts[index].comments!!.size)
                        println(posts[index].comments!![0].text) //todo в иделае конечно надо зациклить
                  //  }
            } catch (e: NullPointerException) {
                println("тут комментов нету")
            }
            if (posts[index].attachermnts != null) {
                println("Вложения: " + posts[index].attachermnts!!.count + " шт")
                posts[index].attachermnts!!.print() //некоторые сведения о вложениях
            }
            println("\n")
        }
    }

    fun findById(id: Int): Post {
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        throw PostNotFoundException() //прерывается прога
    }

    fun createComment(comment: Comment) {
            val temp: Post = findById(comment.postId)!!
            //if (temp.id == comment.postId) { //это условие ignored т.к. try уехал в main
                comments += comment
                temp.comments = comments
                println("LOG: comment added to Post ID ${temp.id} success \n")
    }
}
