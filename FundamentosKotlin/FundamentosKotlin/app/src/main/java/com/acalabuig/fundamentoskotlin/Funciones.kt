package com.acalabuig.fundamentoskotlin

import kotlin.math.abs

fun main() {
    sayHello()

    newTopic("Argumentos")
    //println(sum(2,3))
    val a = 2
    val b = 3
    println("$a + $b = ${sum(a, b)}")
    println("$a - $b = ${sub(a, b)}")
    println("$a - $b = ${sub2(a, b)}")


    newTopic("INFIX")
    val c = -3
    println(c.enableAbs(false)) // no hacemos uso del false de momento
    println("$a - $b = ${sum(a, c)}")
    println("$a - $b = ${sum(a, c.enableAbs(false))}")
    println("$a - $b = ${sum(a, c.enableAbs(true))}")

    newTopic("Sobrecarga")
    //showProduct("Coca-Cola")
    showProduct("Coca-Cola", "10%")
    showProduct("Café")
    showProduct("Caramelos", "15%")
    showProduct("Caramelos", validez = "15 de marzo")
}

private fun sayHello(): Unit {
    println("Hola Kotlin")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun sub2(a: Int, b: Int) = a - b

//infix fun Int.enableAbs(enable: Boolean) = abs(this)
infix fun Int.enableAbs(enable: Boolean) = if (enable) abs(this) else this

fun showProduct(nombre: String, promo: String = "Sin promoción", validez: String = "agotar existencias") {
    println("$nombre => $promo hasta $validez")
}

