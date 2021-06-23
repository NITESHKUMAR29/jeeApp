package com.example.jee.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.R

class OmrAdapter(private  val list: ArrayList<String> ,val context:Context,
            private  val listener: OnItemClickListener
                 ):RecyclerView.Adapter<OmrAdapter.Omr> (){
    inner  class Omr(itemView: View,onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        val qNo:TextView=itemView.findViewById(R.id.qNo)
        private val rightAnswer:CardView=itemView.findViewById(R.id.rightAnswer)
        private val wrongAnswer:CardView=itemView.findViewById(R.id.wrongAnswer)

        val omr:CardView=itemView.findViewById(R.id.omr_Sheet);
        private val omr1:ImageView=itemView.findViewById(R.id.omrOption1)
        private val omr2:ImageView=itemView.findViewById(R.id.omrOption2)
        private val omr3:ImageView=itemView.findViewById(R.id.omrOption3)
        private val omr4:ImageView=itemView.findViewById(R.id.omrOption4)

        init {


                rightAnswer.setOnClickListener {
                    onItemClickListener.onRightClick(adapterPosition)
                    rightAnswer.visibility=View.GONE
                    wrongAnswer.visibility=View.GONE

                }
            wrongAnswer.setOnClickListener {
                onItemClickListener.onWrongClick(adapterPosition)
                rightAnswer.visibility=View.GONE
                wrongAnswer.visibility=View.GONE

            }


                    omr1.setOnClickListener {
                        onItemClickListener.onOmr1Click(adapterPosition)
                        dSelect()
                        omr1.setBackgroundResource(R.drawable.customomrbackground)
                    }

                    omr2.setOnClickListener {
                        onItemClickListener.onOmr2Click(adapterPosition)
                        dSelect()
                        omr2.setBackgroundResource(R.drawable.customomrbackground)
                    }

                    omr3.setOnClickListener {
                        onItemClickListener.onOmr3Click(adapterPosition)
                        dSelect()
                        omr3.setBackgroundResource(R.drawable.customomrbackground)
                    }

                    omr4.setOnClickListener {
                        onItemClickListener.onOmr4Click(adapterPosition)
                        dSelect()
                        omr4.setBackgroundResource(R.drawable.customomrbackground)
                    }
        }

        private fun dSelect() {
            omr1.setBackgroundColor(Color.WHITE)
            omr2.setBackgroundColor(Color.WHITE)
            omr3.setBackgroundColor(Color.WHITE)
            omr4.setBackgroundColor(Color.WHITE)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Omr

    {
      val layoutInflater=LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.omr_sample,parent,false)
        return Omr(view,listener)

    }

    override fun getItemCount(): Int =list.size
    override fun onBindViewHolder(holder: Omr, position: Int) {
        val currentItem=list[position]
        holder.qNo.text=currentItem

    }
        interface OnItemClickListener{
            fun onRightClick(position: Int)
            fun onWrongClick(position: Int)
            fun onOmr1Click(position: Int)
            fun onOmr2Click(position: Int)
            fun onOmr3Click(position: Int)
            fun onOmr4Click(position: Int)
        }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}