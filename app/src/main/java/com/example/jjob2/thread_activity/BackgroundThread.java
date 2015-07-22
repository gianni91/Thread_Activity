package com.example.jjob2.thread_activity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.net.URL;

/**
 * Created by jjob2 on 7/2/2015.
 */
/*
public class BackgroundThread extends AsyncTask<String, Integer, String>
{

    protected String doInBackground(String... params) {
        String result = "";
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("" + i * 2);
                if(i >= 9) {
                    Log.e("jj","An unexpected number was printed");
                }
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("jj","failure in the doInBackground function in MainActivity");
        }

        return result;
    }

    public void doInForeground() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("" + i);
                Thread.sleep(250);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
*/
/*
public class BackgroundThread extends AsyncTask<URL , Integer, Long> {
   //protected Long doInBackground(URL... urls) {
   protected Long doInBackground(Integer... nums) {
       long myNum = 20;
       System.out.println("testing BackgroundThread");
       System.out.println("1");
       return myNum;
   }

    /// ocmment out tihs one
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
            //totalSize += Downloader.downloadFile(urls[i]);
            publishProgress((int) ((i / (float) count) * 100));
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return totalSize;
    }

    protected void onProgressUpdate(Integer... progress) {
        System.out.println("testing on progress update");
       ;// setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        System.out.println("testing onPostExecute");
        ;//showDialog("Downloaded " + result + " bytes");
    }


}
*/