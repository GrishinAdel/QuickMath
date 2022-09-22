package com.adelvanchik.quickmath.presentation

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class Menu_mode : Fragment() {

    private val vm by viewModel<MenuModeModel>()

    private var levelAccess: Int = 0
    private val colorButton: String = "#257acf" // Цвет доступных кнопок

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_mode, container, false)
    }

    override fun onStart() {
        super.onStart()

        val bundle = Bundle()

        val btn_starting_additionSimple = view?.findViewById<Button>(R.id.Btn_starting_additionSimple)
        val btn_starting_additionHundreds = view?.findViewById<Button>(R.id.Btn_starting_additionHundreds)
        val btn_starting_multiplicationTable = view?.findViewById<Button>(R.id.Btn_starting_multiplicationTable)
        val btn_starting_multiplicationTableDivision = view?.findViewById<Button>(R.id.Btn_starting_multiplicationTableDivision)
        val btn_starting_negative_addition = view?.findViewById<Button>(R.id.Btn_starting_negative_addition)
        val btn_starting_negative_multiplication = view?.findViewById<Button>(R.id.Btn_starting_negative_multiplicationDivision)
        val btn_starting_negative_mixed = view?.findViewById<Button>(R.id.Btn_starting_negative_mixed)
        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_menu_mode_go_to_home)
        val btn_go_trineMode = view?.findViewById<Button>(R.id.btn_train_mode)

        vm.getLvlInfo()

        btn_starting_multiplicationTable?.setOnClickListener {
            bundle.putString("mode", "MultiplicationTable")
            bundle.putString("time", "yes")
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
        }

        btn_starting_multiplicationTableDivision?.setOnClickListener {
            if (levelAccess>=1) {
                bundle.putString("mode", "MultiplicationDivision")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
            }
        }

        btn_starting_additionSimple?.setOnClickListener {
            if (levelAccess>=2) {
                bundle.putString("mode", "SimpleAdditionSubtraction")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
            }

        }

        btn_starting_additionHundreds?.setOnClickListener {
            if (levelAccess>=3) {
                bundle.putString("mode", "HundredsAdditionSubtraction")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
            }
        }

        btn_starting_negative_multiplication?.setOnClickListener {
            if (levelAccess>=5) {
                bundle.putString("mode", "NegativeMultiplicationDivision")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
            }
        }

        btn_starting_negative_addition?.setOnClickListener {
            if (levelAccess>=6) {
                bundle.putString("mode", "NegativeAdditionSubtraction")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(
                    R.id.action_menu_mode_to_starting,
                    bundle
                )
            }
        }

        btn_starting_negative_mixed?.setOnClickListener {
            if (levelAccess>=7) {
                bundle.putString("mode", "NegativeMixed")
                bundle.putString("time", "yes")
                (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_starting, bundle)
            }
        }


        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_mainMenu)
        }

        btn_go_trineMode?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_menu_mode_to_menu_mode_2)
        }

        vm.getLvlInfoLiveData().observe(viewLifecycleOwner, {

            if (it >=1) {
                btn_starting_multiplicationTableDivision?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_multiplicationTableDivision?.setText(R.string.multiplicationDivision)
                btn_starting_multiplicationTableDivision?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 1
            }
            if (it >=2) {
                btn_starting_additionSimple?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_additionSimple?.setText(R.string.additionSimple)
                btn_starting_additionSimple?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 2
            }
            if (it >=3) {
                btn_starting_additionHundreds?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_additionHundreds?.setText(R.string.additionHundreds)
                btn_starting_additionHundreds?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 3
            }
            if (it >=4) {
                levelAccess = 4
            }
            if (it >=5) {
                btn_starting_negative_multiplication?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_negative_multiplication?.setText(R.string.negativeMultiplication)
                btn_starting_negative_multiplication?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 5
            }
            if (it >=6) {
                btn_starting_negative_addition?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_negative_addition?.setText(R.string.negativeAddition)
                btn_starting_negative_addition?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 6
            }
            if (it >=7) {
                btn_starting_negative_mixed?.setBackgroundColor(Color.parseColor(colorButton))
                btn_starting_negative_mixed?.setText(R.string.negativeMixed)
                btn_starting_negative_mixed?.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    resources.getDimension(R.dimen.button))
                levelAccess = 7
            }
            if (it >=8) {
                levelAccess = 8
            }


        })
    }
}