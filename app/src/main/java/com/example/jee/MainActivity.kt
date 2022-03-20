package com.example.jee

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.jee.databinding.ActivityMainBinding
import com.example.jee.databinding.FragmentBlankBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var fireBaseAuth: FirebaseAuth
    lateinit var store:FirebaseFirestore
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        with(binding){
            forgotPassword.setOnClickListener{
                val intent =Intent(this@MainActivity,ForgotPassword::class.java)
                startActivity(intent)
            }
            if (auth.currentUser != null) {
                val intent = Intent(this@MainActivity, Content::class.java)
                startActivity(intent)
                finish()
            }
            mSignIn.setOnClickListener {
                val intent = Intent(this@MainActivity, SignUp::class.java)
                startActivity(intent)
                finish()
            }
            fireBaseAuth = FirebaseAuth.getInstance()

            btnSignup.setOnClickListener {
                login()
            }
        }






    }

    private fun login() {
       binding.signProgres.visibility= View.VISIBLE
        store= FirebaseFirestore.getInstance()
        val email: String = mEmail.text.toString()
        val password: String = mPassword.text.toString().trim()
        binding.emailIputLayout.error = null
        passwordInputLayout.error = null
        if (email.isBlank()) {
            binding.emailIputLayout.error = "email should not be blank"
            binding.signProgres.visibility= View.GONE
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailIputLayout.error = "invalid email"
            binding.signProgres.visibility= View.GONE
            return
        }


        if (password.length < 6 || password.isBlank()) {
            binding.passwordInputLayout.error = "password must be 6 character"
            binding.signProgres.visibility= View.GONE
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
                binding.signProgres.visibility= View.GONE
            }
            else{
                fireBaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { it2 ->
                            if (it2.isSuccessful) {
                                binding.signProgres.visibility= View.VISIBLE
                                Toast.makeText(this, "sign in Successfully", Toast.LENGTH_LONG).show()

                                val intent = Intent(this, Content::class.java)


                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                startActivity(intent)
                            } else {
                                signProgres.visibility= View.GONE
                               // Toast.makeText(this, "Something went wrong or check your password", Toast.LENGTH_LONG).show()
                                Toast.makeText(this,it2.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }
    }

}