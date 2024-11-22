package com.example.yp01osen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdministrationAdapter(private val administration: List<Administration>, private val onItemClick: (Administration, Int) -> Unit) :
    RecyclerView.Adapter<AdministrationAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvFIO: TextView = itemView.findViewById(R.id.textViewAdministrationFIO)
        val tvPost: TextView = itemView.findViewById(R.id.textViewTeacherAdministrationPost)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.administration_list_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var admin = administration.get(position)
        holder.tvFIO.append("${admin.secondName} ${admin.firstName} ${admin.thirdName}")
        holder.tvPost.append("${admin.post}")
        holder.itemView.setOnClickListener {
            onItemClick(admin, position)
        }
    }

    override fun getItemCount(): Int {
        return administration.count()
    }
}