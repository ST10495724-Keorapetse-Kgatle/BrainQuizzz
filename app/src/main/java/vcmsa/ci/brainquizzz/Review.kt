package vcmsa.ci.brainquizzz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    //declare
    private lateinit  var ReviewText: TextView
    private lateinit var btnReset : Button
    private lateinit var btnExit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        //initialize
        ReviewText = findViewById<TextView>(R.id.ReviewText)
        btnReset = findViewById<Button>(R.id.btnReset)
        btnExit = findViewById<Button>(R.id.btnExit)

        // Retrieve data passed from Quizkit
        val questions = intent.getStringArrayListExtra("quiz_questions") ?: arrayListOf()
        val answers = intent.getStringArrayListExtra("quiz_answers") ?: arrayListOf()

        // Display the Questions & Answers
        val displayText = StringBuilder()
        for (i in questions.indices) {
            displayText.append("Q${i + 1}: ${questions[i]}\n")
            displayText.append("Answer: ${answers[i]}\n\n")
        }
        // Set text to Answers TextView
        ReviewText.text = displayText.toString()


        //setonClickListener
        btnExit.setOnClickListener {
            finish()
        }

        btnReset.setOnClickListener {
            var intent = Intent (this, MainActivity::class.java)
            startActivity( intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}