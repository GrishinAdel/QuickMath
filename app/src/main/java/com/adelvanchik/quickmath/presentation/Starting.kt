package com.adelvanchik.quickmath.presentation

import android.graphics.Color
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.adelvanchik.quickmath.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class Starting : Fragment() {

    private val vm by viewModel<StartingViewModel>()
    val bundle = Bundle()

    private var timer: CountDownTimer? = null
    private var sound: Boolean = true
    private var button_number_sound: Int = 0
    private var soundButton: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Получение информациии с предыдущего фрагмента о режиме
        val mode: String = arguments?.getString("mode").toString()
        bundle.putString("mode", mode)
        val isTime: String = arguments?.getString("time").toString()
        bundle.putString("time", isTime)

        if (vm.getFirst_load().value != true) {
            vm.start(mode, isTime)
        }
        return inflater.inflate(R.layout.fragment_starting, container, false)
    }


    override fun onStart() {
        super.onStart()

        val answerCorrectId = getResources().getIdentifier(R.raw.sound_answer_correct.toString(),
            "raw", activity?.packageName)
        val soundAnswerCorrect= MediaPlayer.create(context, answerCorrectId)


        // Кнопка проверки ответа
        val btn_Next = view?.findViewById<Button>(R.id.Btn_Next)

        btn_Next?.setBackgroundColor(Color.parseColor("#257acf"))

        btn_Next?.setOnClickListener {
            Log.e("Starting","Кнопка нажимается")

            if (vm.getAnswer().value != "" && vm.getAnswer().value != null && vm.getCorrectResult().value!= null) {
                Log.e("Starting","Кнопка нажимается. Отправляем запрос на проверку ответа")
                if (vm.Check_answer()) {

                    if (sound) soundAnswerCorrect.start()
                    vm.createExpression()
                    btn_Next.setBackgroundColor(Color.parseColor("#11d418"))
                    timer = object: CountDownTimer(50, 1) {
                        override fun onTick(timeM: Long) {

                        }
                        override fun onFinish() {
                            btn_Next.setBackgroundColor(Color.parseColor("#257acf"))
                            timer?.cancel()
                        }
                    }.start()
                } else {
                    Log.e("Starting","Проверка пришла ответ неверный ")
                    btn_Next.setBackgroundColor(Color.parseColor("#ba0303"))
                    go_result()
                }
                Log.e("Starting"," Проверка пришла. Ответ верный")
            }
        }


        // Кнопки ввода

        val btn_minus = view?.findViewById<Button>(R.id.btn_minus)
        val btn_zero = view?.findViewById<Button>(R.id.btn_zero)
        val btn_one = view?.findViewById<Button>(R.id.btn_one)
        val btn_two = view?.findViewById<Button>(R.id.btn_two)
        val btn_three = view?.findViewById<Button>(R.id.btn_three)
        val btn_four = view?.findViewById<Button>(R.id.btn_four)
        val btn_five = view?.findViewById<Button>(R.id.btn_five)
        val btn_six = view?.findViewById<Button>(R.id.btn_six)
        val btn_seven = view?.findViewById<Button>(R.id.btn_seven)
        val btn_eight = view?.findViewById<Button>(R.id.btn_eight)
        val btn_nine = view?.findViewById<Button>(R.id.btn_nine)
        val btn_delete_last = view?.findViewById<Button>(R.id.btn_delete_last)

        btn_zero?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("0")
        }

        btn_one?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("1")
        }

        btn_two?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("2")
        }

        btn_three?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("3")
        }

        btn_four?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("4")
        }

        btn_five?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("5")
        }

        btn_six?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("6")
        }

        btn_seven?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("7")
        }

        btn_eight?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("8")
        }

        btn_nine?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("9")
        }

        btn_minus?.setOnClickListener {
            go_sound_click()
            vm.Input_answer("-")
        }

        btn_delete_last?.setOnClickListener {
            go_sound_click()
            vm.delete()
        }

        // Получение инфорации в окне таймера
        val stopWatch = view?.findViewById<TextView>(R.id.stopWatch)
        vm.getTimerData().observe(viewLifecycleOwner, {
            val zero: Long = 0
            val warning: Long = 2000
            if (it<warning) stopWatch?.setTextColor(Color.parseColor("#c54343"))
            else stopWatch?.setTextColor(Color.parseColor("#ffffff"))
            if (it!=zero) stopWatch?.text = "${it/1000}.${it%1000/100}"
            else stopWatch?.text = ""
        })

        // Появление цифр в окошке ввода
        val answer = view?.findViewById<TextView>(R.id.answer)
        vm.getAnswer().observe(viewLifecycleOwner, {
            answer?.text = it.toString()
        })


        // Получение примера
        val expression = view?.findViewById<TextView>(R.id.expression)
        vm.getExpression().observe(viewLifecycleOwner, {
            expression?.text = it.toString()
        })


        // Получние информации об уровне
        val lvl = view?.findViewById<TextView>(R.id.count)
        vm.getLvl().observe(viewLifecycleOwner, {
            val lvlInformation: String = resources.getString(R.string.lvl)
            lvl?.text = "${lvlInformation}: ${it}"
        })

        vm.getTimeOut().observe(viewLifecycleOwner, {
            if (it) go_result()
        })

        vm.getSound().observe(viewLifecycleOwner, {
            if (it.equals("off")) sound = false
            else sound = true
        })

        vm.getSoundClick().observe(viewLifecycleOwner, {
            button_number_sound = it
            loadSound()
        })
    }

    fun go_result() {

        val answerWrongId = getResources().getIdentifier(R.raw.sound_answer_wrong.toString(),
            "raw", activity?.packageName)
        val soundAnswerWrong= MediaPlayer.create(context, answerWrongId)

        Log.e("Starting","Фрагмент закончил свою работу")
        bundle.putString("correct_answer", vm.getCorrectResult().value)
        bundle.putString("expression", vm.getExpression().value)
        vm.Default_Expression()
        vm.DefaultAnswer()
        vm.DefaultLvl()
        vm.DefaultFirstLoad()
        vm.DefaultTimerDown()
        bundle.putInt("lvl", vm.getLvl().value!! - 1)
        if (sound) soundAnswerWrong.start()
        (activity as MainActivity).navController.navigate(R.id.action_starting_to_result, bundle)
    }

    fun loadSound() {
        when(button_number_sound) {
            0 -> {
                soundButton= MediaPlayer.create(context, getResources().getIdentifier(R.raw.sound_button.toString(),
                    "raw", activity?.packageName))
            }
            1 -> {
                soundButton = MediaPlayer.create(context, getResources().getIdentifier(R.raw.sound_button2.toString(),
                    "raw", activity?.packageName))
            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
        }
    }

    fun go_sound_click() {
        if (soundButton?.isPlaying == true) {
            soundButton?.stop()
            loadSound()
        }
        if (sound) soundButton?.start()
    }

}
