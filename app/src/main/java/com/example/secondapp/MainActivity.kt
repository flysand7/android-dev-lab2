package com.example.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import Question



class MainActivity : AppCompatActivity() {
    private lateinit var true_button: Button
    private lateinit var false_button: Button
    private lateinit var question_view: TextView
    private lateinit var prev_button: ImageButton
    private lateinit var next_button: ImageButton
    private val questionArr = arrayOf(
        Question("富士山 is the tallest mountain in japan", true),
        Question("Cats only live in egypt", false),
        Question("Colloseum is located in Rome, Italy", true)
    )
    private lateinit var curQuestion: Question
    private var curQuestionIndex = 0
    fun prevQuestion() {
        curQuestionIndex -= 1
        curQuestionIndex += questionArr.count()
        curQuestionIndex %= questionArr.count()
        curQuestion = questionArr[curQuestionIndex]
        question_view.setText(curQuestion.question)
    }
    fun nextQuestion() {
        curQuestionIndex += 1
        curQuestionIndex %= questionArr.count()
        curQuestion = questionArr[curQuestionIndex]
        question_view.setText(curQuestion.question)
    }
    fun trueAnswer() {
        val toast_value = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT)
        toast_value.setGravity(Gravity.TOP, 0, 0)
        toast_value.show()
    }
    fun falseAnswer() {
        val toast_value = Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
        toast_value.setGravity(Gravity.TOP, 0, 0)
        toast_value.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        true_button = findViewById(R.id.true_button)
        false_button = findViewById(R.id.false_button)
        question_view = findViewById(R.id.textView)
        curQuestion = questionArr[0]
        true_button.setOnClickListener {
            if(curQuestion.istrue) {
                trueAnswer()
            }
            else {
                falseAnswer()
            }
            nextQuestion()
        }
        false_button.setOnClickListener {
            if(curQuestion.istrue) {
                falseAnswer()
            }
            else {
                trueAnswer()
            }
            nextQuestion()
        }
        prev_button = findViewById(R.id.prev_button)
        next_button = findViewById(R.id.next_button)
        next_button.setOnClickListener {
            nextQuestion()
        }
        prev_button.setOnClickListener {
            prevQuestion()
        }
        question_view.setOnClickListener {
            nextQuestion()
        }
    }
}