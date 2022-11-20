package com.example.practical8

import android.R.attr.animation
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.animate
import androidx.core.view.WindowCompat
import com.example.practical8.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity(), AnimationListener {
    private lateinit var binding: ActivityWelcomeBinding
    lateinit var logoImage : ImageView
    lateinit var logoframebyframeanimation : AnimationDrawable
    lateinit var twinanimation : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logoImage = binding.logoImg
        logoImage.setBackgroundResource(R.drawable.uvpce_animation)
        logoframebyframeanimation = logoImage.background as AnimationDrawable
        twinanimation = AnimationUtils.loadAnimation(this,R.anim.grow)
        twinanimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus) {
            logoframebyframeanimation.start()
            logoImage.startAnimation(twinanimation)
        }
        else {
            logoframebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also {
            overridePendingTransition(R.anim.scale_center,R.anim.scale_center_out)
            startActivity(it)
            finish()
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}