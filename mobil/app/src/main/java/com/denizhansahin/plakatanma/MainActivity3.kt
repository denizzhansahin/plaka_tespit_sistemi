package com.denizhansahin.plakatanma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main31)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        val button2 = findViewById<Button>(R.id.button_plaka_takip)
        button2.setOnClickListener{
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val button3 = findViewById<Button>(R.id.button_kisi)
        button3.setOnClickListener{
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
            finish()
        }

    }
}