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

        val textView = findViewById<TextView>(R.id.bookTextView)
        val backButton = findViewById<Button>(R.id.back_button)
        val bookName = intent.getStringExtra("BOOK_NAME")

        if(bookName == FbParser.createDoc(this, R.raw.grig).getElementsByTagName("book-title").item(0).textContent) {
            val doc = FbParser.createDoc(this, R.raw.grig)
            textView.append(doc.getElementsByTagName("body").item(0).textContent)
        }
        else if(bookName == FbParser.createDoc(this, R.raw.warhammer).getElementsByTagName("book-title").item(0).textContent){
            val doc = FbParser.createDoc(this, R.raw.warhammer)
            textView.append(doc.getElementsByTagName("body").item(0).textContent)
        }
        else if(bookName == FbParser.createDoc(this, R.raw.gardar).getElementsByTagName("book-title").item(0).textContent){
            val doc = FbParser.createDoc(this, R.raw.gardar)
            textView.append(doc.getElementsByTagName("body").item(0).textContent)
        }
        else if(bookName == FbParser.createDoc(this, R.raw.lavcraft).getElementsByTagName("book-title").item(0).textContent){
            val doc = FbParser.createDoc(this, R.raw.lavcraft)
            textView.append(doc.getElementsByTagName("body").item(0).textContent)
        }

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}