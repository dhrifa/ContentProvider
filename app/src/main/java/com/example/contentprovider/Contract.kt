package com.example.contentprovider

import android.net.Uri

class Contract {
    private fun Contract() {}



    companion object{
       const val AUTHORITY = "com.android.example.minimalistcontentprovider.provider"
        const val CONTENT_PATH = "words"
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$CONTENT_PATH")
        const val ALL_ITEMS = -2
        const val WORD_ID = "id"
        const val SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.provider.words"
        const val MULTIPLE_RECORD_MIME_TYPE =
            "vnd.android.cursor.dir/vnd.com.example.provider.words"
    }
}
