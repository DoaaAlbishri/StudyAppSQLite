package com.example.studyappsqlite

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerViewAdapter(private val words: ArrayList<Note>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    var ctx: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        ctx=parent.getContext();
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val word=words[position]

        holder.itemView.apply{
            tv.text=word.title
            tv2.text=word.More
            editBtn.setOnClickListener {
                if(word.type == "android") {
                    val obj = Android()
                    obj.update(word.title)
                }else{
                    val obj = Kotlin()
                  //  obj.update(word.title)
                }
            }
            delBtn.setOnClickListener {
                if(word.type == "android") {
                    val obj = Android()
                 //   obj.delete(word.title)
                }else{
                    val obj = Kotlin()
                 //    obj.delete(word.title)
                }
            }
        }


        holder.itemView.setOnClickListener {
            println("hello world")
            // first we create a variable to hold an AlertDialog builder
            val dialogBuilder = AlertDialog.Builder(ctx)
            // then we set up the input
            //val input = EditText(this)
            // here we set the message of our alert dialog
            dialogBuilder.setMessage("${word.des}")
                // negative button text and action
                .setNegativeButton("OK", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("$word")
            // add the Edit Text
           // alert.setView(input)
            // show alert dialog
            alert.show()
        }
    }

    override fun getItemCount(): Int =words.size

}