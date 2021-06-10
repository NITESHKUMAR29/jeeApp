package com.example.jee

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*
import kotlin.collections.HashMap


class SignUp : AppCompatActivity() {
    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
       // AppCompatDelegate. setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseFirestore = FirebaseFirestore.getInstance()
        mSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnSignup.setOnClickListener {

            signInUser()

        }
    }

    private fun signInUser() {
        progresbar.visibility= View.VISIBLE
        val email: String = editEmail.text.toString()
        val password: String = editPassword.text.toString().trim()
        val confirmPassword: String = confirmPassword.text.toString().trim()
        emailIputLayout.error = null
        passwordInputLayout.error = null
        confirmPassworInputLayout.error = null

        if (email.isBlank()) {
            emailIputLayout.error = "email should not be blank"
            progresbar.visibility=View.GONE
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailIputLayout.error = "invalid email"
            progresbar.visibility=View.GONE
            return
        }


        if (password.length < 6 || password.isBlank()) {
            passwordInputLayout.error = "password must be 6 character"
            progresbar.visibility=View.GONE
            return
        }


        if (confirmPassword != password) {
            confirmPassworInputLayout.error = "password did not match"
            progresbar.visibility=View.GONE
            return
        }

        firebaseFirestore.collection("users").whereEqualTo("userEmail", email).get().addOnSuccessListener(OnSuccessListener {it->
            var exist: Boolean = false
            val query: QuerySnapshot = it
            for (c: QueryDocumentSnapshot in query) {
                exist = true
            }
            if (!exist) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) {
                            if (it.isSuccessful) {
                                progresbar.visibility=View.GONE
                                Toast.makeText(this, "sucessfully sign up", Toast.LENGTH_LONG).show()
                                userId = firebaseAuth.currentUser.uid
                                val documentReference: DocumentReference = firebaseFirestore.collection("users").document(userId)
                                val user = HashMap<String, Any>()
                                user["useId"] = userId
                                user["userEmail"] = email
                                user["userPassword"] = password
                                documentReference.set(user).addOnSuccessListener(OnSuccessListener {
                                    val intent = Intent(this, Content::class.java)

                                    startActivity(intent)
                                    finish()
                                })

                            } else {
                                Toast.makeText(this, "something went wrong", Toast.LENGTH_LONG).show()
                                progresbar.visibility=View.GONE
                            }
                        }

            } else {
                Toast.makeText(this, "email already used", Toast.LENGTH_LONG).show()
                progresbar.visibility=View.GONE
            }


        })
    }


}
