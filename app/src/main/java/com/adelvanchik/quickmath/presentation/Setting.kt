package com.adelvanchik.quickmath.presentation

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.compose.ui.text.intl.Locale
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class Setting() : Fragment() {

    private val vm by viewModel<SettingViewModel>()
    private var timer: CountDownTimer? = null
    lateinit var locale: Locale

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onStart() {
        super.onStart()

        val btn_go_home = view?.findViewById<ImageButton>(R.id.btn_setting_go_to_home)
        btn_go_home?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_setting_to_mainMenu)
        }

        val save_name = view?.findViewById<Button>(R.id.save_name)
        save_name?.setBackgroundColor(Color.parseColor("#4f99e2"))
        val input_name = view?.findViewById<EditText>(R.id.input_name)
        save_name?.setOnClickListener {
            if (input_name?.text != null) {
                val name: String = input_name.text.toString()
                vm.saveNamePerson(name)
                input_name.text = null
                save_name.setBackgroundColor(Color.parseColor("#2d961d"))
                timer = object : CountDownTimer(100, 1) {
                    override fun onTick(timeM: Long) {
                    }

                    override fun onFinish() {
                        save_name.setBackgroundColor(Color.parseColor("#4f99e2"))
                    }
                }.start()
            }
        }

        vm.getlanguage()
        val language: Array<String> = arrayOf("Русский", "English")
        val spinnerLanguage = view?.findViewById<Spinner>(R.id.choice_language)
        val arrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, language)
        spinnerLanguage?.adapter = arrayAdapter
        spinnerLanguage?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when(position) {
                    0 -> {
                        setLocale("RU")
                        vm.saveLanguage(0)
                    }
                    1 -> {
                        setLocale("EN")
                        vm.saveLanguage(1)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        vm.getlanguageLiveData().observe(viewLifecycleOwner, {
            spinnerLanguage?.setSelection(it)
        })


        vm.getSoundClickMode()

        var sound: Array<String> = arrayOf("1","2")
        val spinnerSound = view?.findViewById<Spinner>(R.id.choice_sound)
        val arrayAdapterSound = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, sound)
        spinnerSound?.adapter = arrayAdapterSound
        spinnerSound?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long)
            {
                when(position) {
                    0 -> {
                        vm.soundClickSaveMode(0)
                    }
                    1 -> {
                        vm.soundClickSaveMode(1)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        vm.getSoundClickLiveData().observe(viewLifecycleOwner, {
            spinnerSound?.setSelection(it)
        })


        vm.getSoundMode()

        val settingSoundMode = view?.findViewById<Switch>(R.id.settingSoundMode)
        settingSoundMode?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                vm.soundSaveMode("on") // звук включен
            }else{
                vm.soundSaveMode("off") // звук выключен
            }
        }

        vm.getSoundLiveData().observe(viewLifecycleOwner, {
            if (it) settingSoundMode?.setChecked(true)
        })
    }


    fun setLocale(language: String) {
        locale = Locale(language)
    }

}