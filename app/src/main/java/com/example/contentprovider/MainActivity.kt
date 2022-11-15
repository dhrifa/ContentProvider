package com.example.contentprovider


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var txtView: TextView
    private lateinit var btnDisplayAll: Button
    private lateinit var btnDisplayFirst: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        txtView = findViewById(R.id.textviewId)
        btnDisplayAll = findViewById(R.id.button_display_all)
        btnDisplayFirst = findViewById(R.id.button_display_first)
    }

    fun onClickDisplayEntries(view: View?) {
        Log.d(TAG, "Yay, I was clicked!")


        // URI That identifies the content provider and the table.
        // URI That identifies the content provider and the table.
        val queryUri = Contract.CONTENT_URI.toString()

        // The columns to return for each row. Setting this to null returns all of them.
        // When there is only one column, as in the case of this example, setting this
        // explicitly is optional, but can be helpful for documentation purposes.

        // The columns to return for each row. Setting this to null returns all of them.
        // When there is only one column, as in the case of this example, setting this
        // explicitly is optional, but can be helpful for documentation purposes.
        val projection = arrayOf(Contract.CONTENT_PATH) // Only get words.


        // Argument clause for the selection criteria for which rows to return.
        // Formatted as an SQL WHERE clause (excluding the WHERE itself).
        // Passing null returns all rows for the given URI.

        // Argument clause for the selection criteria for which rows to return.
        // Formatted as an SQL WHERE clause (excluding the WHERE itself).
        // Passing null returns all rows for the given URI.
        val selectionClause: String?

        // Argument values for the selection criteria.
        // If you include ?s in selection, they are replaced by values from selectionArgs,
        // in the order that they appear.
        // IMPORTANT: It is a best security practice to always separate selection and selectionArgs.

        // Argument values for the selection criteria.
        // If you include ?s in selection, they are replaced by values from selectionArgs,
        // in the order that they appear.
        // IMPORTANT: It is a best security practice to always separate selection and selectionArgs.
        val selectionArgs: Array<String>?

        // The order in which to sort the results.
        // Formatted as an SQL ORDER BY clause (excluding the ORDER BY keyword).
        // Usually ASC or DESC; null requests the default sort order, which could be unordered.

        // The order in which to sort the results.
        // Formatted as an SQL ORDER BY clause (excluding the ORDER BY keyword).
        // Usually ASC or DESC; null requests the default sort order, which could be unordered.
        val sortOrder: String? =
            null // For this example, we accept the order returned by the response.

        when (view!!.id) {
            R.id.button_display_all -> {
                selectionClause = null
                selectionArgs = null
            }
            R.id.button_display_first -> {
                selectionClause = Contract.WORD_ID + " = ?"
                selectionArgs = arrayOf("0")
            }
            else -> {
                selectionClause = null
                selectionArgs = null
            }
        }


        val cursor = contentResolver.query(
            Uri.parse(queryUri), projection, selectionClause,
            selectionArgs, sortOrder
        )

        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                val columnIndex = cursor.getColumnIndex(projection[0])
                do {
                    val word = cursor.getString(columnIndex)
                    txtView.append(
                        """
                    $word
                    
                    """.trimIndent()
                    )
                } while (cursor.moveToNext())
            } else {
                Log.d(TAG, "onClickDisplayEntries " + "No data returned.")
                txtView.append(
                    """
                No data returned.
                
                """.trimIndent()
                )
            }
            cursor.close()
        } else {
            Log.d(TAG, "onClickDisplayEntries " + "Cursor is null.")
            txtView.append(
                """
            Cursor is null.
            
            """.trimIndent()
            )
        }

//        txtView.append("Thus we go! \n");
    }
}