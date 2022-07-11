package com.example.timetoarrive.interfaces

interface IPresenter {
    interface HomePage{
        fun selectedCar(carType : Int, distance : Int, drivingIntensity : Int)
        fun setCharacteristics(carType: Int, carSpeed : Int, timeToArrive : Float)
    }
}