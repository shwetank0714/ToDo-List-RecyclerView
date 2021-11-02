package com.example.todolistrecyclerview

import Adapter.RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.StringBuilder

class Item(val itemText: String, val itemCheckBox: CheckBox)

class MainActivity : AppCompatActivity() {

    private val taskItems : ArrayList<Item> = ArrayList()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createButton = findViewById<Button>(R.id.createTaskButton)
        val deleteButton = findViewById<Button>(R.id.deleteTaskButton)
        val editTask = findViewById<EditText>(R.id.editTask)


        //customCard layout Id's
        val checkBoxTv = findViewById<CheckBox>(R.id.checkBoxTv)
        //------------------


        // Handling the recyclerView layout
        val taskRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewId)
        taskRecyclerView.setHasFixedSize(true)
        taskRecyclerView.layoutManager = LinearLayoutManager(this)

        createButton.setOnClickListener {
            if(editTask.text.isEmpty()){
                Toast.makeText(this,"Task Empty",Toast.LENGTH_SHORT).show()
            }
            else{

                val task = Item(editTask.text.toString(),checkBoxTv)
                taskItems.add(task)
                recyclerViewAdapter = RecyclerViewAdapter(taskItems)
                taskRecyclerView.adapter = recyclerViewAdapter
                editTask.text.clear()
            }
        }
        deleteButton.setOnClickListener {

            for(myData in taskItems){
                if(myData.itemCheckBox.isChecked){
                    taskItems.remove(myData)
                }
            }

            recyclerViewAdapter = RecyclerViewAdapter(taskItems)
            taskRecyclerView.adapter = recyclerViewAdapter
        }

    }
}