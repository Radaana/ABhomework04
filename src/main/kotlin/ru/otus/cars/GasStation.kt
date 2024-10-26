package ru.otus.cars

import kotlin.random.Random

object GasStation {
    fun fuelCar(car: Car) {
        try {
            println(car.carOutput.getFuelContents())
            when (car.mouth.type) {
                FuelType.LPG -> fuelWithLpg(car.mouth as LpgMouth)
                FuelType.PETROL -> fuelWithPetrol(car.mouth as PetrolMouth)
            }
            println(car.carOutput.getFuelContents())

        } catch (e :NotImplementedError) {
            println("Опять этот таз приехал")
        }
    }


    private fun fuelWithLpg(tankMouth: LpgMouth) {
        tankMouth.fuelLpg(Random.nextInt(0, 200))
    }

    private fun fuelWithPetrol(tankMouth: PetrolMouth) {
        tankMouth.fuelPetrol(Random.nextInt(0, 200))
    }
}