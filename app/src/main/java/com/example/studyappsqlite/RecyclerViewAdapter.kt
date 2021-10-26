package com.example.studyappsqlite

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerViewAdapter(private val c : Context ,private val words: ArrayList<Note>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    lateinit var dbhlr : DBHlr2

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
        dbhlr = DBHlr2(c)
        holder.itemView.apply{
            tv.text=word.title
            tv2.text=word.More
            editBtn.setOnClickListener {
                if(c is Android) {
                    c.update(word.title,word.More,word.des)
                }else if (c is Kotlin){
                    c.update(word.title,word.More,word.des)
                }
            }
            delBtn.setOnClickListener {
                if(c is Android) {
                   //dbhlr.delete("android",word.title)
                    c.delete("android",word.title)
                }else if (c is Kotlin){
                    //dbhlr.delete("kotlin",word.title)
                    c.delete("kotlin",word.title)
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
            alert.setTitle("${word.title}")
            // add the Edit Text
           // alert.setView(input)
            // show alert dialog
            alert.show()
        }
    }

    override fun getItemCount(): Int =words.size

}