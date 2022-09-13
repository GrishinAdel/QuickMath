package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class Result : Fragment() {

    private val vm by viewModel<ResultViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onStart() {
        super.onStart()

        Log.e("Result","starting")

        val bundle= Bundle()

        val lvl = arguments?.getInt("lvl")
        val mode = arguments?.getString("mode")
        val isTime = arguments?.getString("time")
        bundle.putString("mode", mode)

        val lvl_textView = view?.findViewById<TextView>(R.id.nowResult)
        lvl_textView?.text = lvl.toString()

        val btn_go_to_next = view?.findViewById<ImageButton>(R.id.btn_next)
        val btn_go_to_reply = view?.findViewById<ImageButton>(R.id.btn_reply)
        val btn_go_to_home = view?.findViewById<ImageButton>(R.id.btn_home)
        val betterResultView = view?.findViewById<TextView>(R.id.betterResult)
        val iq_add = view?.findViewById<TextView>(R.id.iqAdd)
        val expression_answer = view?.findViewById<TextView>(R.id.expression_correct_answer)
        val correct_anwser = view?.findViewById<TextView>(R.id.expression_correct_answer2)
        val rateResult = view?.findViewById<TextView>(R.id.rateResult)

        correct_anwser?.text = arguments?.getString("correct_answer")
        expression_answer?.text="${arguments?.getString("expression")} ="

        var add_generator: Int = 0
        if (isTime.equals("yes")) add_generator= lvl!!*lvl!! + (0..lvl!!).random()
        else add_generator= lvl!!*2 + (0..lvl!!).random()

        vm.addRate(add_generator, lvl)

        if (add_generator!=0) iq_add?.text = "интеллект + ${add_generator}"

        vm.better_result(lvl, mode!!, isTime!!)

        vm.check_cup()

        btn_go_to_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_result_to_mainMenu2)
        }

        btn_go_to_reply?.setOnClickListener {
            bundle.putString("time", isTime)
            (activity as MainActivity).navController.navigate(R.id.action_result_to_starting, bundle)
        }

        btn_go_to_next?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_result_to_menu_mode2)
        }

        vm.getBetterResult().observe(viewLifecycleOwner, {
            betterResultView?.text = it.toString()
        })

        vm.getRateNow().observe(viewLifecycleOwner, {
            rateResult?.text = it.toString()
        })

        vm.getNewLvl().observe(viewLifecycleOwner, {
            if (it) {

            }
        })

        vm.getCup().observe(viewLifecycleOwner, {

        })

    }
}