package net.effective.가변성_제한

fun main() {

    val exam = SmartCast()

    // get() 은 스마트 캐스트가 불가능하다. if 문에서 NULL 체크를 했다고 해도 아래 구문에서 다시 null 체크가 되어야 한다.
//    if (exam.fullName != null) {
//        println(exam.fullName.length)
//    }

    if (exam.fullName2 != null) {
        println(exam.fullName2.length)
    }


}

class SmartCast {
    val name: String? = "KIM"
    val surname: String = "haha"

    val fullName: String?
        get() = name?.let { "$it $surname" }

    val fullName2: String? = name?.let { "$it $surname" }
}