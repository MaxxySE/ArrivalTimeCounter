package com.example.timetoarrive.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.timetoarrive.R
import com.example.timetoarrive.interfaces.IPresenter
import com.example.timetoarrive.interfaces.IView
import com.example.timetoarrive.presenters.HomePagePresenter
import java.util.*
import kotlin.properties.Delegates


class HomePageFragment : Fragment(), IView.HomePage {

    var homePagePresenter : IPresenter.HomePage = HomePagePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        selectorsDefiner(view, R.id.carSelector, R.array.cars)
        selectorsDefiner(view, R.id.intensiveSelector, R.array.intensive)
        resultBtnListener(view)
        return view
    }

    private fun selectorsDefiner(view : View, selectorId : Int, arrayId : Int){
        var spinner : Spinner = view.findViewById(selectorId)
        var arrayAdapter : ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(requireActivity().applicationContext
                , arrayId, android.R.layout.simple_spinner_item)

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
    }

    private fun resultBtnListener(view : View){

        view.findViewById<Button>(R.id.resultsBtn).setOnClickListener {
            val carType = view.findViewById<Spinner>(R.id.carSelector).selectedItemPosition + 1
            val distance = view.findViewById<TextView>(R.id.distanceField).text.toString().toInt()
            val intensity = view.findViewById<Spinner>(R.id.intensiveSelector).selectedItemPosition + 1
            homePagePresenter.selectedCar(carType, distance.toString().toInt(), intensity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomePageFragment()
    }

    @SuppressLint("SetTextI18n")
    override fun setCharacteristics(carType: Int, carSpeed: Int, timeToArrive: Float) {
        activity?.findViewById<TextView>(R.id.characteristicsText)?.
        text = "Car: $carType \nSpeed: $carSpeed \nArrival time: $timeToArrive"
    }
}