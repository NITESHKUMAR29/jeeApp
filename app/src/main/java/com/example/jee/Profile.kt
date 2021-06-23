package com.example.jee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    private lateinit var fStore:FirebaseFirestore
    lateinit var userId: String
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth= FirebaseAuth.getInstance()
        fStore= FirebaseFirestore.getInstance()
        userId = auth.currentUser!!.uid
        edit_profile.setOnClickListener {
            //Toast.makeText(this,"edit profile clicked",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,EditProfile::class.java)
            var username:String=user_name.text.toString()
            var useAspirant:String=aspirant.text.toString()
            var userBio:String=user_bio.text.toString()
            intent.putExtra("userName",username)
            intent.putExtra("userAspirant",useAspirant)
            intent.putExtra("userBio",userBio)
            startActivity(intent)

        }

    }

    override fun onResume() {
        super.onResume()

        val documentReference:DocumentReference=fStore.collection("users").document(userId)
        documentReference.addSnapshotListener { value, error ->

            if (value==null||error!=null){
                Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            else{

                val documentSnapshot:DocumentSnapshot=value

                user_email.text=documentSnapshot.getString("userEmail")
            }
        }
        val documents:DocumentReference=fStore.collection("users").document(userId)
        documents.addSnapshotListener { value, error ->

            if (value==null||error!=null){
                Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            else{

                val documentSnapshot:DocumentSnapshot=value

                user_name.text=documentSnapshot.getString("userName")
                aspirant.text=documentSnapshot.getString("userAspirant")
                user_bio.text=documentSnapshot.getString("userBio")
            }
        }


        val document: DocumentReference =fStore.collection("users").document(userId)
        document.addSnapshotListener { value, error ->
            if (value==null||error!=null){
                Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            else{
                val document: DocumentSnapshot =value
                val uri = document.getString("imageUri")


                if(uri != null)
                    Glide.with(applicationContext).load(uri).into(uploaded_profile)
            }
        }

    }


}