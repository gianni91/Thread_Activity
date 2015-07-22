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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public ProgressBar progressbar;// = (ProgressBar) findViewById(R.id.progressBar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("jj", "In the onCreate function");

        //Testing added this for the background thread
       // ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressBar);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        progressbar.setMax(100);

//        createFile();
    }

    //Added, testing
    public void createFile(View myView) {
        Log.i("jj","In the createFile function");
       // System.out.println("Testing the button");

        try {
            // Testing
           // URL url1 = new URL("https://developer.android.com/training/multiple-threads/communicate-ui.html");


            //END-TEST
            //testing again
            //BackgroundThread myT = new BackgroundThread();
            //myT.doInForeground();

            //
            String nums = "";// = "1 2 3 4 5 6 7 8 9 10";
            File myFile = new File(this.getFilesDir(), "myFile.txt");

            FileWriter myWriter = new FileWriter(myFile.getAbsoluteFile());
            BufferedWriter myBWriter = new BufferedWriter(myWriter);

           // ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressBar);

            //
            progressbar.setProgress(0);
            myBWriter.write(nums);
            for (int i = 0; i < 10; i++) {
                myBWriter.write("" + (i + 1) + "\n");
                Thread.sleep(250);
                progressbar.setProgress(i*10);

            }
            myBWriter.close();

        } catch (IOException e) {                  // This exception needed for the Writer?
            Log.e("jj","Failure to write to the file?");
            e.printStackTrace();
        } catch (InterruptedException e) {        // This exception is needed for Thread.sleep()
            Log.e("jj", "Failure to perform the Thread.sleep() function?");
            e.printStackTrace();
        }
    }

    public void readFile(View myView)  //added Wednesday
    {
        /*
        try {
            File myFile = new File(this.getFilesDir(), "myFile.txt");

            FileReader myReader = new FileReader(myFile.getAbsoluteFile());
            BufferedReader myBReader = new BufferedReader(myReader);

//            myBWriter.write(nums);

            char[] words = new char[256];
            for (int i = 0; i < 10; i++) {
                myBReader.read(words);
                Thread.sleep(250);
            }
            myBReader.close();

            String sNumbers = words;
            Log.i("jj",words[0]);

        } catch (Exception e) {
            Log.e("jj","Failure to read the file");
        }
        */

        progressbar.setProgress(0);
        Log.i("jj","In the readFile function");
        try {
            ;
           // BackgroundThread myThread = new BackgroundThread();
            //myThread.doInBackground("test1");
//            myThread.doInForeground();
      //  } catch (Exception e) {
       //     Log.e("jj","Failure to read the file?");
        //}
            //myThread.doInBackground("hi there");


            ListView myListView = (ListView)findViewById(R.id.listView); //added wednesday
            ArrayList<String> myList = new ArrayList<String> ( ) ;


            //TEST-ADDED
            String fileName = this.getFilesDir() + "/myFile.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;


            int i = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                myList.add(line);  //testing (wednes)
                progressbar.setProgress(i * 10);
                Thread.sleep(250);  // added today
                i++;
            }
            progressbar.setProgress(50);

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList); // testing - added wednes
            myListView.setAdapter(myAdapter);

            reader.close();
            //END-TEST-ADD

        } catch (FileNotFoundException e) {
            Log.e("jj","Error reading the file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {   // This was added for the Thread.sleep function?
            Log.e("jj","Thread sleep failed?");
            e.printStackTrace();
        }
    }

    public void clearFile(View myView)  // Added Thursday
    {
        Log.i("jj","In the clearFile function");
        ListView myListView = (ListView)findViewById(R.id.listView);
        ArrayList<String> myList = new ArrayList<String> ( ) ;

        String line = "";

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList); // testing - added wednes
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
