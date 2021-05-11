package com.example.myquizapp

object Constants
{
    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS :String = "total_question"
    const val CORRECT_ANSWERS:String = "correct_answers"
     fun getQuestions():ArrayList<Question>
    {
//        R.drawable is used for adding the image
           var questionList = ArrayList<Question>()
        val que1 = Question(1,"Which country does this flag belong to ?",R.drawable.newzealand,"Italy","Australia","Egypt","New Zealand",4)

        questionList.add(que1)

        val que2 = Question(2,"Which country does this flag belong to ?",R.drawable.japan,"France","Germany","Japan","UAE",3)
        questionList.add(que2)
        val que3 = Question(3,"Which country does this flag belong to ?",R.drawable.switzerland,"China","Switzerland","Singapore","Spain",2)

        questionList.add(que3)

        val que4 = Question(4,"Which country does this flag belong to ?",R.drawable.norway,"Norway","Germany","South Korea","Spain",1)
        questionList.add(que4)
        val que5=Question(5,"Which country does this flag belong to ?",R.drawable.australia,"New Zealand","UK","Italy","Australia",4)
        questionList.add(que5)

        val que6 = Question(6,"Which country does this flag belong to ?",R.drawable.neitherland,"Iceland","Germany","Neitherland","Mexico",3)

        questionList.add(que6)

        val que7 = Question(7,"Which country does this flag belong to ?",R.drawable.mexico,"UAE","Germany","Italy","Mexico",4)
        questionList.add(que7)
        val que8 = Question(8,"Which country does this flag belong to ?",R.drawable.albania,"Albania","Nigeria","Singapore","Sweden",1)

        questionList.add(que8)

        val que9 = Question(9,"Which country does this flag belong to ?",R.drawable.italy,"Norway","Germany","Mexico","Italy",4)
        questionList.add(que9)
        val que10=Question(10,"Which country does this flag belong to ?",R.drawable.australia,"New Zealand","UK","Italy","Australia",4)
        questionList.add(que10)
        val que11=Question(11,"Guess the name of this famous personality  -> Also known as the Indian Bismarck ?",R.drawable.sardar,"Rajaji","Nehru"," Valabhai Patel","Kamraj",3)
        questionList.add(que11)
        val que12=Question(12,"Guess the name of this famous personality   ?",R.drawable.nehru,"Rajendra Prasad","Jawahar Lal Nehru","Subhash Chandra Bose","Kamraj",2)
        questionList.add(que12)
        val que13=Question(13,"Guess the name of this famous personality   ?",R.drawable.rajendra,"Motilal Nehru","Lal Bahadur Shastri","Chandra Shekhar Azad","Rajendra Prasad",4)
        questionList.add(que13)
        val que14=Question(14,"Guess the name of this famous personality   ?",R.drawable.sarojini,"Indra Gandhi","Sarojini Naidu","Pandita ramabai","Rani Lakshmi Bai",2)
        questionList.add(que14)
        val que15=Question(15,"Guess the name of this famous personality   ?",R.drawable.shashtri,"Lal Bahadur Shashtri","Subhash Chandra Bose","Motilal Nehru","Rajendra Prasad",1)
        questionList.add(que15)




        return questionList
    }
}