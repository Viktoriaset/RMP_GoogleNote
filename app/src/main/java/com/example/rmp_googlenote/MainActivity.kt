package com.example.rmp_googlenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rmp_googlenote.Note.NoteActivite
import com.example.rmp_googlenote.Note.NoteAdapter
import com.example.rmp_googlenote.Note.NoteData
import com.example.rmp_googlenote.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val adapter = NoteAdapter()

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            NEW_NOTE_REQUEST_CODE -> {
                if (requestCode == RESULT_OK && data != null){
                    val note = NoteData(data.getStringExtra("header").toString(), data.getStringExtra("body").toString())
                    adapter.addNote(note)
                }
            }
        }
    }


    fun onCLick_createNote(view: View){
        val newNote = Intent(this@MainActivity, NoteActivite::class.java)
        startActivityForResult(newNote, NEW_NOTE_REQUEST_CODE)
    }

    companion object {
        private const val NEW_NOTE_REQUEST_CODE = 1
    }
}