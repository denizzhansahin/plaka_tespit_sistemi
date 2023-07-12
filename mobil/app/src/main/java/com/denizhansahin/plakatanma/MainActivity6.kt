package com.denizhansahin.plakatanma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity6 : AppCompatActivity() {

    private val TAG = "MainActivity6"

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        // Firebase Auth ve Firestore başlatma
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // Kullanıcı kimlik doğrulama işlemi
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val firebaseId = currentUser.uid

            firestore.collection("gunluk_islem_tablo")
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
                        val tableRow = TableRow(this@MainActivity6)



                        val textViewIslemAy = TextView(this@MainActivity6)
                        textViewIslemAy.text = islemAy
                        textViewIslemAy.setPadding(4,4,0,4)
                        tableRow.addView(textViewIslemAy)

                        val textViewIslemGun = TextView(this@MainActivity6)
                        textViewIslemGun.text = islemGun
                        textViewIslemGun.setPadding(45,4,10,4)
                        tableRow.addView(textViewIslemGun)

                        val textViewIslemSaat = TextView(this@MainActivity6)
                        textViewIslemSaat.text = islemSaat
                        textViewIslemSaat.setPadding(45,4,10,4)
                        tableRow.addView(textViewIslemSaat)

                        val textViewIslemDakika = TextView(this@MainActivity6)
                        textViewIslemDakika.text = islemDakika
                        textViewIslemDakika.setPadding(45,4,10,4)
                        tableRow.addView(textViewIslemDakika)

                        val textViewIslemGorevi = TextView(this@MainActivity6)
                        textViewIslemGorevi.text = islemGorevi
                        textViewIslemGorevi.setPadding(50,4,10,4)
                        tableRow.addView(textViewIslemGorevi)

                        val textViewPlakaTespiti = TextView(this@MainActivity6)
                        textViewPlakaTespiti.text = plakaTespiti
                        textViewPlakaTespiti.setPadding(4,4,4,4)
                        tableRow.addView(textViewPlakaTespiti)


                        val textViewPlaka = TextView(this@MainActivity6)
                        textViewPlaka.text = plaka
                        textViewPlaka.setPadding(4,4,4,4)
                        tableRow.addView(textViewPlaka)

                        val textViewKullaniciID = TextView(this@MainActivity6)
                        textViewKullaniciID.text = kullaniciId
                        textViewKullaniciID.setPadding(4,4,4,4)
                        tableRow.addView(textViewKullaniciID)

                        val textViewDosyaAdi = TextView(this@MainActivity6)
                        textViewDosyaAdi.text = dosyaAdi
                        textViewDosyaAdi.setPadding(4,4,4,4)
                        tableRow.addView(textViewDosyaAdi)

                        // Sütun genişliklerini ayarla
                        val layoutParamsDosyaAdi = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
                        layoutParamsDosyaAdi.weight = 0f
                        textViewDosyaAdi.layoutParams = layoutParamsDosyaAdi

                        tableLayout.addView(tableRow)
                    }
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Veri sorgulama hatası: $e")
                }
        }
    }
}
