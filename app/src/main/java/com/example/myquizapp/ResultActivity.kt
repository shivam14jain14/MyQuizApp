package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private var mScore :Int? =null
    private var mTotalQuestions :Int? =null
    private var mmUserName :String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        mScore=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        mTotalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        mmUserName=intent.getStringExtra(Constants.USER_NAME)
        username.text=mmUserName
        tv_score.text="$mScore / $mTotalQuestions"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }




    }
}
