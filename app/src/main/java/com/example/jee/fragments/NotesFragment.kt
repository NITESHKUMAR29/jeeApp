package com.example.jee.fragments

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jee.InsertNotes
import com.example.jee.R
import com.example.jee.adapters.NotesAdapter
import com.example.jee.databinding.FragmentBlankBinding
import com.example.jee.databinding.FragmentNotesBinding
import com.example.jee.entities.NotesModel
import com.example.jee.viewModels.NotesViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_notes.*
//import kotlinx.android.synthetic.main.activity_notes.addNotes
//import kotlinx.android.synthetic.main.activity_notes.hTol
//import kotlinx.android.synthetic.main.activity_notes.high
//import kotlinx.android.synthetic.main.activity_notes.lToh
//import kotlinx.android.synthetic.main.activity_notes.low
//import kotlinx.android.synthetic.main.activity_notes.nFilter
//import kotlinx.android.synthetic.main.activity_notes.noFilter
//import kotlinx.android.synthetic.main.activity_notes.notesRecyclerView
import kotlinx.android.synthetic.main.fragment_notes.*


class NotesFragment : Fragment() {


    lateinit var viewModel: NotesViewModel
    lateinit var display:ArrayList<NotesViewModel>
    lateinit var notesAdapter: Adapter
    lateinit var list: ArrayList<NotesModel>

    private lateinit var binding: FragmentNotesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
        ).get(NotesViewModel(requireActivity().application)::class.java)



        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notes, container, false)

        return binding.root

    }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        with(binding){
            binding.noFilter.setBackgroundResource(R.drawable.select_filter)



            nFilter.setOnClickListener {
                loadData(1)
                noFilter.setBackgroundResource(R.drawable.select_filter)
                high.setBackgroundResource(0)
                low.setBackgroundResource(0)
            }

            hTol.setOnClickListener {
                loadData(2)
                noFilter.setBackgroundResource(0)
                high.setBackgroundResource(R.drawable.select_filter)
                low.setBackgroundResource(0)
            }
            lToh.setOnClickListener {
                loadData(3)
                noFilter.setBackgroundResource(0)
                high.setBackgroundResource(0)
                low.setBackgroundResource(R.drawable.select_filter)
            }

            list= ArrayList()



            addNotes.setOnClickListener {


                Toast.makeText(requireContext(),"clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), InsertNotes::class.java)
                startActivity(intent)
            }
            viewModel.allNotes.observe(requireActivity(), Observer {list->

                val  notesAdapter= NotesAdapter(list as ArrayList<NotesModel>,requireContext(), Application())
                notesRecyclerView.adapter=notesAdapter
                notesRecyclerView.hasFixedSize()
                notesRecyclerView.layoutManager= GridLayoutManager(requireContext(),2)


            })


        }

        }


    private fun loadData(i: Int) {

        if(i==1){
            viewModel.allNotes.observe(requireActivity(), Observer {list->

                val  notesAdapter= NotesAdapter(list as ArrayList<NotesModel>,requireContext(), Application())
               binding. notesRecyclerView.adapter=notesAdapter
                binding. notesRecyclerView.hasFixedSize()
                binding.notesRecyclerView.layoutManager= GridLayoutManager(requireContext(),2)


            })
        }
        if(i==2){
            viewModel.highToLow.observe(requireActivity(), Observer {list->

                val  notesAdapter= NotesAdapter(list as ArrayList<NotesModel>,requireContext(), Application())
                binding. notesRecyclerView.adapter=notesAdapter
                binding.notesRecyclerView.hasFixedSize()
                binding.notesRecyclerView.layoutManager= GridLayoutManager(requireContext(),2)


            })
        }
        if(i==3){
            viewModel.lowTohigh.observe(requireActivity(), Observer {list->

                val  notesAdapter= NotesAdapter(list as ArrayList<NotesModel>,requireContext(), Application())
                binding. notesRecyclerView.adapter=notesAdapter
                binding.notesRecyclerView.hasFixedSize()
                binding.notesRecyclerView.layoutManager= GridLayoutManager(requireContext(),2)


            })

        }


    }


}