package ru.netology

import ru.netology.attacments.Audio
import ru.netology.attacments.Photo
import ru.netology.data.*
import ru.netology.service.AttService
import ru.netology.service.WallService

fun main() {
    val myService = WallService()

    val originalPost = Post(
        id = 1,
        "это тестовый пост",
        123,
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
        likes = null,
        attachermnts = null,
        views = null,

    )

    myService.add(originalPost)
    myService.add(newPost)
    myService.add(newPost3)

    println("SYSTEM: Список постов \n")
    myService.print()

// добавляем коммент
    val commentToPost = CommentsObj(
        count = 1,
        canPost = false
    )
    // original.comments = commentToPost(count = original.likes?.count?.plus(1)) //какая то дичь(
    originalPost.comments = commentToPost

 //   println("SYSTEM: Список постов с комментами \n")
//    myService.print()

//обновляем пост
//    val originalUpd = Post(
//        1,
//        "обновленный пост это",
//        date = 21022022,
//        12345, //todo это поле должно наследоваться от источника
//        likes = null,
//        reposts = null,
//        attachermnts = null,
//        views = null,
//        original = null
//    )
//    val resultat = myService.update(originalUpd)
//
//    println("SYSTEM: Обновление поста с id=${originalUpd.id} = $resultat \n")
//    myService.print()
//
//    val attService = AttService() //todo
//    val testAtt = Audio(
//        1112233, 123, 333, null, null, 10
//    )
//    val testAtt2 = Audio(
//        0, 1, 2, "3", "4", 5
//    )
//    val testAtt3 = Photo("хммм...", 1, 2, 3, "нет описания", 5, 6, 7) /* fixme почему опять type запрашивает,
//    если я его уже определил при описании класса? */
//    val att1 = attService.add(testAtt,)
//    val att2 = attService.add(testAtt2)
//    val att3 = attService.add(testAtt3)
//
//
//    val attAddPost = Post(
//        2, // номер должен совпадать с имеющимся id иначе false
//        "+ вложения",
//        2022,
//        0, // это поле игнорится при обновлении, но запрос обязательный при инициализации переменной
//        likes = null,
//        reposts = null,
//        attachermnts = attService,
//        views = null,
//        original = null
//    )
//
//    myService.update(attAddPost)
//
//    //println("SYSTEM: Добавление вложения с id=${originalUpdated.id} = $resultat \n")
//    println("SYSTEM: ИТОГОВЫЙ ВИД с вложениями \n")
//    myService.print()
}