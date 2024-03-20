package com.example.activitiesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        findViewById<Button>(R.id.btn_no).setOnClickListener(this::onYesButtonClicked);
        findViewById<Button>(R.id.btn_no).setOnClickListener(this::onNoButtonClicked);
    }

    fun onYesButtonClicked(view: View) {
        returnAnswer("yes");
    }

    private fun returnAnswer(answer: String) {
        val result = Intent()
        result.putExtra("answer", answer)
        setResult(RESULT_OK, result)
        finish()
    }

    fun onNoButtonClicked(view: View) {
        returnAnswer("no");
    }



}