package com.example.myquizapp



import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // TODO (STEP 2: A global variables for current position and questions list.)
    // START
    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var g=false
    private var mCorrectAnswers:Int =0
    private var mUserName :String? =null

    // END

    // TODO (STEP 5: A global variables for selected option.)
    // START
    private var mSelectedOptionPosition: Int = 0
    // END

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_question)
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        // TODO (STEP 3: Make the questions list and the current position variable global and remove the logs here.)
        // START
        mQuestionsList = Constants.getQuestions()
        // END

        setQuestion()

        // TODO (STEP 4: Set all the click events for Options using the interface onClick listener)
        // START
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        // END
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit->{

                if(mSelectedOptionPosition==0 && g==true)
                {

                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size ->
                        {
                            setQuestion()
                            g=false
                    }
                        else->
                        {
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
//        STARTING THE NEW ACTIVITY WE HAVE CREATED
                            startActivity(intent)
                            finish()

                        }
                    }
                }
                else
                {
                    if(g==false) {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)
                        if (question!!.correctAnswer != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else
                            mCorrectAnswers++
                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                        if (mCurrentPosition == mQuestionsList!!.size) {
                            btn_submit.text = "CLICK HERE TO SEE YOUR SCORE"

                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }
                        g=true
                    }
                    else
                    {
                        Toast.makeText(this@QuizQuestionsActivity,"You have already answered this question, go to the next question",Toast.LENGTH_SHORT).show()
                    }

                    mSelectedOptionPosition=0




                }
            }
        }
    }

    // TODO (STEP 1 : Lets create a function to set the question in the UI components which we have done earlier the onCreate method. And make some of the variables global which we will be using later.)
    // START
    /**
     * A function for setting the question to UI components.
     *
     */
    private fun answerView(answer:Int,drawableView:Int)
    {
        when(answer)
        {
            1->
            {
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->
            {
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->
            {
                tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->
            {
                tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
    private fun setQuestion() {

        val question =
            mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()
        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="CLICK HERE TO SEE YOUR SCORE"
        }
        else
        {
            btn_submit.text="SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
    // END

    // TODO (STEP 6: Create a function for view for highlighting the selected option.)
    // START
    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }

    // TODO (STEP 8: Create a function to set default options view.)
    // START
    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }
}
//
//import android.graphics.Color
//import android.graphics.Typeface
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.TextView
//import androidx.core.content.ContextCompat
//import kotlinx.android.synthetic.main.activity_quiz_question.*
//
//class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
//
//    private var mCurrentPosition:Int =1
//    private var mQuestionsList: Array<Question>? = null
//    private var mSelectedOptionPosition:Int = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quiz_question)
//
//      mQuestionsList = Constants.getQuestions()
//        setQuestion()
//        tv_option_one.setOnClickListener(this)
//        tv_option_two.setOnClickListener(this)
//        tv_option_three.setOnClickListener(this)
//        tv_option_four.setOnClickListener(this)
//
//
//
////Created a func instead for the work below by defining global variable above
////        val mCurrentPosition = 1
////        val question : Question? = questionList[currentPosition-1]
////        progress_Bar.progress = currentPosition
////        tv_progress.text ="$currentPosition" + "/"+progress_Bar.getMax()
////        tv_question.text=question!!.question
////        iv_image.setImageResource(question.image)
////        tv_option_one.text=question.optionOne
////        tv_option_two.text=question.optionTwo
////        tv_option_three.text=question.optionThree
////        tv_option_four.text=question.optionFour
//    }
//    private fun setQuestion()
//    {
//
//        val question = mQuestionsList!!.get(mCurrentPosition-1)
//        defaultOptionsView()
//        progressBar.progress = mCurrentPosition
//        tv_progress.text ="$mCurrentPosition" + "/"+progressBar.getMax()
//        tv_question.text=question.question
//        iv_image.setImageResource(question.image)
//        tv_option_one.text=question.optionOne
//        tv_option_two.text=question.optionTwo
//        tv_option_three.text=question.optionThree
//        tv_option_four.text=question.optionFour
//    }
//    private fun defaultOptionsView()
//    {
//        var options = ArrayList<TextView>()
//        options.add(0,tv_option_one)
//        options.add(1,tv_option_two)
//        options.add(2,tv_option_three)
//        options.add(3,tv_option_four)
//        for(option in options)
//        {
//            option.setTextColor(Color.parseColor("#7A8089"))
//            option.typeface= Typeface.DEFAULT
//
//
////            to set every text view with a default format
//
//
//            option.background= ContextCompat.getDrawable(this@QuizQuestionActivity,R.drawable.default_option_border_bg)
//        }
//
//    }
//
//    override fun onClick(v: View?) {
//
//
//        when (v?.id) {
//
//            R.id.tv_option_one -> {
//
//                selectedOptionView(tv_option_one, 1)
//            }
//
//            R.id.tv_option_two -> {
//
//                selectedOptionView(tv_option_two, 2)
//            }
//
//            R.id.tv_option_three -> {
//
//                selectedOptionView(tv_option_three, 3)
//            }
//
//            R.id.tv_option_four -> {
//
//                selectedOptionView(tv_option_four, 4)
//            }
//        }
//    }
//    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
//    {
//        defaultOptionsView()
//        mSelectedOptionPosition=selectedOptionNum
//
//        tv.setTextColor(Color.parseColor("#363A43"))
//        tv.setTypeface(tv.typeface,Typeface.BOLD)
//
//
////            to set every text view with a default format
//
//
//        tv.background= ContextCompat.getDrawable(this@QuizQuestionActivity ,R.drawable.selected_option_border_bg)
//
//
//    }
//}
