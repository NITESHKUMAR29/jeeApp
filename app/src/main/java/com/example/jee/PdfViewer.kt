package com.example.jee

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import kotlinx.android.synthetic.main.activity_editprofile.*
import kotlinx.android.synthetic.main.activity_pdf_viewer.*
import java.io.File

class PdfViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        val uriString:String=intent.getStringExtra("pdfUri").toString()

       com.krishna.fileloader.FileLoader.with(this).load(uriString,false).
       fromDirectory("PDFLoader",com.krishna.fileloader.FileLoader.DIR_INTERNAL)

           .asFile(object :FileRequestListener<File>{

               override fun onLoad(request: FileLoadRequest?, response: FileResponse<File>?) {

                 val pdFile=response!!.body

                   mPdf.fromFile(pdFile)
                       .defaultPage(0)
                       .spacing(10)
                       .load()
                   progresBar.visibility=View.GONE
               }

               override fun onError(request: FileLoadRequest?, t: Throwable?) {


                   monkeyError.visibility=View.VISIBLE
                   Toast.makeText(this@PdfViewer,"something went wrong!! \n try again later",Toast.LENGTH_SHORT).show()
                   mPdf.visibility=View.GONE
                   progresBar.visibility=View.GONE
                   monkeyError.visibility=View.VISIBLE
               }

           })
    }



}