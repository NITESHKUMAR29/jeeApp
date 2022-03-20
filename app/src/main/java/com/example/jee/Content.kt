package com.example.jee

import android.app.StatusBarManager
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.jee.activity.AddMaterials
import com.example.jee.fragments.AssignMentFragment
import com.example.jee.fragments.BlankFragment
import com.example.jee.fragments.ChatFragment
import com.example.jee.fragments.NotesFragment

import com.example.jee.jeeAdvance.AdvanceMaterial
import com.example.jee.jeeMains.ChoosePdf
import com.example.jee.neet.NeetMaterial
import com.example.jee.wbjee.WbjeeMaterial
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_content.*
import java.util.*

class Content : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var openAnimation:Animation
    lateinit var closeAnimation: Animation
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var auth: FirebaseAuth
    lateinit var fStore: FirebaseFirestore
    lateinit var userId: String
    lateinit var textView: TextView
    lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Jee)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)



        val homeFragment=BlankFragment()
        val assignmentFragment=AssignMentFragment()
        val notesFragment=NotesFragment()
        val chatFragment=ChatFragment()
        setCurrentFragment(homeFragment)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false




        var isOpen = false
        closeFAB()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.assignment -> setCurrentFragment(assignmentFragment)
                R.id.notes -> setCurrentFragment(notesFragment)
                R.id.chat -> setCurrentFragment(chatFragment)
            }
            true
        }


        madd.setOnClickListener {

                val intent=Intent(this,AddMaterials::class.java)
                startActivity(intent)
        }
        mOmr.setOnClickListener{
            val intent=Intent(this,OmrOption::class.java)
            startActivity(intent)
           // Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()


        }

        mnotes.setOnClickListener {
            //Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()
           val intent = Intent(this,Notes::class.java)
            startActivity(intent)
        }

        navigation_view.setNavigationItemSelectedListener(this)
        auth = FirebaseAuth.getInstance()
        fStore = FirebaseFirestore.getInstance()
        userId = auth.currentUser!!.uid
        val view = LayoutInflater.from(this).inflate(R.layout.drawer_header, null)
        navigation_view.addHeaderView(view)
        textView = navigation_view.getHeaderView(0).findViewById(R.id.textView3)
        imageView = navigation_view.getHeaderView(0).findViewById(R.id.imageView)
        val documentReference: DocumentReference = fStore.collection("users").document(userId)
        documentReference.addSnapshotListener { value, error ->

            if (value == null || error != null) {

                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            } else {
//                Log.i("OKOK",value.toString())
                val documentSnapshot: DocumentSnapshot = value

                textView.text = documentSnapshot.getString("userEmail")


            }
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
                    Glide.with(applicationContext).load(uri).into(imageView)


            }
        }

        setupView()

    }



    private fun closeFAB() {
       closeAnimation=AnimationUtils.loadAnimation(this,R.anim.close)
        mOmr.animation = closeAnimation
        mnotes.animation = closeAnimation
        omrText.visibility = View.GONE
        notesTaxt.visibility = View.GONE
    }

    private fun openFAB() {
        openAnimation=AnimationUtils.loadAnimation(this,R.anim.open)
        mOmr.animation = openAnimation
        mnotes.animation = openAnimation
        omrText.visibility = View.VISIBLE
        notesTaxt.visibility = View.VISIBLE

    }

    private fun setupView() {
        setupDrawLayout()
    }

    private fun setupDrawLayout() {
        setSupportActionBar(topAppBar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayouts, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(it: MenuItem): Boolean {

        when (it.itemId) {
            R.id.omr -> {
                // Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,OmrOption::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_follow -> {
               // Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,FollowUs::class.java)
                startActivity(intent)
                true
            }
            R.id.nav_rate_us -> {
                Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_profile -> {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
                //Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_logout -> {
                val  builder=AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("Are you sure want to Logout? ")
               
                builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    finish()
                    Toast.makeText(this, "logout success", Toast.LENGTH_SHORT).show()

                }
                builder.setNegativeButton("No") { _: DialogInterface, i: Int ->

                }
                builder.show()
//                FirebaseAuth.getInstance().signOut()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//                Toast.makeText(this, "logout success", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
        return false
    }
    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}