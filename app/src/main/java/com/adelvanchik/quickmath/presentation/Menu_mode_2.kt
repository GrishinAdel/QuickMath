package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.adelvanchik.quickmath.R

class Menu_mode_2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_mode_2, container, false)
    }

    override fun onStart() {
        super.onStart()

        val bundle = Bundle()

        val btn_starting_additionSimple = view?.findViewById<Button>(R.id.Btn_starting_additionSimple2)
        val btn_starting_additionHundreds = view?.findViewById<Button>(R.id.Btn_starting_additionHundreds2)
        val btn_starting_multiplicationTable = view?.findViewById<Button>(R.id.Btn_starting_multiplicationTable2)
        val btn_starting_multiplicationTableDivision = view?.findViewById<Button>(R.id.Btn_starting_multiplicationTableDivision2)
        val btn_starting_negative_addition = view?.findViewById<Button>(R.id.Btn_starting_negative_addition2)
        val btn_starting_negative_multiplication = view?.findViewById<Button>(R.id.Btn_starting_negative_multiplicationDivision2)
        val btn_starting_negative_mixed = view?.findViewById<Button>(R.id.Btn_starting_negative_mixed2)
        val btn_starting_mixed = view?.findViewById<Button>(R.id.Btn_starting_mixed)
        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_menu_mode_go_to_home2)
        val btn_go_timeMode = view?.findViewById<Button>(R.id.btn_time_mode)


        btn_starting_multiplicationTable?.setOnClickListener {
            bundle.putString("mode", "MultiplicationTable")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_multiplicationTableDivision?.setOnClickListener {
            bundle.putString("mode", "MultiplicationDivision")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_additionSimple?.setOnClickListener {
            bundle.putString("mode", "SimpleAdditionSubtraction")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_additionHundreds?.setOnClickListener {
            bundle.putString("mode", "HundredsAdditionSubtraction")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_mixed?.setOnClickListener {
            bundle.putString("mode", "mixed")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_negative_addition?.setOnClickListener {
            bundle.putString("mode", "NegativeAdditionSubtraction")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_negative_multiplication?.setOnClickListener {
            bundle.putString("mode", "NegativeMultiplicationDivision")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }

        btn_starting_negative_mixed?.setOnClickListener {
            bundle.putString("mode", "NegativeMixed")
            bundle.putString("time", "no")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_starting, bundle)
        }


        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_mainMenu)
        }

        btn_go_timeMode?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_2_to_menu_mode)
        }


    }
}