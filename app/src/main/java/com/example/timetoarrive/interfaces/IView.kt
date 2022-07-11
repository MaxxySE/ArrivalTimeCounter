package com.example.timetoarrive.interfaces

interface IView {
    interface HomePage{
        fun setCharacteristics(carType: Int, carSpeed : Int, timeToArrive : Float)
    }
}