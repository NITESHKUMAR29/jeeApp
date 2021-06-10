package com.example.jee.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.Dpp
import com.example.jee.R
import com.example.jee.RightAnswer
import com.example.jee.WrongAnswer
import com.example.jee.models.DppModel
import kotlinx.android.synthetic.main.activity_sample_question.view.*
import maes.tech.intentanim.CustomIntent

import javax.sql.StatementEventListener


class DppAdapter(private val list2: ArrayList<DppModel>,val context: Context//,private  val listener:onItemClickListner



                 ):RecyclerView.Adapter<DppAdapter.Dpp>() {

    inner  class Dpp(itemView:View):RecyclerView.ViewHolder(itemView)//,View.OnClickListener
     {

//        init {
//            itemView.setOnClickListener(this)
//
//            itemView.option1.setOnClickListener(this)
//        }

//        override fun onClick(v: View?) {
//            val position=adapterPosition
//            if (position!=RecyclerView.NO_POSITION) {
//                listener.onItemClick(position)
//
//
//            }
//
//        }

        //




        fun dSelect() {
            option1.setBackgroundColor(Color.WHITE)
            option2.setBackgroundColor(Color.WHITE)
            option3.setBackgroundColor(Color.WHITE)
            option4.setBackgroundColor(Color.WHITE)
        }
        val buttonSubmit:CardView=itemView.findViewById(R.id.buttonSubmit)
       //val mRight:CardView=itemView.findViewById(R.id.mrightAnswer)
        // val mWrong:CardView=itemView.findViewById(R.id.mWrongAnswer)
        val test:TextView=itemView.findViewById(R.id.testValue)
        val dppQuestion:TextView=itemView.findViewById(R.id.dpp_question)
        val option1:TextView=itemView.findViewById(R.id.option1)
        val option2:TextView=itemView.findViewById(R.id.option2)
        val option3:TextView=itemView.findViewById(R.id.option3)
        val option4:TextView=itemView.findViewById(R.id.option4)
        val date:TextView=itemView.findViewById(R.id.date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dpp =
         Dpp(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_sample_question, parent, false)
        )


    override fun getItemCount(): Int =list2.size



    override fun onBindViewHolder(holder: Dpp, position: Int) {
        val currentItem = list2[position]

        holder.dppQuestion.text = currentItem.dppQuestions
        holder.option1.text = currentItem.option1
        holder.option2.text = currentItem.option2
        holder.option3.text = currentItem.option3
        holder.option4.text = currentItem.option4
        holder.date.text = currentItem.date



        holder.option1.setOnClickListener {
            holder.dSelect()
            holder.option1.setBackgroundResource(R.drawable.custome_pdf)
            holder.test.text = "1"
            holder.buttonSubmit.visibility = View.VISIBLE
////            if(currentItem.option1==currentItem.dppAns){
////              //  Toast.makeText(this.context,"answer is right",Toast.LENGTH_SHORT).show()
////            }
////          else{
////              //  Toast.makeText(this.context,"answer is wrong",Toast.LENGTH_SHORT).show()
////               holder.rightAnswer.visibility=View.VISIBLE
            // }

        }
        holder.option2.setOnClickListener {
            holder.dSelect()
            holder.option2.setBackgroundResource(R.drawable.custome_pdf)
            holder.test.text = "2"
            holder.buttonSubmit.visibility = View.VISIBLE
////            if(currentItem.option2==currentItem.dppAns){
////               // Toast.makeText(this.context,"answer is right",Toast.LENGTH_SHORT).show()
////            }
////            else{
////                //Toast.makeText(this.context,"answer is wrong",Toast.LENGTH_SHORT).show()
////                holder.rightAnswer.visibility=View.VISIBLE
////            }
        }
        holder.option3.setOnClickListener {
            holder.dSelect()
            holder.option3.setBackgroundResource(R.drawable.custome_pdf)
            holder.test.text = "3"
            holder.buttonSubmit.visibility = View.VISIBLE
////            if(currentItem.option3==currentItem.dppAns){
////               // Toast.makeText(this.context,"answer is right",Toast.LENGTH_SHORT).show()
////            }
////            else{
////               // Toast.makeText(this.context,"answer is wrong",Toast.LENGTH_SHORT).show()
////                holder.rightAnswer.visibility=View.VISIBLE
////            }
        }
        holder.option4.setOnClickListener {
            holder.dSelect()
            holder.option4.setBackgroundResource(R.drawable.custome_pdf)
            holder.test.text = "4"
          holder.buttonSubmit.visibility = View.VISIBLE
////            if(currentItem.option4==currentItem.dppAns){
////               // Toast.makeText(this.context,"answer is right",Toast.LENGTH_SHORT).show()
////            }
////            else{
////                //Toast.makeText(this.context,"answer is wrong",Toast.LENGTH_SHORT).show()
////                holder.rightAnswer.visibility=View.VISIBLE
////            }
        }
//
//

            holder.buttonSubmit.setOnClickListener {
                val testString: String = holder.test.text.toString()
                if (testString == "1" && currentItem.option1 == currentItem.dppAns) {
                    val intent=Intent(context,RightAnswer::class.java)
                   context.startActivity(intent)
                    CustomIntent.customType(context,"fadein-to-fadeout")

                    //  intent.putExtra("value","1")
                  // holder.mRight.visibility=View.VISIBLE

                } else if (testString == "2" && currentItem.option2 == currentItem.dppAns) {
                  val intent=Intent(context,RightAnswer::class.java)
                    context.startActivity(intent)
                    CustomIntent.customType(context,"fadein-to-fadeout")

//                    intent.putExtra("value","1")
                   // holder.mRight.visibility=View.VISIBLE
                } else if (testString == "3" && currentItem.option3 == currentItem.dppAns) {
                    val intent=Intent(context,RightAnswer::class.java)
                  context.startActivity(intent)
                    CustomIntent.customType(context,"fadein-to-fadeout")

                    //holder.mRight.visibility=View.VISIBLE
                } else if (testString == "4" && currentItem.option4 == currentItem.dppAns) {
                    val intent=Intent(context,RightAnswer::class.java)
                   context.startActivity(intent)
                    CustomIntent.customType(context,"fadein-to-fadeout")
//                   intent.putExtra("value","1")
                  // holder.mRight.visibility=View.VISIBLE

                } else {
                   //holder.rightAnswer.visibility = View.VISIBLE
                    val intent=Intent(context,WrongAnswer::class.java)
                    intent.putExtra("rightAnswer",currentItem.dppAns)
                    context.startActivity(intent)
                    CustomIntent.customType(context,"fadein-to-fadeout")
//
//                    val intent=Intent(context,Dpp::class.java)
//                   context.startActivity(intent)
                    //intent.putExtra("value","2")
                    //holder.mWrong.visibility=View.VISIBLE
                }
            }
        }
//    interface onItemClickListner{
//        fun  onItemClick(position: Int)
//
//    }


}
