package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.CharSequence as CharSequence1

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text == "Merhaba Dünya!") {
            resultText.text = "1"
        }
        else {
            var resultInt = resultText.text.toString().toInt()

            if(resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = "0"

        Toast.makeText(this, "Zar Sıfırlandı!",
            Toast.LENGTH_SHORT).show()
    }
}
