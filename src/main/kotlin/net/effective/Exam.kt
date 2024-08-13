package net.effective

fun main() {
    val list = listOf(1, 2, 3, 4)

    if (list is MutableList) {
        list.add(4)
    }
}

class Exam {

}