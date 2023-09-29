package com.example.localdatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val database_name="VeriTabanim"
val table_name="Kullanicilar"
val col_name="adisoyadi"
val col_yas="yas"
val col_id="id"

class DatabaseHelper (var context: Context):SQLiteOpenHelper(context,
database_name,null,1) {


    override fun onCreate(db: SQLiteDatabase?) {

        var createTable=" CREATE TABLE "+ table_name+"("+
                col_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_name+" VARCHAR(256), "+
                col_yas+" INTEGER )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(kullanici: Kullanici) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_name, kullanici.adSoyad)
        cv.put(col_yas, kullanici.yas)

        var sonuc = db.insert(table_name, null, cv)

        if (sonuc == (-1).toLong()) {
            Toast.makeText(context, "HATALI", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Başarılı", Toast.LENGTH_LONG).show()
        }
    }



}