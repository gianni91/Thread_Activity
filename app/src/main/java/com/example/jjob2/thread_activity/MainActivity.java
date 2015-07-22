package com.example.jjob2.thread_activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public static ProgressBar progressbar;
    public static File fileDir;
    public static List mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("jj", "In the onCreate function");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileDir = this.getFilesDir();
        mainList = new ArrayList<String> ( ) ;

        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        progressbar.setMax(100);
    }

    public void createFile(View myView) {

        fileWrite writefile = new fileWrite();
        Thread t2 = new Thread(writefile);

        t2.start();
    }

    public void readFile(View myView)
    {
        FileRead readfile = new FileRead();
        Thread t1 = new Thread(readfile);

        t1.start();

        try {
           // t1.join();
            ListView myListView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainList);
            myListView.setAdapter(myAdapter);
        } catch (Exception e) {
            Log.e("jj","Failure in readFile");;
        }
    }

    public void clearFile(View myView)
    {
        Log.i("jj","In the clearFile function");
        ListView myListView = (ListView)findViewById(R.id.listView);
        ArrayList<String> myList = new ArrayList<String> ( ) ;

        String line = "";

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList);
        myListView.setAdapter(myAdapter);

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
