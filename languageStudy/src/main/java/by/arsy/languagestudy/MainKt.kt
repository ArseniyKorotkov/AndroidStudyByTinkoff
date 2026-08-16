package by.arsy.languagestudy

fun main() {
    val a = 5
    var result = 0
    var zeroCount: String

    while (true) {
        result = plus(a,result)

        if (result % 10 == 0) {
            zeroCount = when {
                result % 1000 == 0 -> "three"
                result % 100 == 0 -> "two"
                else -> "one"
            }
        } else {
            continue
        }

        println("result $result has ${zeroCount.uppercase()} zero")

        if (result > 5000) {
            break
        }
    }
}


fun plus(a: Int, b: Int): Int = a + b

