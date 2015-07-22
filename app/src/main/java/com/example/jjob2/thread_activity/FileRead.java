package com.example.jjob2.thread_activity;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by jjob2 on 7/21/2015.
 */
public class FileRead implements Runnable {

    @Override
    public void run() {

        MainActivity.progressbar.setProgress(0);
        Log.i("jj", "In the readFile function");
        try {
            String fileName = MainActivity.fileDir + "/myFile.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            int i = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                MainActivity.mainList.add(line);
                MainActivity.progressbar.setProgress((i+1) * 10);
                Thread.sleep(250);
                i++;
            }
            reader.close();

        } catch (Exception e) {
            Log.e("jj","Error in FileRead");
        }
    }
}
