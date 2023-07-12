package com.denizhansahin.plakatanma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import android.util.Log
import android.widget.Toast
import com.denizhansahin.plakatanma.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()


        binding.buttonGiris.setOnClickListener {
            val email = binding.emailGiris.text.toString()
            val pass = binding.sifreGiris.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    val currentUser = firebaseAuth.currentUser
                    var firebaseId: String? = null
                    if (currentUser != null) {
                        firebaseId = currentUser.uid
                    }


                    if (it.isSuccessful) {

                        // Firestore'dan belgeyi alma
                        firestore.collection("kullaniciBilgileri").document(firebaseId.toString()).get().addOnSuccessListener { documentSnapshot ->
                            val alanDegeri = documentSnapshot.getString("yetkili")

                            // Alan değerine göre farklı işlemler yapma
                            if (alanDegeri == "Evet") {
                                // "Evet" değeri ise başka bir activity aç
                                val intent = Intent(this@MainActivity, MainActivity5::class.java)
                                startActivity(intent)
                            } else if (alanDegeri == "Hayır") {
                                // "Hayır" değeri ise başka bir activity aç
                                val intent = Intent(this@MainActivity, MainActivity3::class.java)
                                startActivity(intent)
                            }
                        }.addOnFailureListener { e ->
                            // Hata durumunda işlemleri ele alma
                            Log.e(TAG, "Veri alma hatası: $e")
                        }
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        var firebaseId: String? = null
        if (currentUser != null) {
            firebaseId = currentUser.uid
        }
        if(firebaseAuth.currentUser != null){
            // Firestore'dan belgeyi alma
            firestore.collection("kullaniciBilgileri").document(firebaseId.toString()).get().addOnSuccessListener { documentSnapshot ->
                val alanDegeri = documentSnapshot.getString("yetkili")

                // Alan değerine göre farklı işlemler yapma
                if (alanDegeri == "Evet") {
                    // "Evet" değeri ise başka bir activity aç
                    val intent = Intent(this@MainActivity, MainActivity5::class.java)
                    startActivity(intent)
                } else if (alanDegeri == "Hayır") {
                    // "Hayır" değeri ise başka bir activity aç
                    val intent = Intent(this@MainActivity, MainActivity3::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener { e ->
                // Hata durumunda işlemleri ele alma
                Log.e(TAG, "Veri alma hatası: $e")
            }
        }
    }

}