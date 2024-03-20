package com.example.activitiesapp


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val REQUEST_AN_ANSWER = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<View>(R.id.btn_about).setOnClickListener(::onAboutButtonClicked)
        findViewById<View>(R.id.btn_question).setOnClickListener(::onQuestionButtonClicked)
        findViewById<View>(R.id.btn_web).setOnClickListener(::onWebButtonClicked)
    }

    private fun onWebButtonClicked(view: View) {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.bpbonline.com")
        )
        try {
            startActivity(webIntent)
        } catch (ex: ActivityNotFoundException) {
            Log.d("MainActivity", "No browser is installed.", ex)
        }
    }

    private fun onQuestionButtonClicked(view: View) {
        val questionIntent = Intent(
            this,
            QuestionActivity::class.java
        )
        startActivityForResult(questionIntent, REQUEST_AN_ANSWER)
    }

    private fun onAboutButtonClicked(view: View) {
        val aboutIntent = Intent(
            this,
            AboutActivity::class.java
        )
        startActivity(aboutIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_AN_ANSWER) {
            if (data != null) {
                setMessage(
                    if (resultCode == RESULT_OK) getString(
                        R.string.answer_is,
                        data.getStringExtra("answer")
                    ) else getString(R.string.hello_world)
                )
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setMessage(text: String) {
        (findViewById<View>(R.id.txt_mainMessage) as TextView).text =
            text
    }
}