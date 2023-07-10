package com.example.ecampus.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.fragment.app.FragmentActivity
import com.example.ecampus.R
import com.example.ecampus.constants.Constants
import com.example.ecampus.databinding.ActivityMainBinding
import com.example.ecampus.presentation.scheduleFragments.Institute
import com.yandex.mapkit.MapKitFactory


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        MapKitFactory.setApiKey(Constants.MAPKIT_KEY)

        setSupportActionBar(binding?.topAppBar)

        supportFragmentManager.beginTransaction().replace(R.id.contentFragment,Home()).commit()
        binding?.bottomMainMenu?.selectedItemId = R.id.bottomMenuHome




        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomMenuHome -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Home()).commit()
                //R.id.bottomMenuAccount -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Account()).commit()
                R.id.bottomMenuSchedule -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Institute()).commit()


            }
            return@setOnItemSelectedListener true
        }

        val startPositionX = -1000f
        val endPositionX = 1000f
        val startAlpha = 0f
        val endAlpha = 1f
        // Определите продолжительность и задержку анимации (в миллисекундах)
        val duration = 40000L
        val alphaDuration = 40000L
        val delay = 1
        val alphaDelay = 40000
        // Создайте объекты TranslateAnimation для движения слева направо и обратно
        val anim1 = TranslateAnimation(startPositionX, endPositionX, 0f, 0f)
        val anim2 = AlphaAnimation(startAlpha,endAlpha)
        // Определите продолжительность каждой анимации
        anim1.duration = duration
        anim2.duration = alphaDuration
        // Определите задержку перед запуском второй анимации
        anim1.repeatCount = Animation.INFINITE
        anim2.repeatCount = Animation.INFINITE
        // Создайте AnimationSet для объединения анимаций
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(anim1)
        animationSet.addAnimation(anim2)
        // Определите интерполятор для плавности анимации (например, AccelerateDecelerateInterpolator)
        animationSet.interpolator = AccelerateDecelerateInterpolator()
        // Запустите анимацию
        binding?.mainBackground?.startAnimation(animationSet)



        setContentView(binding?.root)
    }

override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                val mainMenu = MainMenu()
                mainMenu.show(
                    supportFragmentManager,
                    "main_menu"
                )
            }
        }
        return true
    }





}

