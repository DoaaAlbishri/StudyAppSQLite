package com.example.studyappsqlite

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Android : AppCompatActivity() {
    var list = ArrayList<Note>()
    lateinit var myRv : RecyclerView
    lateinit var dbhlr :DBHlr2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)
        setTitle("Android Review")
        dbhlr = DBHlr2(this)
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        var btnAdd = findViewById<Button>(R.id.button4)
        /*
        dbhlr.savedata("android","Android Studio setup", "Download Android Studio", "Click on \"Download Android Studio\" once the page loads. https://developer.android.com/studio")
        dbhlr.savedata("android","Documentation", "official documentation", "Android Studio Documentation - https://developer.android.com/docs")
        dbhlr.savedata("android","Resource Files", "some resource files in the Project Overview", "colors.xml and themes.xml files. Making changes to these files allows us to set a base color for every UI Element (more on those later) we create. These UI Elements can then be changed individually if we choose to do so.")
         */
        myRv = findViewById<RecyclerView>(R.id.myRv)
        myRv()
        btnAdd.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.add_dialog, null)
            dialogBuilder.setTitle("Alert Dialog")
            dialogBuilder.setView(dialogView)
            val edtitle = dialogView.findViewById<EditText>(R.id.edtitle1)
            val edmore = dialogView.findViewById<EditText>(R.id.edmore1)
            val eddes = dialogView.findViewById<EditText>(R.id.eddes1)
            val tvBtn = dialogView.findViewById<Button>(R.id.button6)
            tvBtn.setOnClickListener {
                if (edtitle.text.isEmpty() || edmore.text.isEmpty() || eddes.text.isEmpty())
                    Toast.makeText(this, "Fill all fields please", Toast.LENGTH_SHORT).show()
                else {
                    var title = edtitle.text.toString()
                    var expl = edmore.text.toString()
                    var des = eddes.text.toString()
                    dbhlr.savedata("android", title, expl, des)
                    Toast.makeText(this, "added successfully", Toast.LENGTH_SHORT).show()
                    //retrieve data and update recycler view
                    myRv()
                }
            }
            dialogBuilder.show()
        }
    }
    fun update(s1:String,s2:String, s3:String){
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.update_dialog, null)
        dialogBuilder.setTitle("Alert Dialog")
        dialogBuilder.setView(dialogView)
        val edtitle = dialogView.findViewById<EditText>(R.id.edtitle2)
        val edmore = dialogView.findViewById<EditText>(R.id.edmore2)
        val eddes = dialogView.findViewById<EditText>(R.id.eddes2)
        val tvBtn = dialogView.findViewById<Button>(R.id.button7)
        tvBtn.setOnClickListener {
            if (edtitle.text.isEmpty() || edmore.text.isEmpty() || eddes.text.isEmpty())
                Toast.makeText(this, "Fill all fields please", Toast.LENGTH_SHORT).show()
            else {
                var title = edtitle.text.toString()
                var expl = edmore.text.toString()
                var des = eddes.text.toString()
                dbhlr.update("android", s1, s2, s3, title, expl, des)
                Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show()
                //retrieve data and update recycler view
                myRv()
            }
        }
        dialogBuilder.show()
    }

    fun delete(type:String , s1:String){
        dbhlr.delete(type,s1)
        println("deleted item")
        //retrieve data and update recycler view
        myRv()
    }

    fun myRv(){
        val list = dbhlr.retrive("android")
        myRv.adapter = RecyclerViewAdapter(this,list)
        myRv.layoutManager = LinearLayoutManager(this)
    }
}






/*val words = arrayListOf<Note>(
        Note("Android Studio setup", "Download Android Studio", "Click on \"Download Android Studio\" once the page loads. https://developer.android.com/studio"),
        Note("Documentation", "official documentation", "Android Studio Documentation - https://developer.android.com/docs"),
        Note("Resource Files", "some resource files in the Project Overview", "colors.xml and themes.xml files. Making changes to these files allows us to set a base color for every UI Element (more on those later) we create. These UI Elements can then be changed individually if we choose to do so."),
        Note("Design View and XML", "XML mode", "Refer to the official documentation if you need help with application design: https://developer.android.com/studio/write/layout-editor"),
        Note("UI Elements", "UI (User Interface) Element", "Explore UI Elements further by customizing them in 'Design' and 'Code' mode."),
        Note("OnClickListener", "Button event", "Once your button is initialized, we can add an OnClickListener with the following code:\"myButton.setOnClickListener { myFuction() }\""
        )
)
 */