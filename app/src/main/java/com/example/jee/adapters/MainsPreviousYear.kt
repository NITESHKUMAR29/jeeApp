package com.example.jee.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.PdfViewer
import com.example.jee.R
import com.example.jee.models.Model
import kotlinx.android.synthetic.main.mainspdf_sample.view.*

class MainsPreviousYear(private  val list:ArrayList<Model>,val context:Context):RecyclerView.Adapter<MainsPreviousYear.Mains>() {
    inner  class Mains(itemView:View):RecyclerView.ViewHolder(itemView){
        val pdfName:TextView=itemView.findViewById(R.id.mPdfname)
        val uri:TextView=itemView.findViewById(R.id.uri)
        val openPdf:CardView=itemView.findViewById(R.id.mcard)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mains
   =  Mains(LayoutInflater.from(parent.context).inflate(R.layout.mainspdf_sample,parent,false))


    override fun getItemCount(): Int=list.size


    override fun onBindViewHolder(holder: Mains, position: Int) {
       val currentItem=list[position]
        holder.pdfName.text= currentItem.pdfName
        holder.uri.text=currentItem.pdfUri
        holder.openPdf.setOnClickListener {
            val intent= Intent(context,PdfViewer::class.java)
            intent.putExtra("pdfUri",currentItem.pdfUri)
            context.startActivity(intent)
        }

    }


}