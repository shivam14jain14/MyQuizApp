package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

btn_start.setOnClickListener {
    if(et_name.text.toString().isEmpty())
    {
        Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
    }
    else
    {
//        THIS IS FOR MOVING TO ANOTHER ACTIVITY ON CLICKING
        val intent = Intent(this,QuizQuestionsActivity::class.java)
        intent.putExtra(Constants.USER_NAME,et_name.text.toString())
//        STARTING THE NEW ACTIVITY WE HAVE CREATED
        startActivity(intent)
         finish()
    }

}
    }
}
