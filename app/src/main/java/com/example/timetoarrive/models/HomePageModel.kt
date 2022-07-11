package com.example.timetoarrive.models

import com.example.timetoarrive.interfaces.IModel
import com.example.timetoarrive.interfaces.IPresenter
import kotlin.properties.Delegates

class HomePageModel(var iPresenter: IPresenter.HomePage) : IModel.HomePage {

    private var carSpeed by Delegates.notNull<Int>()

    override fun selectedCar(carType: Int, distance: Int, drivingIntensity: Int) {
        val arrivalTime = arrivalTimeDefiner(carType, distance, drivingIntensity)
        iPresenter.setCharacteristics(carType, carSpeed, arrivalTime)
    }

    private fun arrivalTimeDefiner(carId : Int, distance: Int, drivingIntensity: Int) : Float{

        when (carId) {
            1 -> {
                carSpeed = 60
            }
            2 -> {
                carSpeed = 80
            }
            3 -> {
                carSpeed = 100
            }
            4 -> {
                carSpeed = 120
            }
        }

        return (distance.toFloat()/carSpeed.toFloat()) * drivingIntensity.toFloat()
    }
}