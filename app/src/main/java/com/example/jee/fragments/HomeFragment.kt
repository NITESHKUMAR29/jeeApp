package com.example.jee.fragments

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jee.InsertNotes
import com.example.jee.R
import com.example.jee.adapters.NotesAdapter
import com.example.jee.databinding.FragmentBlankBinding
import com.example.jee.databinding.FragmentNotesBinding
import com.example.jee.entities.NotesModel
import com.example.jee.jeeAdvance.AdvanceMaterial
import com.example.jee.jeeMains.ChoosePdf
import com.example.jee.viewModels.NotesViewModel
import com.example.jee.wbjee.WbjeeMaterial


class BlankFragment : Fragment() {


    lateinit var viewModel: NotesViewModel
    lateinit var display:ArrayList<NotesViewModel>
    lateinit var notesAdapter: Adapter
    lateinit var list: ArrayList<NotesModel>

    private lateinit var binding: FragmentBlankBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


       with(binding){
           neet.setOnClickListener {
            Toast.makeText(requireContext(),"Coming soon",Toast.LENGTH_SHORT).show()
//            val intent=Intent(this, NeetMaterial::class.java)
//            startActivity(intent)
        }
        wbJee.setOnClickListener {
            val intent=Intent(requireContext(), WbjeeMaterial::class.java)
            startActivity(intent)
        }

        jeeAdvance.setOnClickListener {
            val intent=Intent(requireContext(), AdvanceMaterial::class.java)
            startActivity(intent)
        }

        jeeMains.setOnClickListener {
            val intent=Intent(requireContext(), ChoosePdf::class.java)
            startActivity(intent)
        }
       }

    }





}