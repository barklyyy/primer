package com.example.primer


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var expressionTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var checkButton: Button
    private lateinit var resultTextView: TextView
    private var correctAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        correctCountTextView = findViewById(R.id.correctCountTextView)
        incorrectCountTextView = findViewById(R.id.incorrectCountTextView)
        expressionTextView = findViewById(R.id.expressionTextView)
        answerEditText = findViewById(R.id.alo)
        checkButton = findViewById(R.id.checkButton)
        resultTextView = findViewById(R.id.resultTextView)

        generateExpression()

        checkButton.setOnClickListener {
            val userAnswer = answerEditText.text.toString().toIntOrNull()

            if (userAnswer == null) {
                resultTextView.text = "Введите ответ!"
            } else {
                if (userAnswer == correctAnswer) {
                    resultTextView.text = "Правильно!"
                    correctCount++
                    correctCountTextView.text = "Правильно: $correctCount"
                } else {
                    resultTextView.text = "Неправильно!"
                    incorrectCount++
                    incorrectCountTextView.text = "Неправильно: $incorrectCount"
                }
                generateExpression()
                answerEditText.text.clear()
            }
        }
    }

    private fun generateExpression() {
        val operand1 = Random.nextInt(10, 100)
        val operand2 = Random.nextInt(10, 100)
        val operator = when (Random.nextInt(4)) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            else -> "/"
        }
        

        val expression = "$operand1 $operator $operand2"
        correctAnswer = when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            else -> operand1 / operand2
        }

        expressionTextView.text = expression
    }

    private lateinit var correctCountTextView: TextView
    private lateinit var incorrectCountTextView: TextView

    private var correctCount = 0
    private var incorrectCount = 0



}