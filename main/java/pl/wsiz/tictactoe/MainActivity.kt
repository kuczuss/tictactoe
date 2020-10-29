package pl.wsiz.tictactoe


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/**
 *  Głowne activity
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edittext1 = findViewById<EditText>(R.id.edit_text1).text.toString()
        /**
         * Przycisk do grania z komputerem
         */
        val button = findViewById<Button>(R.id.button_play)
        button.setOnClickListener{
           if(ValidName.validN(edittext1)) {
               val intent = Intent(this,tictac::class.java)
               startActivity(intent)
           }
            else{
               val emptyName =
                   Toast.makeText(this@MainActivity, "Nick have to has min 2 characters", Toast.LENGTH_SHORT)
               emptyName.show()
           }

        }
        /**
         * Przycisk do grania multiplayers
         */
        val button1 = findViewById<Button>(R.id.button_play2)
        button1.setOnClickListener{
            if(ValidName.validN(edittext1)){
            val intentt = Intent(this,MultiPlayers::class.java)
            startActivity(intentt)}
            else{
                val emptyName =
                    Toast.makeText(this@MainActivity, "Nick have to has min 2 characters", Toast.LENGTH_SHORT)
                emptyName.show()
            }
        }
}
}

