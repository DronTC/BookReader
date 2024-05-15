package com.example.bookreader

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import com.example.bookreader.models.Book
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory

class FbParser {
    companion object {
        fun Parse(context: Context, resourceId: Int): Book {
            val firstName: String?
            val middleName: String?
            val lastName: String?

            val doc = createDoc(context, resourceId)

            val title = doc.getElementsByTagName("book-title").item(0).textContent

            firstName = checkOnNull(doc.getElementsByTagName("first-name").item(0))
            middleName = checkOnNull(doc.getElementsByTagName("middle-name").item(0))
            lastName = checkOnNull(doc.getElementsByTagName("last-name").item(0))

            val author = "$firstName $middleName $lastName"
            val base64Cover = doc.getElementsByTagName("binary").item(0).textContent

            val imageBytes = Base64.decode(base64Cover, Base64.DEFAULT)
            val cover = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

            return Book(title, author, cover, resourceId)
        }
        fun createDoc(context: Context, resourceId: Int): Document{
            val inputStream: InputStream = context.resources.openRawResource(resourceId)

            val dbFactory = DocumentBuilderFactory.newInstance()
            val dBuilder = dbFactory.newDocumentBuilder()
            val doc: Document = dBuilder.parse(InputSource(inputStream))
            return doc
        }
        private fun checkOnNull(el: Node?): String?{
            return if(el == null)
                ""
            else
                el.textContent
        }
    }
}