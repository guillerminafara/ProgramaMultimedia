package com.acalabuig.fundamentoskotlin

import com.acalabuig.fundamentoskotlin.classes.Group
import com.acalabuig.fundamentoskotlin.classes.User

fun main() {
    newTopic("Collections")
    newTopic("Solo lectura")

    val fruitList = listOf<String>("Manzana", "Banana", "Uva", "Lima")
    println(fruitList.get((0..fruitList.size-1).random()))
    println("El índice de la uva es ${fruitList.indexOf("Uva")}")

    newTopic("MutableList")

    val myUser = User(0, "Antonio", "Calabuig", Group.FAMILY.ordinal)
    val bro = myUser.copy(1, "Ivan")
    val friend = bro.copy(2, lastName = "Ferrís", group = Group.FRIEND.ordinal)

    val usersList = mutableListOf<User>(myUser, bro)
    println(usersList)

    usersList.add(friend)
    println(usersList)

    //usersList.removeAt(1) // borramos al bro
    usersList.remove(bro)
    println(usersList)

    val usersSelectedList = mutableListOf<User>()
    println(usersSelectedList)
    //usersSelectedList.addAll(usersList)
    usersSelectedList.add(myUser)
    println(usersSelectedList)
    usersSelectedList.set(0, bro) // para reemplazar un elemento
    println(usersSelectedList)

    usersSelectedList.add(myUser)
    usersSelectedList.add(myUser)
    println(usersSelectedList)

    newTopic("Map")
    val usersMap = mutableMapOf<Int, User>()
    println(usersMap)
    usersMap.put(myUser.id.toInt(), myUser)
    usersMap.put(myUser.id.toInt(), myUser)
    println(usersMap)

    usersMap.put(friend.id.toInt(), friend)
    println(usersMap)
    usersMap.remove(2)
    println(usersMap)

    println(usersMap.isEmpty())
    println(usersMap.containsKey(1))
    println(usersMap.containsKey(0))

    usersMap.put(bro.id.toInt(), bro)
    usersMap.put(friend.id.toInt(), friend)
    println(usersMap)
    println(usersMap.keys)
    println(usersMap.values)
}