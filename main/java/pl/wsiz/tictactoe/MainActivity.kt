package pl.wsiz.tictactoe


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_play)
        button.setOnClickListener{
            val intent = Intent(this,tictac::class.java)
            startActivity(intent)
        }
        val button1 = findViewById<Button>(R.id.button_play2)
        button1.setOnClickListener{
            val intentt = Intent(this,MultiPlayers::class.java)
            startActivity(intentt)
        }
}
}

