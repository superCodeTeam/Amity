package com.example.android.amity;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.android.amity.data.AmityContract;
import com.example.android.amity.data.AmityContract.AmityPost;

import com.example.android.amity.data.AmityDbHelper;


public class SetupActivity extends AppCompatActivity {
    private AmityDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new AmityDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        insertPost();

        displayDatabaseInfo();
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the pets database.
     */
    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                AmityPost._ID,
                AmityPost.COLUMN_USERID,
                AmityPost.COLUMN_TITLE,
                AmityPost.COLUMN_CONTENT,
                AmityPost.COLUMN_DATE };

        // Perform a query on the pets table
//        Cursor cursor = db.query(
//                AmityPost.TABLE_NAME,   // The table to query
//                projection,            // The columns to return
//                null,                  // The columns for the WHERE clause
//                null,                  // The values for the WHERE clause
//                null,                  // Don't group the rows
//                null,                  // Don't filter by row groups
//                null);                   // The sort order
//
//   //     Toast.makeText(SetupActivity.this, "display data", Toast.LENGTH_SHORT).show();
//        TextView displayView = (TextView) findViewById(R.id.table);
//
//        try {
//            // Create a header in the Text View that looks like this:
//            //
//            // The pets table contains <number of rows in Cursor> pets.
//            // _id - name - breed - gender - weight
//            //
//            // In the while loop below, iterate through the rows of the cursor and display
//            // the information from each column in this order.
//            displayView.setText("The posts table contains " + cursor.getCount() + " posts.\n\n");
//            displayView.append(AmityPost._ID + " - " +
//                    AmityPost.COLUMN_USERID + " - " +
//                    AmityPost.COLUMN_TITLE + " - " +
//                    AmityPost.COLUMN_CONTENT + " - " +
//                    AmityPost.COLUMN_DATE + "\n");
//
//            // Figure out the index of each column
//            int idColumnIndex = cursor.getColumnIndex(AmityPost._ID);
//            int useridColumnIndex = cursor.getColumnIndex(AmityPost.COLUMN_USERID);
//            int titleColumnIndex = cursor.getColumnIndex(AmityPost.COLUMN_TITLE);
//            int contentColumnIndex = cursor.getColumnIndex(AmityPost.COLUMN_CONTENT);
//            int dateColumnIndex = cursor.getColumnIndex(AmityPost.COLUMN_DATE);
//
//            // Iterate through all the returned rows in the cursor
//            while (cursor.moveToNext()) {
//                // Use that index to extract the String or Int value of the word
//                // at the current row the cursor is on.
//                int currentID = cursor.getInt(idColumnIndex);
//                int currentUserID = cursor.getInt(useridColumnIndex);
//                String currentTitle = cursor.getString(titleColumnIndex);
//                String currentContent = cursor.getString(contentColumnIndex);
//                int currentDate = cursor.getInt(dateColumnIndex);
//                // Display the values from each column of the current row in the cursor in the TextView
//                displayView.append(("\n" + currentID + " - " +
//                        currentUserID + " - " +
//                        currentTitle + " - " +
//                        currentContent + " - " +
//                        currentDate));
//            }
//        } finally {
//            // Always close the cursor when you're done reading from it. This releases all its
//            // resources and makes it invalid.
//            cursor.close();
//        }
    }

    /**
     * Helper method to insert hardcoded pet data into the database. For debugging purposes only.
     */
    private void insertPost() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(AmityPost.COLUMN_USERID, 876);
        values.put(AmityPost.COLUMN_TITLE, "TITLE");
        values.put(AmityPost.COLUMN_CONTENT, "CONTENT");
        values.put(AmityPost.COLUMN_DATE, 12093);
     //   Log.v("group", "putting stuff in database woohoo");
        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        long newRowId = db.insert(AmityPost.TABLE_NAME, null, values);
    }

}
