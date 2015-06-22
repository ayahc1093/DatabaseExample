package com.example.mcberliner.databaseexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DBAdapter(this);

        dbAdapter.open();
        Cursor cursor = dbAdapter.getAll();

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            int id;
            String name;
            String email;
            Employee employee;

            do {
                id = cursor.getInt(cursor.getColumnIndex(DBAdapter.C_ID));
                name = cursor.getString(cursor.getColumnIndex(DBAdapter.C_NAME));
                email = cursor.getString(cursor.getColumnIndex(DBAdapter.C_EMAIL));

                employee = new Employee(id, name, email);

                Toast.makeText(this, employee.toString(), Toast.LENGTH_SHORT).show();
            } while (cursor.moveToNext());
        }
        dbAdapter.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
