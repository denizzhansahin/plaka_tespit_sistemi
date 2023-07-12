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


class MainActivity12 : AppCompatActivity() {

    private val TAG = "MainActivity12"

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

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

                // Kullanıcı kimlik doğrulama işlemi
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val firebaseId = currentUser.uid

                    // Firestore'dan kullanıcı bilgilerini alma
                    firestore.collection("kullaniciBilgileri")
                        .document(firebaseId)
                        .get()
                        .addOnSuccessListener { documentSnapshot ->
                            val kullaniciId = documentSnapshot.getString("kullanici_ID")

                            // Firestore'dan yetkili_kullanici_islem_tablo verilerini sorgulama
                            firestore.collection("yetkili_kullanici_islem_tablo")
                                .whereEqualTo("kullanici_ID", kullaniciId)
                                .whereEqualTo("islem_ay", ay_ozel1)
                                .whereEqualTo("islem_gun", gun_ozel1)

                                .get()
                                .addOnSuccessListener { querySnapshot ->
                                    for (document in querySnapshot) {
                                        val dosyaAdi = document.getString("dosya_adi")
                                        val islemAy = document.getString("islem_ay")
                                        val islemDakika = document.getString("islem_dakika")
                                        val islemGorevi = document.getString("islem_gorevi")
                                        val islemGun = document.getString("islem_gun")
                                        val islemSaat = document.getString("islem_saat")
                                        val kullaniciId = document.getString("kullanici_ID")
                                        val plaka = document.getString("plaka")

                                        // Verileri ekrana yazdırma
                                        Log.d(TAG, "Dosya Adı: $dosyaAdi")
                                        Log.d(TAG, "İşlem Ayı: $islemAy")
                                        Log.d(TAG, "İşlem Dakikası: $islemDakika")
                                        Log.d(TAG, "İşlem Görevi: $islemGorevi")
                                        Log.d(TAG, "İşlem Günü: $islemGun")
                                        Log.d(TAG, "İşlem Saati: $islemSaat")
                                        Log.d(TAG, "Kullanıcı ID: $kullaniciId")
                                        Log.d(TAG, "Plaka: $plaka")

                                        // Tabloya verileri ekleme
                                        val tableLayout = findViewById<TableLayout>(R.id.tableLayout1)
                                        val tableRow = TableRow(this@MainActivity12)



                                        val textViewIslemAy = TextView(this@MainActivity12)
                                        textViewIslemAy.text = islemAy
                                        textViewIslemAy.setPadding(4,4,0,4)
                                        tableRow.addView(textViewIslemAy)

                                        val textViewIslemGun = TextView(this@MainActivity12)
                                        textViewIslemGun.text = islemGun
                                        textViewIslemGun.setPadding(45,4,10,4)
                                        tableRow.addView(textViewIslemGun)

                                        val textViewIslemSaat = TextView(this@MainActivity12)
                                        textViewIslemSaat.text = islemSaat
                                        textViewIslemSaat.setPadding(45,4,10,4)
                                        tableRow.addView(textViewIslemSaat)

                                        val textViewIslemDakika = TextView(this@MainActivity12)
                                        textViewIslemDakika.text = islemDakika
                                        textViewIslemDakika.setPadding(45,4,10,4)
                                        tableRow.addView(textViewIslemDakika)

                                        val textViewIslemGorevi = TextView(this@MainActivity12)
                                        textViewIslemGorevi.text = islemGorevi
                                        textViewIslemGorevi.setPadding(50,4,10,4)
                                        tableRow.addView(textViewIslemGorevi)


                                        val textViewPlaka = TextView(this@MainActivity12)
                                        textViewPlaka.text = plaka
                                        textViewPlaka.setPadding(4,4,4,4)
                                        tableRow.addView(textViewPlaka)

                                        val textViewDosyaAdi = TextView(this@MainActivity12)
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
                        .addOnFailureListener { e ->
                            Log.e(TAG, "Kullanıcı bilgilerini alma hatası: $e")
                        }
                }
            }
        }
    }

    private fun createTextView(text: String?): TextView {
        val textView = TextView(this@MainActivity12)
        textView.text = text ?: ""
        textView.setPadding(4, 4, 4, 4)
        return textView
    }
}
