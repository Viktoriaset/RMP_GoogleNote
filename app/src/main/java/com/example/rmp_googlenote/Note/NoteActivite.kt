package com.example.rmp_googlenote.Note

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.rmp_googlenote.MainActivity
import com.example.rmp_googlenote.R

class NoteActivite : AppCompatActivity() {
    private lateinit var header : EditText
    private lateinit var body : EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        header =  findViewById(R.id.header)
        body = findViewById(R.id.body)
    }

    fun onClick_backToMenu(view : View){

        var menu = Intent()
            .putExtra("header",  header.text.toString())
            .putExtra("body", body.text.toString())

        setResult(RESULT_OK, menu)
        finish()
    }
}