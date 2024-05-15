package com.example.bookreader

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bookreader.models.Book

class BookAdapter(context: Context, private val bookList: List<Book>) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return bookList.size
    }

    override fun getItem(position: Int): Any {
        return bookList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false)
        }

        val titleTextView = view!!.findViewById<TextView>(R.id.item_title)
        val authorTextView = view.findViewById<TextView>(R.id.item_author)
        val coverImageView = view.findViewById<ImageView>(R.id.item_image)

        val book = bookList[position]
        titleTextView.text = book.title
        authorTextView.text = book.author
        coverImageView.setImageBitmap(book.cover)

        return view
    }
}