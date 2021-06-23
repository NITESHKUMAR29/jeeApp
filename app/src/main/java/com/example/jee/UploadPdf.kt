package com.example.jee

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_upload_pdf.*
import java.io.File
import java.util.HashMap


class UploadPdf : AppCompatActivity() {
    private lateinit var userId: String

    lateinit var storageReference: StorageReference
    lateinit var databaseReference: DatabaseReference
    private lateinit var fStore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    lateinit var uri: Uri

    object Constants {
        const val PDF_SELECT = 400
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_pdf)

        storageReference = FirebaseStorage.getInstance().reference
        databaseReference = FirebaseDatabase.getInstance().getReference("previousYear")
        uploadPdf.isEnabled = false
        auth = FirebaseAuth.getInstance()
        userId = auth.currentUser.uid

        uploadPdf.setOnClickListener {
            processUpload(uri)


        }
        getPdf.setOnClickListener {

            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/pdf"
//            intent.addCategory(Intent.CATEGORY_DEFAULT)
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), Constants.PDF_SELECT)
        }
    }

    private fun processUpload(uri: Uri) {
        val case1 =intent.getStringExtra("type1").toString()
        val case2 =intent.getStringExtra("type1").toString()
        val case3 =intent.getStringExtra("type1").toString()
        val case4 =intent.getStringExtra("type1").toString()
        val case5 =intent.getStringExtra("type1").toString()
        val case6 =intent.getStringExtra("type1").toString()
        val case7 =intent.getStringExtra("type1").toString()
        val case8 =intent.getStringExtra("type1").toString()
        val case9 =intent.getStringExtra("type1").toString()
        val case10 =intent.getStringExtra("type1").toString()
        val case11 =intent.getStringExtra("type1").toString()
        val case12 =intent.getStringExtra("type1").toString()

        val name: String = pdf_name.text.toString()
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Uploading......")
        progressDialog.show()
        fStore = FirebaseFirestore.getInstance()
        val reference: StorageReference =
            storageReference.child("/pdf/${System.currentTimeMillis()}.pdf")
        reference.putFile(uri).addOnSuccessListener {
            reference.downloadUrl.addOnSuccessListener {
                if (case1=="1"){  val documentReference: DocumentReference =
                    fStore.collection("jeeMainsPreviousYearQuestions").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }

                }
                if (case2=="2"){
                    val documentReference: DocumentReference =
                        fStore.collection("jeeMainsImportantNotes").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }

                if (case3=="3"){
                    val documentReference: DocumentReference =
                        fStore.collection("jeeMainsImportantQuestions").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }
                if (case5=="5"){
                    val documentReference: DocumentReference =
                        fStore.collection("advancePreviousYear").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }
                if(case6=="6"){
                    val documentReference: DocumentReference =
                        fStore.collection("advanceImportantNotes").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }
                if (case7=="7"){
                    val documentReference: DocumentReference =
                        fStore.collection("advanceImportantQuestions").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }

                }
                if (case9=="9"){
                    val documentReference: DocumentReference =
                        fStore.collection("wbjeePreviousYear").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }
                if (case10=="10"){
                    val documentReference: DocumentReference =
                        fStore.collection("wbjeeImportantNotes").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }
                if (case11=="11"){
                    val documentReference: DocumentReference =
                        fStore.collection("wbjeeImportantQuestions").document(System.currentTimeMillis().toString())
                    val users = HashMap<String, Any>()
                    users["pdfUri"] = it.toString()
                    users["pdfName"] = name
                    documentReference.set(users).addOnSuccessListener(OnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
                    })
                        .addOnFailureListener {

                            Toast.makeText(this, "file not uploaded", Toast.LENGTH_SHORT)
                            progressDialog.dismiss()
                        }
                }

            }

        }
            .addOnProgressListener { taskSnapshot ->
                val progress = 100 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                progressDialog.setMessage("Uploaded " + progress.toInt() + "%...")

            }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            Constants.PDF_SELECT -> if (resultCode == Activity.RESULT_OK) {
                // Get the Uri of the selected file
                uri = data?.data!!
                val uriString: String = uri.toString()
                val myFile = File(uriString)
//                val path: String = myFile.absolutePath
                var displayName: String? = null
                if (uriString.startsWith("content://")) {
                    var cursor: Cursor? = null
                    try {
                        cursor = contentResolver?.query(uri, null, null, null, null)
                        if (cursor != null && cursor.moveToFirst()) {
                            displayName =
                                cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                        }
                    } finally {
                        cursor?.close()
                    }
                } else if (uriString.startsWith("file://")) {
                    displayName = myFile.name
                }
                uri_display.text = displayName
                uploadPdf.isEnabled = true
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


}