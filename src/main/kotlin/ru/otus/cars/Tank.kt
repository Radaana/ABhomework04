package ru.otus.cars

interface Tank {
    var fuelLevel: Int

    fun getContents(): String

    fun receiveFuel(liters: Int)
}

enum class FuelType(val type: String) {
    PETROL("Бензин"),
    LPG("Сжиженный газ")
}

abstract class TankMouth(val type: FuelType): Tank {
    override var fuelLevel: Int = 0
    override fun getContents(): String {
        return "Тип топлива: ${type.type}, уровень $fuelLevel"
    }

    override fun receiveFuel(liters: Int) {
        open()
        fuelLevel += liters
        close()
    }

    private fun open() {
        println("Горловина открыта")
    }
    private fun close() {
        println("Горловина закрыта")
    }
}

class PetrolMouth: TankMouth(FuelType.PETROL) {
    fun fuelPetrol(liters: Int) {
        receiveFuel(liters)
    }
}

class LpgMouth: TankMouth(FuelType.LPG) {
    fun fuelLpg(liters: Int) {
        receiveFuel(liters)
    }
}