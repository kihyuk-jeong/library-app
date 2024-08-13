package net.effective.변수_스코프_최소화

fun update(degree: Int) {
    val description: String
    val color: Int
    if (degree < 5) {
        description = "cold"
        color = 1
    } else if (degree < 23) {
        description = "mild"
        color = 2
    } else {
        description = "hot"
        color = 3
    }

    println(description)
    println(color)
}

fun update_good(degree: Int) {
    val (description, color) = when {
        degree < 5 -> "cold" to 1
        degree < 23 -> "mild" to 2
        else -> "hot" to 3
    }

    println(description)
    println(color)
}

/**
 * 1. take 로 10 을 호출한다는 것은 총 10개의 소수를 리턴 받는다는 뜻
 * 2. generateSequence 는 2부터 1씩 증가하는 무한 시퀀스를 반환한다.
 * 3. while 내 prime 변수에는 첫 번째 소수인 2 가 리턴된다.
 * 4. yield 를 통해 prime 값을 반환한다. 첫 번째 반복문에서는 2가 된다.
 * 5. drop(1) 은 첫 번쨰 요소를 제외 (처음엔 2) 하고, filter 를 수행한다.
 * 6. filter 로 인해 2의 배수는 시퀀스에서 모두 제거된다.
 * 7. 다음 반복문에서는 2의 배수가 제거되었기 때문에 3이 first 가 된다.
 * 8. yield 를 통해 3이 반환된다.
 * 9. 3을 제외한 3의 배수를 모두 제거한다.
 * 10. 다음 first 는 5가 된다.
 */
fun prime() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2){ it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }

    val toList: List<Int> = primes.take(5).toList()
}

fun main() {
    val primes = prime()

}
class Main {
}