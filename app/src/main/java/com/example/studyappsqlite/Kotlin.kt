package com.example.studyappsqlite

import android.content.DialogInterface
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Kotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        setTitle("Kotlin Review")
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        var btnAdd = findViewById<Button>(R.id.button3)
        var dbhlr :DBHlr2 = DBHlr2(this)
/*
        dbhlr.savedata("kotlin","What is Kotlin?", "Kotlin is language", "Kotlin is an open-source statically typed programming language developed by JetBrains\nFor more information, see the official documentation: https://kotlinlang.org/")
        dbhlr.savedata("kotlin","val and var", "Variables", "Kotlin requires each variable to be labeled val or var.  Variables labeled with the val keyword are immutable. On the other hand, variables with the var keyword are mutable and can be changed anytime.")
        dbhlr.savedata("kotlin","User Input", "User input in Kotlin is very simple", "User input in Kotlin is very simple.  We simply create a variable that holds the input, then get the user input with readLine()")
        dbhlr.savedata("kotlin","Data Types", "Basic Data Types", "Basic Data Types Integers, Floats, Strings, and Booleans.  For a more comprehensive look at data types, you can refer to the Kotlin Docs: https://kotlinlang.org/docs/basic-types.html")
*/
        btnAdd.setOnClickListener {
            val intent = Intent(this, NewNote::class.java)
            intent.putExtra("kotlin",true)
            startActivity(intent)
        }
        val list = dbhlr.retrive("kotlin")
        val myRv = findViewById<RecyclerView>(R.id.myRv)
        myRv.adapter = RecyclerViewAdapter(list)
        myRv.layoutManager = LinearLayoutManager(this)

    }
}

/*val words = arrayListOf<Note>(
        Note("What is Kotlin?", "Kotlin is language", "Kotlin is an open-source statically typed programming language developed by JetBrains\nFor more information, see the official documentation: https://kotlinlang.org/"),
        Note("val and var", "Variables", "Kotlin requires each variable to be labeled val or var.  Variables labeled with the val keyword are immutable. On the other hand, variables with the var keyword are mutable and can be changed anytime."),
        Note("User Input", "User input in Kotlin is very simple", "User input in Kotlin is very simple.  We simply create a variable that holds the input, then get the user input with readLine()"),
        Note("Data Types", "Basic Data Types", "Basic Data Types Integers, Floats, Strings, and Booleans.  For a more comprehensive look at data types, you can refer to the Kotlin Docs: https://kotlinlang.org/docs/basic-types.html"),
        Note("Basic Operations", "Basic math operations", "Basic math operations : addition, subtraction, multiplication, division, and the modulo operator."),
        Note("If Statements", "Decision making", "If statements are one of the most fundamental aspects of programming. We use if statements to guide our program in the right direction.")
)
 */