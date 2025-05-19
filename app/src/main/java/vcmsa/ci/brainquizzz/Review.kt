package vcmsa.ci.brainquizzz

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}