package com.acalabuig.fundamentoskotlin.classes

import com.acalabuig.fundamentoskotlin.newTopic

fun main() {
    newTopic("Classes")

    val phone: Phone = Phone(616616616)
    phone.call()
    phone.showNumber()
    //println(phone.number)

    newTopic("Herencia")
    val smartphone = Smartphone(61616161, true)
    smartphone.call()

    newTopic("Sobreescritura")
    smartphone.showNumber()
    println("Privado? ${smartphone.isPrivate}")

    newTopic("Data classes")
    val myUser = User(0, "Antonio", "Calabuig", Group.FAMILY.ordinal)
    val bro = myUser.copy(1, "Ivan")
    val friend = bro.copy(2, lastName = "Ferrís", group = Group.FRIEND.ordinal)

    println(myUser.component3())
    println(myUser)
    println(bro)
    println(friend)

    newTopic("Funciones de alcance")
    with(smartphone) {
        println("Privado? $isPrivate")
        call()
    }

    friend.group = Group.WORK.ordinal
    friend.name = "Lorenzo"
    friend.lastName = "Brown"
    friend.apply {
        group = Group.WORK.ordinal
        name = "Lorenzo"
        lastName = "Brown"
    }
    println(friend)


}