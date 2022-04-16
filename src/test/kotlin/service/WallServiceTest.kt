package ru.netology.service

import org.junit.Test

import org.junit.Assert.*
import ru.netology.data.Post
import java.util.*

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

}
