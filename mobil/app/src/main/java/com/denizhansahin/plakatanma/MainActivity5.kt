package com.denizhansahin.plakatanma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        val button_plaka_takip = findViewById<Button>(R.id.button_plaka_takip)
        button_plaka_takip.setOnClickListener{
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
            finish()
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
            finish()
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
            finish()
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener{
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
            finish()
        }


        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener{
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
            finish()
        }

        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener{
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
            finish()
        }

    }
}