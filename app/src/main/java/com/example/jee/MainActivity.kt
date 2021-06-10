package com.example.jee

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var fireBaseAuth: FirebaseAuth
    lateinit var store:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val auth: FirebaseAuth = FirebaseAuth.getInstance()



        if (auth.currentUser != null) {
            val intent = Intent(this, Content::class.java)
            startActivity(intent)
            finish()
        }
        mSignIn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }
        fireBaseAuth = FirebaseAuth.getInstance()

        btnSignup.setOnClickListener {
            login()
        }
    }

    private fun login() {
        signProgres.visibility= View.VISIBLE
        store= FirebaseFirestore.getInstance()
        val email: String = mEmail.text.toString()
        val password: String = mPassword.text.toString().trim()
        emailIputLayout.error = null
        passwordInputLayout.error = null
        if (email.isBlank()) {
            emailIputLayout.error = "email should not be blank"
            signProgres.visibility= View.GONE
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailIputLayout.error = "invalid email"
            signProgres.visibility= View.GONE
            return
        }


        if (password.length < 6 || password.isBlank()) {
            passwordInputLayout.error = "password must be 6 character"
            signProgres.visibility= View.GONE
            return
        }
        store.collection("users").whereEqualTo("userEmail",email).get().addOnSuccessListener { it ->
            var exist = false
            val querySnapshot:QuerySnapshot=it
            for (queryDocumentSnapshot:QueryDocumentSnapshot in querySnapshot) {
                exist = true
            }
            if (!exist){
                Toast.makeText(this, "email or password is wrong", Toast.LENGTH_LONG).show()
                signProgres.visibility= View.GONE
            }
            else{
                fireBaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { it2 ->
                            if (it2.isSuccessful) {
                                signProgres.visibility= View.VISIBLE
                                Toast.makeText(this, "sign in Successfully", Toast.LENGTH_LONG).show()

                                val intent = Intent(this, Content::class.java)


                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                startActivity(intent)
                            } else {
                                signProgres.visibility= View.GONE
                                Toast.makeText(this, "Something went wrong or check your password", Toast.LENGTH_LONG).show()
                            }
                        }
            }
        }
    }

}