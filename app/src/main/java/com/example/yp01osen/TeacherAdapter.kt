package com.example.yp01osen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView


class TeacherAdapter(private val teachers: List<Teacher>, private val onItemClick: (Teacher, Int) -> Unit) :
RecyclerView.Adapter<TeacherAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvFIO: TextView = itemView.findViewById(R.id.textViewTeacherFIO)
        val tvSpecialization: TextView = itemView.findViewById(R.id.textViewTeacherSpecialization)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.teacher_list_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var teacher = teachers.get(position)
        holder.tvFIO.append("${teacher.secondName} ${teacher.firstName} ${teacher.thirdName}")
        holder.tvSpecialization.append("${teacher.specialization}")
        holder.itemView.setOnClickListener{
            onItemClick(teacher,position)
        }
    }

    override fun getItemCount(): Int {
        return teachers.count()
    }
}