package com.example.jee

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_editprofile.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*


class EditProfile : AppCompatActivity() {
    private lateinit var fStore: FirebaseFirestore
    lateinit var storageReference: StorageReference
    lateinit var userId: String
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)
        auth = FirebaseAuth.getInstance()
        fStore = FirebaseFirestore.getInstance()
        userId = auth.currentUser.uid

        var usName: String? =intent.getStringExtra("userName")
        var usAspirant:String?=intent.getStringExtra("userAspirant")
        var usBio:String?=intent.getStringExtra("userBio")

        edit_profile_name.setText(usName)
        edit_profile_aspirant.setText(usAspirant)
        edit_profile_bio.setText(usBio)


        save.setOnClickListener {

            saveProfile()
        }
        edit_profile_btnUpload.setOnClickListener {
            uploadProfile()
        }

        edit_profile_picture.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

        val document: DocumentReference = fStore.collection("users").document(userId)
        document.addSnapshotListener { value, error ->
            if (value == null || error != null) {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            } else {
                val document: DocumentSnapshot = value
                val uri = document.getString("imageUri")


                if (uri != null)
                    Glide.with(applicationContext).load(uri).into(edit_profile_picture)

            }



        }

        val documentReference: DocumentReference = fStore.collection("users").document(userId)
        documentReference.addSnapshotListener { value, error ->

            if (value == null || error != null) {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            } else {

                val documentSnapshot: DocumentSnapshot = value

                edit_email.text = documentSnapshot.getString("userEmail")
            }
        }
    }

    private fun uploadProfile() {

        val progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Uploading...")
       // progressDialog.setCancelable(false)
        progressDialog.show()
        if (selectedPhoto == null) {
            Toast.makeText(this,"please select photo",Toast.LENGTH_SHORT).show()
            progressDialog.dismiss()
            return

        }
        val fileName = UUID.randomUUID().toString()


         val bmp:Bitmap=MediaStore.Images.Media.getBitmap(contentResolver,selectedPhoto)
        val baos = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG,20,baos)
        val fileInBytes = baos.toByteArray()
        val reference = FirebaseStorage.getInstance().getReference("/image/$fileName")
        reference.putBytes(fileInBytes).addOnSuccessListener {
            reference.downloadUrl.addOnSuccessListener {
                val documentReference: DocumentReference =
                    fStore.collection("users").document(userId)
                val users = HashMap<String, Any>()
                users["imageUri"] = it.toString()
                documentReference.update(users).addOnSuccessListener(OnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(this, "profile upload succesfully", Toast.LENGTH_LONG).show()
                })
                    .addOnFailureListener(OnFailureListener {
                        Toast.makeText(this, "profile is not uploaded", Toast.LENGTH_LONG).show()
                        progressDialog.dismiss()
                    })
            }
        }
            .addOnProgressListener { it->
                val progress=100*it.bytesTransferred/it.totalByteCount
                progressDialog.setMessage("Uploaded "+progress.toInt()+"%...")
            }

    }

    private fun saveProfile() {
        mprogresBar.visibility=View.VISIBLE
        val userName: String = edit_profile_name.text.toString()
        val userAspirant: String = edit_profile_aspirant.text.toString()
        val userBio: String = edit_profile_bio.text.toString()
        val documents: DocumentReference = fStore.collection("users").document(userId)
        val userDetails = HashMap<String, Any>()
        userDetails["userName"] = userName
        userDetails["userAspirant"] = userAspirant
        userDetails["userBio"] = userBio
        documents.update(userDetails).addOnSuccessListener(OnSuccessListener {
            mprogresBar.visibility=View.GONE
//            val intent = Intent(this, Profile::class.java)
//            startActivity(intent)
            finish()
        })

    }

    var selectedPhoto: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            selectedPhoto = data.data

//            var bmp: Bitmap? = null
//            try {
//                bmp = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhoto)
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//            val baos = ByteArrayOutputStream()
//
//            //here you can choose quality factor in third parameter(ex. i choosen 25)
//
//            //here you can choose quality factor in third parameter(ex. i choosen 25)
//            bmp!!.compress(Bitmap.CompressFormat.JPEG, 25, baos)
//            val fileInBytes: ByteArray = baos.toByteArray()
//
//            val photoref: StorageReference =
//                chatPhotosStorageReference.child(selectedPhoto.getLastPathSegment())


            edit_profile_picture.setImageURI(selectedPhoto)
//            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//            val cursor: Cursor? = selectedPhoto?.let { contentResolver.query(it, filePathColumn, null, null, null) }
//            cursor?.moveToFirst()
//            val columnIndex: Int = cursor?.getColumnIndex(filePathColumn[0]) ?: 0
//            val filePath: String? = cursor?.getString(columnIndex)
//
////            Log.v("roni", filePath)
//            cursor?.close()
//            if (bitmap != null && !bitmap!!.isRecycled) {
//                bitmap = null
//            }
//
//            bitmap = BitmapFactory.decodeFile(filePath)
//            //imageView.setBackgroundResource(0);
//            //imageView.setBackgroundResource(0);
//            imageUpload.setImageBitmap(bitmap)

        }
    }

}