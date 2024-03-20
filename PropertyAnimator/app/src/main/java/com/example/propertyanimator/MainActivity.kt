package com.example.propertyanimator

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val word_test:TextView = findViewById(R.id.word)

        //word_test.animate().scaleX(2f)   // 30dp  -> 60dp
        //                   .scaleY(2f)   // same large scale

        val animator:AnimatorSet = AnimatorInflater.
                              loadAnimator(this,R.animator.pro_animator) as AnimatorSet
        animator.setTarget(word_test)
        animator.start()







    }
}