package com.denizhansahin.plakatanma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity7 : AppCompatActivity() {

    private val TAG = "MainActivity7"

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        // Firebase Auth ve Firestore başlatma
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

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
                    firestore.collection("yetkisiz_islem_tablo")
                        .get()
                        .addOnSuccessListener { querySnapshot ->
                            for (document in querySnapshot) {

                                val islemAy = document.getString("islem_ay")
                                val islemDakika = document.getString("islem_dakika")
                                val islemGorevi = document.getString("islem_gorevi")
                                val islemGun = document.getString("islem_gun")
                                val islemSaat = document.getString("islem_saat")

                                val plaka_tespit_edilme = document.getString("plaka_tespit_edilme")

                                val plaka = document.getString("plaka")
                                val dosyaAdi = document.getString("dosya_adi")



                                // Tabloya verileri ekleme
                                val tableLayout = findViewById<TableLayout>(R.id.tableLayout1)
                                val tableRow = TableRow(this@MainActivity7)



                                val textViewIslemAy = TextView(this@MainActivity7)
                                textViewIslemAy.text = islemAy
                                textViewIslemAy.setPadding(4,4,0,4)
                                tableRow.addView(textViewIslemAy)

                                val textViewIslemGun = TextView(this@MainActivity7)
                                textViewIslemGun.text = islemGun
                                textViewIslemGun.setPadding(45,4,10,4)
                                tableRow.addView(textViewIslemGun)

                                val textViewIslemSaat = TextView(this@MainActivity7)
                                textViewIslemSaat.text = islemSaat
                                textViewIslemSaat.setPadding(45,4,10,4)
                                tableRow.addView(textViewIslemSaat)

                                val textViewIslemDakika = TextView(this@MainActivity7)
                                textViewIslemDakika.text = islemDakika
                                textViewIslemDakika.setPadding(45,4,10,4)
                                tableRow.addView(textViewIslemDakika)

                                val textViewIslemGorevi = TextView(this@MainActivity7)
                                textViewIslemGorevi.text = islemGorevi
                                textViewIslemGorevi.setPadding(50,4,10,4)
                                tableRow.addView(textViewIslemGorevi)


                                val textViewPlaka = TextView(this@MainActivity7)
                                textViewPlaka.text = plaka
                                textViewPlaka.setPadding(4,4,4,4)
                                tableRow.addView(textViewPlaka)

                                val plaka_tespit_edilme_d = TextView(this@MainActivity7)
                                plaka_tespit_edilme_d.text = plaka_tespit_edilme
                                plaka_tespit_edilme_d.setPadding(4,4,4,4)
                                tableRow.addView(plaka_tespit_edilme_d)

                                val textViewDosyaAdi = TextView(this@MainActivity7)
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
