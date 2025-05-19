package vcmsa.ci.brainquizzz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Score : AppCompatActivity() {
    //declare
    private lateinit var score: TextView
    private lateinit var btnReview: Button
    private lateinit var btnExit: Button
    private lateinit var feedBackReview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        // Initialize
        score = findViewById(R.id.score)
        btnReview = findViewById(R.id.btnReview)
        btnExit = findViewById(R.id.btnExit)
        feedBackReview = findViewById(R.id.feedBackReview)

        // Retrieve and display score
        val receivedScore = intent.getIntExtra("score", 0)
        score.text = "Your score: $receivedScore/5"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}