package ru.netology

import ru.netology.attacments.Audio
import ru.netology.attacments.Photo
import ru.netology.data.*
import ru.netology.service.AttService
import ru.netology.service.WallService

fun main() {
    val myService = WallService() //запуск сервиса работы с Post

    val originalPost = Post(id = 1, "это тестовый пост", 123)

    val newPost = Post(
        2,
        "второй пост",
        54321,
        2222222222,
        likes = null,
        reposts = null,
        attachermnts = null,
        views = null,
        original = null
    )

    val newPost3 = Post(3, "третий пост", 20022022, likes = null)

    myService.add(originalPost)
    myService.add(newPost)
    myService.add(newPost3)

/* добавляем коммент - соталось от предыдущей наработки
//    println("SYSTEM: Список постов \n")
//    myService.print()

//    // добавляем коммент - соталось от предыдущей наработки
//    val commentToPost = Comment(count = 1, canPost = false, comText = "очень интересный пост")
//    newPost.comments = commentToPost

//    println("SYSTEM: Список постов с комментами \n")
//    myService.print()
*/

    //обновляем первый пост новым содержимым
    val originalUpd = Post(
        1,
        "обновленный пост это",
        date = 0, ownerId = 0, //эти поля наследуется от источника, будет проигнорировано
        likes = null, reposts = null, attachermnts = null
    )

    val resultat = myService.update(originalUpd)
//    println("SYSTEM: Обновление поста с id=${originalUpd.id} = $resultat \n")
//    myService.print()

    val attService = AttService(originalPost.ownerId, originalPost.id) //запускаем сервис вложений на конкретный пост

    val testAtt = Audio(1112233,
        123333333, //игнорится тут это значение, берется из родителя
        333, null, null, 10)
    val testAtt2 = Audio(777888, 1, 2, "3", "4", 5)
    val testAtt3 = Photo( 24444, 2, 3,
        "нет описания", 5, 6, 7)

    val att1 = attService.add(testAtt)
    val att2 = attService.add(testAtt2)
    val att3 = attService.add(testAtt3)

    val attAddPost = Post(
        3, // номер должен совпадать с имеющимся id иначе false
        "вложения есть)",
        2022,
        0, // это поле игнорится при обновлении, но запрос обязательный при инициализации переменной
        likes = null,
        reposts = null,
        attachermnts = attService,
        views = null,
        original = null
    )

    myService.update(attAddPost)

//    println("SYSTEM: Добавление вложения с id=${attAddPost.id} = $resultat \n")
//    println("SYSTEM: ВИД с вложениями \n")
//    myService.print()

    val comment1 = Comment(
        1,100001, 2000, 1111111, "это первый коммнтарий в сервисе комментов"
    )
    println("-------------------------------Внедряем комменты---------------------------")
    myService.createComment(comment1)
    myService.print()

}