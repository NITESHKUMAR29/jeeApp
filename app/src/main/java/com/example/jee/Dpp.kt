package com.example.jee

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.adapters.DppAdapter
import com.example.jee.models.DppModel
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_dpp.*
import kotlinx.android.synthetic.main.activity_editprofile.*
import kotlinx.android.synthetic.main.activity_sample_question.*
import kotlinx.android.synthetic.main.activity_sample_question.view.*


class Dpp : AppCompatActivity()

 {
    lateinit var fstore: FirebaseFirestore
    private lateinit var list2: ArrayList<DppModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dpp)

            val str:String=intent.getStringExtra("type").toString()
            val str1:String=intent.getStringExtra("type").toString()
            val str2:String=intent.getStringExtra("type").toString()

        fstore= FirebaseFirestore.getInstance()
        list2= ArrayList()
            if (str=="4"){

            uplodedDpp()
            }
            if (str1=="8"){
                uploadAdvanceDpp()
            }
        if (str2=="12"){
            uploadWbjeeDpp()
        }
        dpp_upload.setOnClickListener {
            val intent=Intent(this,UploadQuestions::class.java)
            intent.putExtra("type2",str)
            intent.putExtra("type2",str1)
            intent.putExtra("type2",str2)
            startActivity(intent)
        }
   }
     private fun uploadWbjeeDpp() {

         dppProgress.visibility=View.VISIBLE
         fstore.collection("WbjeeDppQuestion").get().addOnSuccessListener(OnSuccessListener {it3->

             val querySnapshot:QuerySnapshot=it3
             if (!querySnapshot.isEmpty){
                 val list:List<DocumentSnapshot> =querySnapshot.documents
                 for (b in list){
                     list2.add(DppModel(b.get("dppQuestions").toString(),b.get("date").toString(),b.get("option1").toString(),b.get("option2").toString()
                         ,b.get("option3").toString(),b.get("option4").toString(),b.get("dppAns").toString()
                     ))
                 }
                 dppProgress.visibility=View.GONE
             }
             else{
                 dppProgress.visibility=View.GONE
                 errores.visibility=View.VISIBLE
                 Toast.makeText(this,"Something went wrong!! \n try again later", Toast.LENGTH_SHORT).show()
             }
             runOnUiThread {
                 val adapters = DppAdapter(list2,this)
                 val recyclerView: RecyclerView = findViewById(R.id.dppRecyclerView)
                 recyclerView.adapter = adapters
                 recyclerView.hasFixedSize()
                 recyclerView.layoutManager= LinearLayoutManager(this)
             }
         })
     }
     private fun uploadAdvanceDpp() {
          dppProgress.visibility=View.VISIBLE
                 fstore.collection("AdvanceDppQuestion").get().addOnSuccessListener(OnSuccessListener {it3->

                     val querySnapshot:QuerySnapshot=it3
                     if (!querySnapshot.isEmpty){
                         val list:List<DocumentSnapshot> =querySnapshot.documents
                         for (b in list){
                             list2.add(DppModel(b.get("dppQuestions").toString(),b.get("date").toString(),b.get("option1").toString(),b.get("option2").toString()
                                 ,b.get("option3").toString(),b.get("option4").toString(),b.get("dppAns").toString()
                             ))
                         }
                         dppProgress.visibility=View.GONE
                     }
                     else{
                         errores.visibility=View.VISIBLE
                         dppProgress.visibility=View.GONE
                         Toast.makeText(this,"Something went wrong!! \n try again later", Toast.LENGTH_SHORT).show()
                     }
                     runOnUiThread {
                         val adapters = DppAdapter(list2,this)
                         val recyclerView: RecyclerView = findViewById(R.id.dppRecyclerView)
                         recyclerView.adapter = adapters
                         recyclerView.hasFixedSize()
                         recyclerView.layoutManager= LinearLayoutManager(this)
                     }
                 })
     }

     private fun uplodedDpp() {
        dppProgress.visibility=View.VISIBLE
        fstore.collection("DppQuestion").get().addOnSuccessListener(OnSuccessListener {it3->

            val querySnapshot:QuerySnapshot=it3
            if (!querySnapshot.isEmpty){
                val list:List<DocumentSnapshot> =querySnapshot.documents
                for (b in list){
                    list2.add(DppModel(b.get("dppQuestions").toString(),b.get("date").toString(),b.get("option1").toString(),b.get("option2").toString()
                    ,b.get("option3").toString(),b.get("option4").toString(),b.get("dppAns").toString()
                    ))
                }
                dppProgress.visibility=View.GONE
            }
            else{
                errores.visibility=View.VISIBLE
                    dppProgress.visibility=View.GONE
                Toast.makeText(this,"Something went wrong!! \n try again later", Toast.LENGTH_SHORT).show()
            }
           runOnUiThread {
                val adapters = DppAdapter(list2,this)
               val recyclerView: RecyclerView = findViewById(R.id.dppRecyclerView)
               recyclerView.adapter = adapters
               recyclerView.hasFixedSize()
               recyclerView.layoutManager= LinearLayoutManager(this)
           }
      })
    }
 }