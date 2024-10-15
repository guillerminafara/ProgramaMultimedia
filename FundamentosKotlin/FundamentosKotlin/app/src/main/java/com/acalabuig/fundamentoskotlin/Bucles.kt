package com.acalabuig.fundamentoskotlin

fun main() {
    newTopic("Bucles")
    showPeople("Angel", "Miguel", "Laura")

    showPeople2("Angel", "Miguel", "Pau", "Rubén", "Vicente")
}

fun showPeople(p1: String, p2: String, p3: String) {
    println(p1)
    println(p2)
    println(p3)
}

fun showPeople2(vararg people: String) {
    newTopic("For")

    for (person in people) {
        println(person)
    }

    // for (person in people) println(person)

    newTopic("While")

    var index = 0

    while (index < people.size) {
        if (people[index] == "Pau") {
            println("Es Pau!")
        }

        println(people[index])
        index++
    }

    newTopic("When")
    index = (0..people.size-1).random()
    when (people[index]) {
        "Angel" -> println("Es Ángel!")
        "Laura" -> {
            println("Es Laura!")
            println("Ir a otra pantalla")
        }
        else -> println(people[index])
    }
}

