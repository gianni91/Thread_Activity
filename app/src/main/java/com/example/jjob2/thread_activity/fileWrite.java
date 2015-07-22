package com.example.jjob2.thread_activity;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jjob2 on 7/21/2015.
 */
public class fileWrite implements Runnable {
    public void run () {

        try {
            String nums = "";
            File myFile = new File(MainActivity.fileDir, "myFile.txt");

            FileWriter myWriter = new FileWriter(myFile.getAbsoluteFile());
            BufferedWriter myBWriter = new BufferedWriter(myWriter);

            MainActivity.progressbar.setProgress(0);

            myBWriter.write(nums);
            for (int i = 0; i < 10; i++) {
                myBWriter.write("" + (i + 1) + "\n");
                Thread.sleep(250);

            MainActivity.progressbar.setProgress((i+1)*10);
            }
            myBWriter.close();

        } catch (IOException e) {                  // This exception needed for the Writer?
            Log.e("jj", "Failure to write to the file?");
            e.printStackTrace();
        } catch (InterruptedException e) {        // This exception is needed for Thread.sleep()
            Log.e("jj", "Failure to perform the Thread.sleep() function?");
            e.printStackTrace();
        }

    }
}
