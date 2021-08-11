package com.kiran.retrofitstarterbatch26.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.model.Student

class StudentAdapter(
    val studentList: MutableList<Student>,
    val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvGender: TextView = view.findViewById(R.id.tvGender)
        val profile: ImageView = view.findViewById(R.id.profile)
        val delete: ImageButton = view.findViewById(R.id.ibDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_recycle_view, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.tvName.text = studentList[position].fullname
        holder.tvAge.text = studentList[position].age.toString()
        holder.tvAddress.text = studentList[position].address
        holder.tvGender.text = studentList[position].gender
        if (studentList[position].gender?.lowercase() == "male") {
            holder.profile.setImageResource(R.drawable.male)
        } else {
            holder.profile.setImageResource(R.drawable.female)
        }
        holder.delete.setOnClickListener {
            studentList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

}