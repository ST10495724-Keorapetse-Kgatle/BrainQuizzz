package vcmsa.ci.brainquizzz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quizkit : AppCompatActivity() {
    //Declare
    private lateinit var question: TextView
    private lateinit var feedBack: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var btnResult: Button
    private lateinit var btnExit: Button

    companion object {
        val questions = arrayOf(
            "Bananas are berries, but strawberries are not berries", // True
            "The human brain stops growing once you reach adulthood", // False
            "You can't hum while holding your nose", // True
            "The color pink does not actually exist in the visible spectrum", // True
            "The sun is yellow", // False
            "HTML is a programming language", // False
            "An octopus has 3 hearts" // True
        )
        val feedbackArray = booleanArrayOf(true, false, true, true, false, false, true)
    }

    private var currentIndex = 0
    private var score = 0 // Track correct answers


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizkit)


        //initialize
        question = findViewById<TextView>(R.id.question)
        feedBack = findViewById<TextView>(R.id.feedBack)
        btnTrue = findViewById<Button>(R.id.btnTrue)
        btnFalse = findViewById<Button>(R.id.btnFalse)
        btnNext = findViewById<Button>(R.id.btnNext)
        btnResult = findViewById<Button>(R.id.btnResult)
        btnExit = findViewById<Button>(R.id.btnExit)

        question.text = questions[currentIndex]
        var scoreCounter = 0

        ///set on  click listeners for my buttons
        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            if (currentIndex < vcmsa.ci.brainquizzz.quizkit.Companion.questions.size - 1) {
                currentIndex++
                question.text = vcmsa.ci.brainquizzz.quizkit.Companion.questions[currentIndex]
                feedBack.text = ""
            } else {
                feedBack.text = "End of Quiz! Click 'Results' to see your score."
                btnNext.isEnabled = false // Disable Next button after last question
                btnTrue.isEnabled = false
                btnFalse.isEnabled = false
            }
        }

        btnResult.setOnClickListener {
            val intent = Intent(this, Score::class.java)
            // it will send score to Result activity
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == vcmsa.ci.brainquizzz.quizkit.Companion.feedbackArray[currentIndex]) {
            //when the answer is correct it will display
            feedBack.text = "Correct"
        // Increase score on correct answer
            score++
        } else {
            //when the answer is wrong it will display
            feedBack.text = "Incorrect"

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}