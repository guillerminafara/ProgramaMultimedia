package com.acalabuig.fundamentoskotlin

const val separator = "==========="

fun main() {
    //print("hola kotlin")
    newTopic("Hola Kotlin")

    newTopic("Variables y Constantes")
    //val a = 2
    //val a = "Hola"
    val a = true
    println("a = $a")

    //var b = 2
    //b = 3
    //b =  "Hola"
    //println("b = $b")

    var b: Int
    b = 5
    println("b = $b")

    var objNull: Any?
    objNull = null
    objNull = "Hi"

    if (objNull != null) {
        println(objNull)
    }
    println(objNull)
}

fun newTopic(topic: String) {
    //println()
    //print("=========== ")
    //print(topic)
    //print(" =========== ")
    //println()

    println("\n$separator $topic $separator")
}

