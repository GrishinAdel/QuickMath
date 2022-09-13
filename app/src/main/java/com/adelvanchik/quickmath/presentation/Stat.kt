package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class Stat : Fragment() {

    private val vm by viewModel<StatViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stat, container, false)
    }

    override fun onStart() {
        super.onStart()

        val info_better_count_cup = view?.findViewById<TextView>(R.id.info_better_count_cup)
        val info_better_result = view?.findViewById<TextView>(R.id.info_better_result)
        val info_count_expression = view?.findViewById<TextView>(R.id.info_count_expression)

        val info_negativeAddition_inTime = view?.findViewById<TextView>(R.id.info_negativeAddition_inTime)
        val info_negativeMultiplication_inTime = view?.findViewById<TextView>(R.id.info_negativeMultiplication_inTime)
        val info_negativeMixed_inTime = view?.findViewById<TextView>(R.id.info_negativeMixed_inTime)
        val info_multiplication_inTime = view?.findViewById<TextView>(R.id.info_multiplication_inTime)
        val info_multiplicationDivision_inTime = view?.findViewById<TextView>(R.id.info_multiplicationDivision_inTime)
        val info_simpleAddition_inTime = view?.findViewById<TextView>(R.id.info_simpleAddition_inTime)
        val info_hundredsAddition_inTime = view?.findViewById<TextView>(R.id.info_hundredsAddition_inTime)

        val info_negativeAddition_train = view?.findViewById<TextView>(R.id.info_negativeAddition_train)
        val info_negativeMultiplication_train = view?.findViewById<TextView>(R.id.info_negativeMultiplication_train)
        val info_negativeMixed_train = view?.findViewById<TextView>(R.id.info_negativeMixed_train)
        val info_multiplication_train = view?.findViewById<TextView>(R.id.info_multiplication_train)
        val info_multiplicationDivision_train = view?.findViewById<TextView>(R.id.info_multiplicationDivision_train)
        val info_simpleAddition_train = view?.findViewById<TextView>(R.id.info_simpleAddition_train)
        val info_hundredsAddition_train = view?.findViewById<TextView>(R.id.info_hundredsAddition_train)
        val info_mixed_train = view?.findViewById<TextView>(R.id.info_mixed_train)

        val lvlInfoTextView = view?.findViewById<TextView>(R.id.lvlInfo_TextView)
        val lvlIntTextView = view?.findViewById<TextView>(R.id.lvlInt_textView)

        vm.info()

        val btn_back = view?.findViewById<ImageButton>(R.id.btn_stat_go_profile)
        btn_back?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_stat_to_profile)
        }

        vm.get_info_negativeAddition_inTime().observe(viewLifecycleOwner, {
            info_negativeAddition_inTime?.text = it.toString()
        })
        vm.get_info_negativeAddition_train().observe(viewLifecycleOwner, {
            info_negativeAddition_train?.text = it.toString()
        })
        vm.get_info_negativeMultiplication_inTime().observe(viewLifecycleOwner, {
            info_negativeMultiplication_inTime?.text = it.toString()
        })
        vm.get_info_negativeMultiplication_train().observe(viewLifecycleOwner, {
            info_negativeMultiplication_train?.text = it.toString()
        })
        vm.get_info_negativeMixed_inTime().observe(viewLifecycleOwner, {
            info_negativeMixed_inTime?.text = it.toString()
        })
        vm.get_info_negativeMixed_train().observe(viewLifecycleOwner, {
            info_negativeMixed_train?.text = it.toString()
        })

        vm.get_info_betterResultGame().observe(viewLifecycleOwner, {
            info_better_result?.text = it.toString()
        })
        vm.get_info_countCup().observe(viewLifecycleOwner, {
            info_better_count_cup?.text = "$it / 8"
        })
        vm.get_info_countExpression().observe(viewLifecycleOwner, {
            info_count_expression?.text = it.toString()
        })
        vm.get_info_mixedtrain().observe(viewLifecycleOwner, {
            info_mixed_train?.text = it.toString()
        })
        vm.get_info_hundredsAddition_train().observe(viewLifecycleOwner, {
            info_hundredsAddition_train?.text = it.toString()
        })
        vm.get_info_hundredsAddition_inTime().observe(viewLifecycleOwner, {
            info_hundredsAddition_inTime?.text = it.toString()
        })
        vm.get_info_simpleAddition_train().observe(viewLifecycleOwner, {
            info_simpleAddition_train?.text = it.toString()
        })
        vm.get_info_simpleAddition_inTime().observe(viewLifecycleOwner, {
            info_simpleAddition_inTime?.text = it.toString()
        })
        vm.get_info_multiplicationDivision_train().observe(viewLifecycleOwner, {
            info_multiplicationDivision_train?.text = it.toString()
        })
        vm.get_info_multiplicationDivision_inTime().observe(viewLifecycleOwner, {
            info_multiplicationDivision_inTime?.text = it.toString()
        })
        vm.get_info_multiplication_train().observe(viewLifecycleOwner, {
            info_multiplication_train?.text = it.toString()
        })
        vm.get_info_multiplication_inTime().observe(viewLifecycleOwner, {
            info_multiplication_inTime?.text = it.toString()
        })


    }
}