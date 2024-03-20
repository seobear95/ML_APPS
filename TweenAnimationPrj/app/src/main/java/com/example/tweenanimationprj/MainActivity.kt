package com.example.tweenanimationprj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var img :ImageView = findViewById<ImageView>(R.id.star)


        //var anim1: Animation =AnimationUtils.loadAnimation(this, R.anim.move)
        //var anim2: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        //var anim3: Animation = AnimationUtils.loadAnimation(this, R.anim.alpha)

        var anim4: Animation =AnimationUtils.loadAnimation(this, R.anim.jump)
        //img.startAnimation(anim3)
        //img.startAnimation(anim2)
       // img.startAnimation(anim1)
        img.startAnimation(anim4)

    }
}