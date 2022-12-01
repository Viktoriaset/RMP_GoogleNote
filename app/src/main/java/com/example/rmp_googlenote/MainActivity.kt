package com.example.rmp_googlenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCLick_createNote(view: View){
        val newNote = Intent(this@MainActivity, Note::class.java)
        startActivity(newNote)
    }
}