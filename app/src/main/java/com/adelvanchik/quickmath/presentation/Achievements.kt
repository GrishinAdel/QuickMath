package com.adelvanchik.quickmath.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class Achievements : Fragment() {

    private val vm by viewModel<AchievementsViewModel>()

    private val colorCup: String = "#fee067"
    private val colorText: String = "#000000"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    override fun onStart() {
        super.onStart()

        val cup_77_expression = view?.findViewById<ImageView>(R.id.cup_77_expression)
        val cup_777_expression = view?.findViewById<ImageView>(R.id.cup_777_expression)
        val cup_7777_expression = view?.findViewById<ImageView>(R.id.cup_7777_expression)
        val cup_result_30 = view?.findViewById<ImageView>(R.id.cup_result_30)
        val cup_result_50 = view?.findViewById<ImageView>(R.id.cup_result_50)
        val cup_result_100 = view?.findViewById<ImageView>(R.id.cup_result_100)
        val cup_all_mode = view?.findViewById<ImageView>(R.id.cup_all_mode)
        val cup_have_5_cup = view?.findViewById<ImageView>(R.id.cup_have_5_cup)

        val cup_77_expression_text = view?.findViewById<TextView>(R.id.cup_77_expression_text)
        val cup_777_expression_text = view?.findViewById<TextView>(R.id.cup_777_expression_text)
        val cup_7777_expression_text= view?.findViewById<TextView>(R.id.cup_7777_expression_text)
        val cup_result_30_text = view?.findViewById<TextView>(R.id.cup_result_30_text)
        val cup_result_50_text = view?.findViewById<TextView>(R.id.cup_result_50_text)
        val cup_result_100_text = view?.findViewById<TextView>(R.id.cup_result_100_text)
        val cup_all_mode_text = view?.findViewById<TextView>(R.id.cup_all_mode_text)
        val cup_have_5_cup_text = view?.findViewById<TextView>(R.id.cup_have_5_cup_text)

        vm.check_cup()

        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_ach_go_home)
        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_achievements_to_mainMenu)
        }

        vm.get_cup_77_expression().observe(viewLifecycleOwner, {
            if(it) {
                cup_77_expression?.setBackgroundColor(Color.parseColor(colorCup))
                cup_77_expression_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_77_expression_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_777_expression().observe(viewLifecycleOwner, {
            if(it) {
                cup_777_expression?.setBackgroundColor(Color.parseColor(colorCup))
                cup_777_expression_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_777_expression_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_7777_expression().observe(viewLifecycleOwner, {
            if(it) {
                cup_7777_expression?.setBackgroundColor(Color.parseColor(colorCup))
                cup_7777_expression_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_7777_expression_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_better_result_30().observe(viewLifecycleOwner, {
            if(it) {
                cup_result_30?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_30_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_30_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_better_result_50().observe(viewLifecycleOwner, {
            if(it) {
                cup_result_50?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_50_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_50_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_better_result_100().observe(viewLifecycleOwner, {
            if(it) {
                cup_result_100?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_100_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_result_100_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_all_mode().observe(viewLifecycleOwner, {
            if(it) {
                cup_all_mode?.setBackgroundColor(Color.parseColor(colorCup))
                cup_all_mode_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_all_mode_text?.setTextColor(Color.parseColor(colorText))
            }
        })
        vm.get_cup_have_5_cup().observe(viewLifecycleOwner, {
            if(it) {
                cup_have_5_cup?.setBackgroundColor(Color.parseColor(colorCup))
                cup_have_5_cup_text?.setBackgroundColor(Color.parseColor(colorCup))
                cup_have_5_cup_text?.setTextColor(Color.parseColor(colorText))
            }
        })


    }



}