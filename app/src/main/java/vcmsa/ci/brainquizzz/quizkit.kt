package vcmsa.ci.brainquizzz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quizkit : AppCompatActivity() {
    //Declare
    private lateinit  var question: TextView
    private lateinit var feedBack: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var btnResult: Button
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizkit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}