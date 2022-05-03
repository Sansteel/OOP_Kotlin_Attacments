package ru.netology.exeptions

class PostNotFoundException() : RuntimeException() {

    init {
        println("====================")
        println("Cons! Its PostNotFoundException!")
        println("====================")
    }
}