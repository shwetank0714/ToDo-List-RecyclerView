package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.todolistrecyclerview.Item
import com.example.todolistrecyclerview.R

class RecyclerViewAdapter(private val listItems: ArrayList<Item>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Flow of recyclerView: getItemCount -> onCreate() -> ViewHolder() -> onBindViewHolder
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val taskTextView = itemView.findViewById<TextView>(R.id.taskView)!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.taskTextView.text = listItems[position].itemText
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}