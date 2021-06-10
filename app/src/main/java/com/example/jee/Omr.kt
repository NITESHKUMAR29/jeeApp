package com.example.jee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.adapters.OmrAdapter
import kotlinx.android.synthetic.main.activity_omr.*

class Omr : AppCompatActivity() ,OmrAdapter.OnItemClickListener
{
    lateinit var list: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_omr)
        val questions:String=intent.getStringExtra("questions").toString()
        list=ArrayList()
        for (i in 1..questions.toInt()){
            list.add(i.toString())
        }
        omrRecyclerView.adapter=OmrAdapter(list,this,this)
        omrRecyclerView.hasFixedSize()
        omrRecyclerView.layoutManager=LinearLayoutManager(this)
    }

    override fun onOmr1Click(position: Int) {
        Toast.makeText(this,"clicked111",Toast.LENGTH_SHORT).show()

    }

    override fun onOmr2Click(position: Int) {
        Toast.makeText(this,"clicked2",Toast.LENGTH_SHORT).show()

    }

    override fun onOmr3Click(position: Int) {
        Toast.makeText(this,"clicked3",Toast.LENGTH_SHORT).show()

    }

    override fun onOmr4Click(position: Int) {
        Toast.makeText(this,"clicked4",Toast.LENGTH_SHORT).show()

   }

    override fun onRightClick(position: Int) {

        val rightMark:String=intent.getStringExtra("cMark").toString()
        if (addResult.text==""){
            addResult.text="0"
        }
       val mark:String=addResult.text.toString()
        val totalMark=mark.toInt()+rightMark.toInt()
        addResult.text=totalMark.toString()
    }
    override fun onWrongClick(position: Int) {

        val wrongMark:String=intent.getStringExtra("negativeMark").toString()
        if (addResult.text==""){
            addResult.text="0"
        }
        val mark:String=addResult.text.toString()
        val totalMark=mark.toInt()-wrongMark.toInt()
        addResult.text=totalMark.toString()

    }
}