package com.example.bookreader.models

import android.graphics.Bitmap
import android.media.Image
import java.io.File

class Book(_title: String, _author: String, _cover: Bitmap, _resourceId: Int ) {
    internal var title: String
    internal var author: String
    internal var cover: Bitmap
    internal var resourceId: Int
    init {
        title = _title
        author = _author
        cover = _cover
        resourceId = _resourceId
    }
}