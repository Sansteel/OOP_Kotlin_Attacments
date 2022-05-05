package ru.netology.service

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.exeptions.PostNotFoundException

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        // arrange
        val testPost1 = Post(
            id = 0,
            "Тестим add",
            0,
            0,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )
        val testPost2 = Post(
            id = 1,
            "Once more text",
            1,
            1,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )
        val expextedPosts = listOf(testPost1, testPost2)
        // act
        service.add(testPost1)
        service.add(testPost2)
        val actualResult = listOf(service.posts[0], service.posts[1])

        // assert
        assertEquals(expextedPosts, actualResult)
    }

    @Test
    fun update_true() {
        // arrange
        val serviceUpdate = WallService()
        val testPost101 = Post(
            id = 12345,
            "Тестим true",
            0,
            0,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )

        val testPost102 = Post(
            id = 12345,
            "updated",
            0,
            0,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )


        // act
        serviceUpdate.update(testPost102)
        serviceUpdate.add(testPost101)
        val actualResultUpd = serviceUpdate.update(testPost102)

        // assert
        assertTrue(actualResultUpd)
    }

    @Test
    fun update_false() {
        // arrange
        val testServise = WallService()
        val testPost103 = Post(
            id = 12345,
            "Тестим false",
            0,
            0,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )

        val testPost203 = Post(
            id = 1234,
            "updated",
            0,
            0,
            likes = null,
            reposts = null,
            attachermnts = null,
            views = null,
            original = null
        )


        // act
        testServise.add(testPost103)
        testServise.update(testPost203)
        val actualResultUpd = testServise.update(testPost203)

        // assert
        assertFalse(actualResultUpd)
    }

    //new test for exception task
    @Test
    fun findByIdTrue() {
        val service = WallService()

        // arrange
        val testPost1 = Post(
            id = 1,
            "тут у нас findById должен сработать",
            123,
            33333,
        )
        // act
        service.add(testPost1)
        service.print()

        val expextedResult = testPost1
        val actualResult = service.findById(1)

        // assert
        assertEquals(expextedResult, actualResult)
    }

    @Test(expected = PostNotFoundException::class)
    fun findByIdExcept() {
        val service = WallService()

        // arrange
        val testPost1 = Post(
            id = 1,
            "тестируем искл функции findById",
            123,
            33333,
        )
        // act
        service.add(testPost1)
        service.print()

        //Assert
        service.findById(22) //чекаем наш искл
    }

    @Test
    fun createCommentTrue() {
        val service = WallService()

        // arrange
        val testPost1 = Post(
            id = 1,
            "тут у нас createComment должен сработать",
            123,
            33333,
        )
        // act
        service.add(testPost1)

        val comment1 = Comment(
            1,100001, 2000, 1111111, "это первый коммнтарий в сервисе комментов"
        )
        service.createComment(comment1)

        service.print()

        val expextedResult = testPost1.comments?.size
        val actualResult = 1 //чекаем факт добавления коммента к посту

        // assert
        assertEquals(expextedResult, actualResult)
    }

    //@Ignore("WHY???")
    @Test(expected = PostNotFoundException::class)
    fun createCommentExcep() {
        val service = WallService()

        // arrange
        val testPost1 = Post(
            id = 1,
            "тут у нас createComment тестируется",
            123,
            33333,
        )
        // act
        service.add(testPost1)

        val comment1 = Comment(
            2, 100001, 2000, 1111111, "это первый коммнтарий в сервисе комментов"
        )

        // assert
        service.createComment(comment1) //ловим исключение
    }

}