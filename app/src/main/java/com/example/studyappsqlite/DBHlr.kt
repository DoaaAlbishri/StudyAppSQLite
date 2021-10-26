package com.example.studyappsqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlr(context: Context?) : SQLiteOpenHelper(context, "details.db", null, 1) {
    val sql :SQLiteDatabase = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table notes(Title text, Des text, More text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedata(s1: String, s2:String, s3:String){
        val cv = ContentValues()
        cv.put("Title", s1)
        cv.put("More", s2)
        cv.put("Des", s3)
        sql.insert("notes", null, cv)
    }

    @SuppressLint("Range")
    fun retrive() :ArrayList<Note> {
        val list = ArrayList<Note>()
        val cursor: Cursor = sql.rawQuery("select * from notes", null)
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                val title: String = cursor.getString(cursor.getColumnIndex("Title"))
                val des: String = cursor.getString(cursor.getColumnIndex("Des"))
                val explain: String = cursor.getString(cursor.getColumnIndex("More"))
                list.add(Note("",title,explain,des))
                cursor.moveToNext()
            }
        }
        return list
    }

    fun updateTitle(s1 :String , news1 :String){
        val cv = ContentValues()
        cv.put("Title", news1)
        sql.update("notes",  cv, "Title=?", arrayOf(s1))
        }

    fun updateDes(s1 :String , news1 :String){
        val cv = ContentValues()
        cv.put("Des", news1)
        sql.update("notes",  cv, "Des=?", arrayOf(s1))
    }
    fun updateexplain(s1 :String , news1 :String){
        val cv = ContentValues()
        cv.put("More", news1)
        sql.update("notes",  cv, "More=?", arrayOf(s1))
    }

    fun delete(s1 :String){
        sql.delete("notes", "Title=?", arrayOf(s1))
    }
}
