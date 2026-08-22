package by.arsy.languagestudy.exceptions

import java.io.File
import java.io.IOException
import java.io.Reader

fun main() {
    throwException()
    withoutHandleException()
    catchException()
    finallyException()
}

class MyException(
    override val message: String?
) : Exception()

private fun throwException() {
    throw MyException("My exception")
}

private fun withoutHandleException() {
    val reader = File("myfile.txt").bufferedReader()
    println(reader.readText())
}

private fun catchException() {
    var reader: Reader? = null
    try {
        reader = File("myfile.txt").bufferedReader()
        println(reader.readText())
    } catch (e: IOException) {
        println("Happen exception: ${e.message}")
    } finally {
        println("End program")
        reader?.close()
    }
}

private fun finallyException() {
    var reader: Reader? = null
    try {
        reader = File("myfile.txt").bufferedReader()
        println(reader.readText())
    } finally {
        println("End program")
        reader?.close()
    }
}