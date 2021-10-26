package com.example.studyappsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewNote : AppCompatActivity() {
    lateinit var edtitle: EditText
    lateinit var edmore: EditText
    lateinit var eddes: EditText
    lateinit var button5: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        edtitle=findViewById(R.id.edtitle)
        edmore=findViewById(R.id.edmore)
        eddes=findViewById(R.id.eddes)
        button5=findViewById(R.id.button5)
        val intent =intent
        val kotlin = intent.getBooleanExtra("kotlin",false)
        var dbhlr :DBHlr2 = DBHlr2(this)
        button5.setOnClickListener {
            if(kotlin){
                var title =edtitle.text.toString()
                var expl =edmore.text.toString()
                var des =eddes.text.toString()
                dbhlr.savedata("kotlin",title,expl,des)
                Toast.makeText(this, "added successfully", Toast.LENGTH_SHORT).show()
            }else{
                var title =edtitle.text.toString()
                var expl =edmore.text.toString()
                var des =eddes.text.toString()
                dbhlr.savedata("android",title,expl,des)
                Toast.makeText(this, "added successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}