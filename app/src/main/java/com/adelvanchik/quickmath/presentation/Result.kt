package com.adelvanchik.quickmath.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.adelvanchik.quickmath.R
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds
import org.koin.androidx.viewmodel.ext.android.viewModel




class Result : Fragment() {

    private val vm by viewModel<ResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        MobileAds.initialize(requireContext()) {}

        val banner = view?.findViewById<BannerAdView>(R.id.banner)
        val adRequest = AdRequest.Builder().build()
        banner?.loadAd(adRequest)

        Log.e("Result","starting")

        val bundle= Bundle()

        val lvl = arguments?.getInt("lvl")
        val mode = arguments?.getString("mode")
        val isTime = arguments?.getString("time")
        bundle.putString("mode", mode)

        val lvl_textView = view?.findViewById<TextView>(R.id.nowResult)
        val nowResultText: String = resources.getString(R.string.myResult)
        lvl_textView?.text = "${nowResultText}  ${lvl}"

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

        val intil = resources.getString(R.string.intellect)
        val InteligenceSmall = resources.getString(R.string.intellectSmall)
        if (add_generator!=0) iq_add?.text = "${InteligenceSmall} + ${add_generator}"

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
            val betterText: String = resources.getString(R.string.betterResult)
            betterResultView?.text = "${betterText}  ${it}"
        })

        vm.getRateNow().observe(viewLifecycleOwner, {
            val Inteligence: String = resources.getString(R.string.intellect)
            rateResult?.text = "${Inteligence} ${it}"
            val result = it.toInt()
            var lvlInfoMaybeNew: String = ""
            if (result>100000) lvlInfoMaybeNew = resources.getString(R.string.lvl8)
            else if (result > 50000) lvlInfoMaybeNew = resources.getString(R.string.lvl7)
            else if (result > 30000) lvlInfoMaybeNew = resources.getString(R.string.lvl6)
            else if (result > 15000) lvlInfoMaybeNew = resources.getString(R.string.lvl7)
            else if (result > 75000) lvlInfoMaybeNew = resources.getString(R.string.lvl4)
            else if (result > 3000) lvlInfoMaybeNew = resources.getString(R.string.lvl3)
            else if (result > 1000) lvlInfoMaybeNew = resources.getString(R.string.lvl2)
            else if (result > 300) lvlInfoMaybeNew = resources.getString(R.string.lvl1)
            else lvlInfoMaybeNew = resources.getString(R.string.lvl0)
            vm.checkNewLvl(lvlInfoMaybeNew)
        })

        vm.getNewLvl().observe(viewLifecycleOwner, {
            if (it) {
                val newLvlText: String = resources.getString(R.string.getNewLvl)
                Toast.makeText(requireContext(), newLvlText , Toast.LENGTH_SHORT).show()
            }
        })

        vm.getCup().observe(viewLifecycleOwner, {
            if (it) {
                val newCupText: String = resources.getString(R.string.getNewCup)
                Toast.makeText(requireContext(), newCupText , Toast.LENGTH_SHORT).show()
            }
        })

    }
}