package com.example.jee.jeeMains

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.R
import com.example.jee.UploadPdf
import com.example.jee.adapters.MainsPreviousYear
import com.example.jee.models.Model
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_mainspdf.*
import kotlin.collections.ArrayList

class MainsPdf : AppCompatActivity() {
    lateinit var list: ArrayList<Model>
    lateinit var string: String
    lateinit var  firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainspdf)
         val firstButton =intent.getStringExtra("type").toString()
         val secondButton =intent.getStringExtra("type").toString()
         val thirdButton =intent.getStringExtra("type").toString()

        val fifthButton =intent.getStringExtra("type").toString()
        val sixthButton =intent.getStringExtra("type").toString()
        val seventhButton =intent.getStringExtra("type").toString()

        val ninthButton =intent.getStringExtra("type").toString()
        val tenthButton =intent.getStringExtra("type").toString()
        val eleventhButton =intent.getStringExtra("type").toString()

      firestore= FirebaseFirestore.getInstance()
        list=ArrayList()
        if (firstButton=="1") {
            setRecycler()
        }
         if (secondButton=="2"){
            setRecycler1()
        }
         if (thirdButton=="3"){
            setRecycler2()
        }


        if(fifthButton=="5"){
            setRecycler4()
        }
        if(sixthButton=="6"){
            setRecycler5()
        }
        if(seventhButton=="7"){
            setRecycler6()

        }

        if (ninthButton=="9"){
            setRecycler8()
        }
        if (tenthButton=="10"){
            setRecycler9()
        }
        if (eleventhButton=="11"){
            setRecycler10()
        }



        pdfFab.setOnClickListener {

            val intent=Intent(this, UploadPdf::class.java)
            intent.putExtra("type1",firstButton)
            intent.putExtra("type1",secondButton)
            intent.putExtra("type1",thirdButton)

            intent.putExtra("type1",fifthButton)
            intent.putExtra("type1",sixthButton)
            intent.putExtra("type1",seventhButton)

            intent.putExtra("type1",ninthButton)
            intent.putExtra("type1",tenthButton)
            intent.putExtra("type1",eleventhButton)


            startActivity(intent)
        }
    }










    private fun setRecycler10() {
        firestore.collection("wbjeeImportantQuestions").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                        Log.e("OKOK",a.get("pdfName").toString())
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)
                }

            })
    }

    private fun setRecycler9() {
        firestore.collection("wbjeeImportantNotes").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)
                }

            })
    }

    private fun setRecycler8() {
        firestore.collection("wbjeePreviousYear").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)                }

            })
    }



    private fun setRecycler6() {
        firestore.collection("advanceImportantQuestions").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)                }

            })
    }

    private fun setRecycler5() {
        firestore.collection("advanceImportantNotes").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)
                }

            })
    }

    private fun setRecycler4() {
        firestore.collection("advancePreviousYear").get().addOnSuccessListener(
            OnSuccessListener {it2->
                val querySnapshot:QuerySnapshot=it2
                if (!querySnapshot.isEmpty){
                    progressBar.visibility=View.GONE
                    val list1:List<DocumentSnapshot> =querySnapshot.documents
                    for (a in list1){
                        list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                    }


                }
                else{
                    Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                    progressBar.visibility=View.GONE
                }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)                }

            })
    }


    private fun setRecycler2() {

       firestore.collection("jeeMainsImportantQuestions").get().addOnSuccessListener(
           OnSuccessListener {it2->
               val querySnapshot:QuerySnapshot=it2
               if (!querySnapshot.isEmpty){
                   progressBar.visibility=View.GONE
                   val list1:List<DocumentSnapshot> =querySnapshot.documents
                   for (a in list1){
                       list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                   }


               }
               else{
                   Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                   erore.visibility=View.VISIBLE
                   progressBar.visibility=View.GONE
               }
               runOnUiThread {
                   val adapters = MainsPreviousYear(list, this)
                   val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                   recyclerView.adapter = adapters
                   recyclerView.hasFixedSize()
                   recyclerView.layoutManager=LinearLayoutManager(this)               }

           })

    }

    private fun setRecycler1() {
       firestore.collection("jeeMainsImportantNotes").get().addOnSuccessListener(OnSuccessListener { it1->

           val querySnapshot:QuerySnapshot=it1
           if (!querySnapshot.isEmpty){
               progressBar.visibility=View.GONE
               val list1:List<DocumentSnapshot> =querySnapshot.documents
               for (a in list1){
                   list.add(Model(a.get("pdfName").toString(), a.get("pdfUri").toString()))
                     Log.e("OKOK", a.getString("pdfName").toString())
                    Log.e("OKOK", a.getString("pdfUri").toString())
               }
           }
           else{
                   Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                   erore.visibility=View.VISIBLE
                   progressBar.visibility=View.GONE
           }
           runOnUiThread {
               val adapters = MainsPreviousYear(list, this)
               val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
               recyclerView.adapter = adapters
               recyclerView.hasFixedSize()
               recyclerView.layoutManager=LinearLayoutManager(this)           }
       })

    }

    private fun setRecycler() {

       firestore.collection("jeeMainsPreviousYearQuestions").get()
           .addOnSuccessListener(OnSuccessListener { it ->
               val querySnapshot: QuerySnapshot = it
               if (!querySnapshot.isEmpty) {
                   progressBar.visibility=View.GONE
               val list1: List<DocumentSnapshot> =
                   querySnapshot.documents
               for (d in list1) {
                   list.add(Model(d.get("pdfName").toString(), d.get("pdfUri").toString()))
                 //  Log.e("OKOK", d.getString("pdfName").toString())
                  // Log.e("OKOK", d.getString("pdfUri").toString())

               }
           }
               else{
                   Toast.makeText(this,"Something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                    erore.visibility=View.VISIBLE
                   progressBar.visibility=View.GONE

               }
                runOnUiThread {
                    val adapters = MainsPreviousYear(list, this)
                    val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
                    recyclerView.adapter = adapters
                    recyclerView.hasFixedSize()
                    recyclerView.layoutManager=LinearLayoutManager(this)                    // Log.e("OKOK",list[1].pdfUri)
                }
           })
  }
}