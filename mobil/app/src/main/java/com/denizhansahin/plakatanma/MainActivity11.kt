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


class MainActivity11 : AppCompatActivity() {

    private val TAG = "MainActivity11"

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        // Firebase Auth ve Firestore başlatma
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // Kullanıcı kimlik doğrulama işlemi
        val currentUser = auth.currentUser

        val plaka_button = findViewById<Button>(R.id.plaka_ozel_button)

        val plaka_ozel = findViewById<EditText>(R.id.plaka_ozel)


        plaka_button.setOnClickListener {
            val plaka_ozel1 = plaka_ozel.text.toString()


            if (currentUser != null && plaka_ozel1.isNotEmpty()) {


                firestore.collection("gunluk_islem_tablo")
                    .whereEqualTo("plaka", plaka_ozel1)

                    .get()
                    .addOnSuccessListener { querySnapshot ->



                        for (document in querySnapshot) {
                            val islemAy = document.getString("islem_ay")
                            val islemDakika = document.getString("islem_dakika")
                            val islemGorevi = document.getString("islem_gorevi")
                            val islemGun = document.getString("islem_gun")
                            val islemSaat = document.getString("islem_saat")
                            val plakaTespiti = document.getString("plaka_tespit_edilme")

                            val kullaniciId = document.getString("kullanici_ID")
                            val dosyaAdi = document.getString("dosya_adi")

                            // Tabloya verileri ekleme
                            val tableLayout = findViewById<TableLayout>(R.id.tableLayout1)
                            val tableRow = TableRow(this@MainActivity11)

                            val textViewIslemAy = TextView(this@MainActivity11)
                            textViewIslemAy.text = islemAy
                            textViewIslemAy.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemAy)

                            val textViewIslemGun = TextView(this@MainActivity11)
                            textViewIslemGun.text = islemGun
                            textViewIslemGun.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemGun)

                            val textViewIslemSaat = TextView(this@MainActivity11)
                            textViewIslemSaat.text = islemSaat
                            textViewIslemSaat.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemSaat)

                            val textViewIslemDakika = TextView(this@MainActivity11)
                            textViewIslemDakika.text = islemDakika
                            textViewIslemDakika.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemDakika)

                            val textViewIslemGorev = TextView(this@MainActivity11)
                            textViewIslemGorev.text = islemGorevi
                            textViewIslemGorev.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemGorev)

                            val textViewIslemTespit = TextView(this@MainActivity11)
                            textViewIslemTespit.text = plakaTespiti
                            textViewIslemTespit.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemTespit)

                            val textViewIslemKullaniciID = TextView(this@MainActivity11)
                            textViewIslemKullaniciID.text = kullaniciId
                            textViewIslemKullaniciID.setPadding(4,4,0,4)
                            tableRow.addView(textViewIslemKullaniciID)

                            val textViewIslemDosyaAdi = TextView(this@MainActivity11)
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
    
}