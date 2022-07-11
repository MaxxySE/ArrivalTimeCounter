package com.example.timetoarrive.presenters

import com.example.timetoarrive.interfaces.IModel
import com.example.timetoarrive.interfaces.IPresenter
import com.example.timetoarrive.interfaces.IView
import com.example.timetoarrive.models.HomePageModel

class HomePagePresenter(var iView: IView.HomePage) : IPresenter.HomePage {

    var iModel : IModel.HomePage = HomePageModel(this)

    override fun selectedCar(carType: Int, distance: Int, drivingIntensity: Int) {
        iModel.selectedCar(carType, distance, drivingIntensity)
    }

    override fun setCharacteristics(carType: Int, carSpeed: Int, timeToArrive: Float) {
        iView.setCharacteristics(carType, carSpeed, timeToArrive)
    }

}