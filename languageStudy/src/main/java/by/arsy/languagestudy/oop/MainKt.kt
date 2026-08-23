package by.arsy.languagestudy.oop

abstract class Car() { // abstraction
    abstract fun startEngine()
}

open class SportCar(): Car() { // inheritance
    override fun startEngine() {
        println("Start sport engine")
    }
}

class Bolide(): SportCar() // inheritance

fun main() {
    val myBolide = Bolide()
    startCarEngine(car = myBolide) // polymorphism
}

private fun startCarEngine(car: Car) { // polymorphism
    car.startEngine()
}