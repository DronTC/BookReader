package com.example.bookreader.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import com.example.bookreader.BookAdapter
import com.example.bookreader.FbParser
import com.example.bookreader.R
import com.example.bookreader.ReaderActivity

class BooksReadFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_books_read, container, false)

        val bookList = listOf(
            FbParser.Parse(requireContext(), R.raw.grig),
            FbParser.Parse(requireContext(), R.raw.gardar),
            FbParser.Parse(requireContext(), R.raw.warhammer),
            FbParser.Parse(requireContext(), R.raw.lavcraft)
        )

        val adapter = BookAdapter(requireContext(), bookList)
        val listView: ListView = view.findViewById(R.id.listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val textView = view.findViewById<TextView>(R.id.item_title)
            changeActivity(textView.text.toString())
        }

        return view
    }
    private fun changeActivity(name: String){
        val intent = Intent(activity, ReaderActivity::class.java)
        intent.putExtra("BOOK_NAME", name)
        startActivity(intent)
    }
}