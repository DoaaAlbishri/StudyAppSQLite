package com.example.studyappsqlite

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Android : AppCompatActivity() {
    var list = ArrayList<Note>()
    lateinit var myRv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)
        setTitle("Android Review")
        var dbhlr :DBHlr2 = DBHlr2(this)
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        var btnAdd = findViewById<Button>(R.id.button4)
        /*
        dbhlr.savedata("android","Android Studio setup", "Download Android Studio", "Click on \"Download Android Studio\" once the page loads. https://developer.android.com/studio")
        dbhlr.savedata("android","Documentation", "official documentation", "Android Studio Documentation - https://developer.android.com/docs")
        dbhlr.savedata("android","Resource Files", "some resource files in the Project Overview", "colors.xml and themes.xml files. Making changes to these files allows us to set a base color for every UI Element (more on those later) we create. These UI Elements can then be changed individually if we choose to do so.")
         */
        btnAdd.setOnClickListener {
            val intent = Intent(this, NewNote::class.java)
            startActivity(intent)
        }
        list = dbhlr.retrive("android")
        myRv = findViewById<RecyclerView>(R.id.myRv)
        myRv.adapter = RecyclerViewAdapter(this,list)
        myRv.layoutManager = LinearLayoutManager(this)
    }
    fun update(s1:String,s2:String, s3:String){
        //first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // then we set up the input
        val input = EditText(this)
        input.hint="Enter new note"
        // here we set the message of our alert dialog
        //dialogBuilder.setMessage("Update Note")
        // positive button text and action
        dialogBuilder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
            var dbhlr = DBHlr2(this)
            val str = input.text.toString()
        //    dbhlr.update(s1, str)
            println("updated item")
            //retrieve data and update recycler view
        })
                // negative button text and action
                .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, id ->
                })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Update Note")
        // add the Edit Text
        alert.setView(input)
        // show alert dialog
        alert.show()
    }

    fun delete(type:String , s1:String){
        var dbhlr = DBHlr2(this)
        dbhlr.delete(type,s1)
        println("deleted item")
        //retrieve data and update recycler view
        val list = dbhlr.retrive("android")
        myRv.adapter = RecyclerViewAdapter(this,list)
        myRv.layoutManager = LinearLayoutManager(this)
    }

    fun myRv(){
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