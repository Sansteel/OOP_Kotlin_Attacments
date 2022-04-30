package ru.netology

import ru.netology.attacments.Audio
import ru.netology.attacments.Photo
import ru.netology.data.*
import ru.netology.service.AttService
import ru.netology.service.WallService

fun main() {
    val myService = WallService() //запуск сервиса работы с Post

    val originalPost = Post(id = 1, "это тестовый пост", 123)

    val newPost = Post(2, "второй пост", 54321, 2222222222,
        likes = null, reposts = null, attachermnts = null, views = null, original = null)

    val newPost3 = Post(3, "третий пост", 20022022, likes = null)

    myService.add(originalPost)
    myService.add(newPost)
    myService.add(newPost3)

/* добавляем коммент - оcталось от предыдущей наработки
//    println("SYSTEM: Список постов \n")
//    myService.print()

//    // добавляем коммент - соталось от предыдущей наработки
//    val commentToPost = Comment(count = 1, canPost = false, comText = "очень интересный пост")
//    newPost.comments = commentToPost

//    println("SYSTEM: Список постов с комментами \n")
//    myService.print()
*/

    //обновляем первый пост новым содержимым
    val updatePost = Post(
        1,
        "этот пост был обновлен",
        date = 0, ownerId = 0, //эти поля наследуется от источника, будет проигнорировано
    )

    val resultat = myService.update(updatePost) //сам ищет и обновляет нужный Post

//    println("SYSTEM: Обновление поста с id=${originalUpd.id} = $resultat \n")
//    myService.print()

//    val attService = AttService(originalPost.ownerId, originalPost.id) //запускаем сервис вложений на конкретный пост
    val attService = AttService()

    val testAtt1 = Audio(1112233,123333333, 2,333, null, null, 10)
    val testAtt2 = Audio(777888, 1, 3, 3,"3", "4", 5)
    val testAtt3 = Photo( 24444, 2, 3,3,"нет описания", 5, 6, 7)

    val att1 = attService.add(testAtt1, testAtt1.postID)
    val att2 = attService.add(testAtt2, testAtt2.postID)
    val att3 = attService.add(testAtt3, testAtt3.postID)

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

    println("SYSTEM: Добавление вложения с id=${attAddPost.id} = $resultat \n")
    println("SYSTEM: ИТОГОВЫЙ ВИД с вложениями \n")
    myService.print()
}