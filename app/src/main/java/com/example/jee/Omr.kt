package com.example.jee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jee.adapters.OmrAdapter
import kotlinx.android.synthetic.main.activity_omr.*

class Omr : AppCompatActivity()
   , OmrAdapter.OnItemClickListener
{
    private lateinit var rightMark:String
    lateinit var questions: String
    private lateinit var list: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_omr)
        questions=intent.getStringExtra("questions").toString()
         rightMark=intent.getStringExtra("cMark").toString()

        list=ArrayList()
        for (i in 1..questions.toInt()){
            list.add(i.toString())
        }
        omrRecyclerView.adapter=OmrAdapter(list,this,this)
        omrRecyclerView.hasFixedSize()
        omrRecyclerView.layoutManager=LinearLayoutManager(this)
        submit.setOnClickListener {
            submits()
        }
    }
    private fun submits() {
        val intent=Intent(this,OmrResult::class.java)
        val totalMark=questions.toInt()*rightMark.toInt()
        val totalMarks:String=totalMark.toString()
       intent.putExtra("totalMark",totalMarks)
        intent.putExtra("totalRightMark",addResult.text)
        intent.putExtra("rightAnswer",answerdQuestions.text)
        intent.putExtra("totalQuestion",questions)
        intent.putExtra("wrongAnswer",wrongAnswerNo.text)
        startActivity(intent)
    }

    override fun onOmr1Click(position: Int) {
    }

    override fun onOmr2Click(position: Int) {

    }

    override fun onOmr3Click(position: Int) {


    }

    override fun onOmr4Click(position: Int) {


   }

    override fun onRightClick(position: Int) {

        val rightMark:String=intent.getStringExtra("cMark").toString()
        if (addResult.text==""){
            addResult.text="0"
        }
        if (answerdQuestions.text==""){
            answerdQuestions.text="0"
        }
        val totalAnswers:String=answerdQuestions.text.toString()
        val answer=totalAnswers.toInt()+1

       val mark:String=addResult.text.toString()
        val totalMark=mark.toInt()+rightMark.toInt()
        addResult.text=totalMark.toString()
        answerdQuestions.text= answer.toString()
    }
    override fun onWrongClick(position: Int) {

        val wrongMark:String=intent.getStringExtra("negativeMark").toString()
        if (addResult.text==""){
            addResult.text="0"
        }
        if (wrongAnswerNo.text==""){
            wrongAnswerNo.text="0"
        }
        val totalAnswerd:String=wrongAnswerNo.text.toString()
        val answer=totalAnswerd.toInt()+1
        val mark:String=addResult.text.toString()
        val totalMark=mark.toInt()-wrongMark.toInt()
        addResult.text=totalMark.toString()
        wrongAnswerNo.text= answer.toString()

    }
}