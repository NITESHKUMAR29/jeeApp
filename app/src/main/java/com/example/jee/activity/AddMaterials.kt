package com.example.jee.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jee.R
import com.example.jee.databinding.ActivityAddMaterialsBinding

class AddMaterials : AppCompatActivity() {

    lateinit var binding:ActivityAddMaterialsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_add_materials)

        with(binding){

        }
    }
}