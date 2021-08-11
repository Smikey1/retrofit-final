package com.kiran.retrofitstarterbatch26.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.adapter.StudentAdapter
import com.kiran.retrofitstarterbatch26.ui.model.Student
import com.kiran.retrofitstarterbatch26.ui.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // here i am going to create a view
        val view:View = inflater.inflate(R.layout.fragment_home,container,false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recycleView)
        val btnFetch:Button=view.findViewById(R.id.btnFetch)
        val btnAdd:Button=view.findViewById(R.id.btnAdd)

        btnFetch.setOnClickListener {
            CoroutineScope(IO).launch {
                val repository:StudentRepository= StudentRepository()
                val response=repository.fetchAllStudent()
                if(response.success==true){
                    withContext(Main){
                        val studentList=response.data!!
                        val adapter = StudentAdapter(studentList,requireContext())
                        recyclerView.layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.adapter=adapter
                    }
                }
            }
        }

        btnAdd.setOnClickListener {
            val fragment = requireFragmentManager().beginTransaction()
            fragment.replace(R.id.renderAnyFragment,AddStudentFragment())
            fragment.addToBackStack("home_fragment")
            fragment.commit()
        }












        return  view
    }
}