package ru.netology

import ru.netology.attacments.Audio
import ru.netology.attacments.Photo
import ru.netology.data.*
import ru.netology.service.AttService
import ru.netology.service.WallService

fun main() {
    val myService = WallService()
    val attService = AttService(1)

    val original = Post(
        id = 1,
        "это тестовый пост",
        12022022,
        12345,
        friendsOnly = false,
        likes = null,
        reposts = null,
        attachermnts = null,
        views = null,
        original = null
    )

    val newPost = Post(
        2,
        "второй пост",
        20022022,
        54321,
        likes = null,
        reposts = null,
        attachermnts = null,
        views = null,
        original = null
    )

    val newPost3 = Post(
        3,
        "третий пост",
        20022022,
        54321,
        likes = null,
        reposts = null,
        attachermnts = null,
        views = null,
        original = null
    )

    myService.add(original)
    myService.add(newPost)
    myService.add(newPost3)
    //println("SYSTEM: Список постов \n")
    //   myService.print()

// добавляем коммент
    val commentToPost = CommentsObj(
        count = 1,
        canPost = false
    )
    // original.comments = commentToPost(count = original.likes?.count?.plus(1)) //какая то дичь(
    original.comments = commentToPost

 //   println("SYSTEM: Список постов с комментами \n")
//    myService.print()

////обновляем пост
//    val originalUpdated = Post(
//        333,
//        "обновленный пост это",
//        date = 21022022,
//        12345,
//        likes = null,
//        reposts = null,
//        attachermnts = null,
//        views = null,
//        original = null
//    )
//    var resultat = myService.update(originalUpdated)
//
//    println("SYSTEM: Обновление поста с id=${originalUpdated.id} = $resultat \n")
//    myService.print()

    val testAtt = Audio(
        1112233, 123, 333, null, null, 10
    )
    val testAtt2 = Audio(
        0, 1, 2, "3", "4", 5
    )
    val testAtt3 = Photo("хммм...", 1, 2, 3, "нет описания", 5, 6, 7) /* fixme почему опять type запрашивает,
    если я его уже определил при описании класса? */
    val att1 = attService.add(testAtt)
    val att2 = attService.add(testAtt2)
//    val att3 = attService.add(testAtt3)


    val originalUpdated = Post(
        2, // номер должен совпадать с имеющимся id иначе false
        "ОБНОВЛЕНИЕ + вложения",
        2022,
        0, // это поле игнорится при обновлении, но запрос обязательный при инициализации переменной
        likes = null,
        reposts = null,
        attachermnts = attService,
        views = null,
        original = null
    )
    var resultat = myService.update(originalUpdated)

    //println("SYSTEM: Добавление вложения с id=${originalUpdated.id} = $resultat \n")
    myService.print()
}