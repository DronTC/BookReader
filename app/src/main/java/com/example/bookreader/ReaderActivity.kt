package com.example.bookreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView

class ReaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)


        val doc = FbParser.createDoc(this, R.raw.grig)
        val textView = findViewById<TextView>(R.id.bookTextView)
        val backButton = findViewById<Button>(R.id.back_button)

        textView.append(doc.getElementsByTagName("body").item(0).textContent)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}