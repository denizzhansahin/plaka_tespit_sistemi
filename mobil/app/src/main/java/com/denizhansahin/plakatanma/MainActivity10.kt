package com.denizhansahin.plakatanma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore



class MainActivity10 : AppCompatActivity() {

    private val TAG = "MainActivity10"

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        // Firebase Auth ve Firestore başlatma
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // Kullanıcı kimlik doğrulama işlemi
        val currentUser = auth.currentUser

        val gun_ay_button = findViewById<Button>(R.id.gun_ay_button)

        val gun_ozel = findViewById<EditText>(R.id.gun_ozel)
        val ay_ozel = findViewById<EditText>(R.id.ay_ozel)

        gun_ay_button.setOnClickListener {
            val gun_ozel1 = gun_ozel.text.toString()
            val ay_ozel1 = ay_ozel.text.toString()

            if (currentUser != null && gun_ozel1.isNotEmpty() && ay_ozel1.isNotEmpty()) {
                val firebaseId = currentUser.uid

                firestore.collection("gunluk_islem_tablo")
                    .whereEqualTo("islem_ay", ay_ozel1)
                    .whereEqualTo("islem_gun", gun_ozel1)
                    .get()
                    .addOnSuccessListener { querySnapshot ->


                        for (document in querySnapshot) {
                            val islemAy = document.getString("islem_ay")
                            val islemDakika = document.getString("islem_dakika")
                            val islemGorevi = document.getString("islem_gorevi")
                            val islemGun = document.getString("islem_gun")
                            val islemSaat = document.getString("islem_saat")
                            val plakaTespiti = document.getString("plaka_tespit_edilme")
                            val plaka = document.getString("plaka")
                            val kullaniciId = document.getString("kullanici_ID")
                            val dosyaAdi = document.getString("dosya_adi")

                            // Tabloya verileri ekleme
                            val tableLayout = findViewById<TableLayout>(R.id.tableLayout1)
                            val tableRow = TableRow(this@MainActivity10)

                            val textViewIslemAy = TextView(this@MainActivity10)
                            textViewIslemAy.text = islemAy
                            textViewIslemAy.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemAy)

                            val textViewIslemGun = TextView(this@MainActivity10)
                            textViewIslemGun.text = islemGun
                            textViewIslemGun.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemGun)

                            val textViewIslemSaat = TextView(this@MainActivity10)
                            textViewIslemSaat.text = islemSaat
                            textViewIslemSaat.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemSaat)

                            val textViewIslemDakika = TextView(this@MainActivity10)
                            textViewIslemDakika.text = islemDakika
                            textViewIslemDakika.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemDakika)

                            val textViewIslemGorev = TextView(this@MainActivity10)
                            textViewIslemGorev.text = islemGorevi
                            textViewIslemGorev.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemGorev)

                            val textViewIslemTespit = TextView(this@MainActivity10)
                            textViewIslemTespit.text = plakaTespiti
                            textViewIslemTespit.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemTespit)

                            val textViewIslemKullaniciID = TextView(this@MainActivity10)
                            textViewIslemKullaniciID.text = kullaniciId
                            textViewIslemKullaniciID.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemKullaniciID)

                            val textViewIslemPlaka= TextView(this@MainActivity10)
                            textViewIslemPlaka.text = plaka
                            textViewIslemPlaka.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemPlaka)

                            val textViewIslemDosyaAdi = TextView(this@MainActivity10)
                            textViewIslemDosyaAdi.text = dosyaAdi
                            textViewIslemDosyaAdi.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemDosyaAdi)



                            // Sütun genişliklerini ayarla
                            val layoutParamsDosyaAdi = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
                            layoutParamsDosyaAdi.weight = 0f
                            textViewIslemDosyaAdi.layoutParams = layoutParamsDosyaAdi

                            tableLayout.addView(tableRow)
                        }
                    }
                    .addOnFailureListener { e ->
                        Log.e(TAG, "Veri sorgulama hatası: $e")
                    }
            }
        }
    }

    private fun createTextView(text: String?): TextView {
        val textView = TextView(this@MainActivity10)
        textView.text = text ?: ""
        textView.setPadding(4, 4, 4, 4)
        return textView
    }
}
