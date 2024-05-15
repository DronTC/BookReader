package com.example.bookreader.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import com.example.bookreader.BookAdapter
import com.example.bookreader.FbParser
import com.example.bookreader.R
import com.example.bookreader.ReaderActivity

class BooksAndDocumentsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_books_and_documents, container, false)

        val bookList = listOf(
            FbParser.Parse(requireContext(), R.raw.grig),
            FbParser.Parse(requireContext(), R.raw.gardar),
            FbParser.Parse(requireContext(), R.raw.warhammer)
        )

        val adapter = BookAdapter(requireContext(), bookList)
        val listView: ListView = view.findViewById(R.id.listView)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()

            val intent = Intent(requireContext(), ReaderActivity::class.java)
            intent.putExtra("selectedItem", selectedItem)
            startActivity(intent)
        }

        return view
    }
}