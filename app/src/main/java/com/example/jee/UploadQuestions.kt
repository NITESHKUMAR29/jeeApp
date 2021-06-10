package com.example.jee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_upload_questions.*

class UploadQuestions : AppCompatActivity() {
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_questions)

        qSubmit.setOnClickListener {



            submitQuestion()
        }

    }

    private fun submitQuestion() {
        firestore= FirebaseFirestore.getInstance()
        val case1:String=intent.getStringExtra("type2").toString()
        val case2:String=intent.getStringExtra("type2").toString()
        val case3:String=intent.getStringExtra("type2").toString()
        val mQuestions:String=mQuestion.text.toString()
        val op1:String=mOption1.text.toString()
        val op2:String=mOption2.text.toString()
        val op3:String=mOption3.text.toString()
        val op4:String=mOption4.text.toString()
        val date:String=mdate.text.toString()
        val rightAnswer=mAns.text.toString()
        if (case1=="4") {
            val documentReference: DocumentReference =
                firestore.collection("DppQuestion").document(System.currentTimeMillis().toString())
            val questions = HashMap<String, Any>()
            questions["dppQuestions"] = mQuestions
            questions["option1"] = op1
            questions["option2"] = op2
            questions["option3"] = op3
            questions["option4"] = op4
            questions["date"] = date
            questions["dppAns"] = rightAnswer
            documentReference.set(questions).addOnSuccessListener(OnSuccessListener {

                Toast.makeText(this, "uploaded", Toast.LENGTH_SHORT).show()

            })
        }

        if (case2=="8"){

            val documentReference: DocumentReference =
                firestore.collection("AdvanceDppQuestion").document(System.currentTimeMillis().toString())
            val questions = HashMap<String, Any>()
            questions["dppQuestions"] = mQuestions
            questions["option1"] = op1
            questions["option2"] = op2
            questions["option3"] = op3
            questions["option4"] = op4
            questions["date"] = date
            questions["dppAns"] = rightAnswer
            documentReference.set(questions).addOnSuccessListener(OnSuccessListener {

                Toast.makeText(this, "uploaded", Toast.LENGTH_SHORT).show()

            })

        }
        if (case3=="12"){

            val documentReference: DocumentReference =
                firestore.collection("WbjeeDppQuestion").document(System.currentTimeMillis().toString())
            val questions = HashMap<String, Any>()
            questions["dppQuestions"] = mQuestions
            questions["option1"] = op1
            questions["option2"] = op2
            questions["option3"] = op3
            questions["option4"] = op4
            questions["date"] = date
            questions["dppAns"] = rightAnswer
            documentReference.set(questions).addOnSuccessListener(OnSuccessListener {

                Toast.makeText(this, "uploaded", Toast.LENGTH_SHORT).show()

            })


        }


    }
}