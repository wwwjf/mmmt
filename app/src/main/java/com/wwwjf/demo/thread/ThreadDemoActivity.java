package com.wwwjf.demo.thread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.wwwjf.demo.R;

public class ThreadDemoActivity extends AppCompatActivity {

    private ProgressBar progressBarHandler;
    private ProgressBar progressBarAsyncTask;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressBarHandler.setProgress(msg.arg1);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);

        progressBarHandler = findViewById(R.id.pb_thread_handler);
        progressBarAsyncTask = findViewById(R.id.pb_thread_asynctask);

        handlerThread();

        asyncTaskThread();
    }

    //1、handler机制
    // Android中只有主线程能进行UI更新，耗时操作只能在子线程中进行，
    // 在两个线程中要进行数据传递，需要用到handler机制，把子线程的数据传递给主线程。

    // 子线程通过UI线程创建的handler对象，把Message对象发送到消息队列MessageQueue中；
    // 主线程有一个Looper对象，looper从消息队列MessageQueue中循环的取出Message，
    // 通过handler消息分发传回给handler所在的线程UI线程

    private void handlerThread(){
        Thread thread = new Thread(new Runnable() {
            private boolean flag;
            private int i;

            @Override
            public void run() {
                flag = true;
                while (flag){
                    Message msg = Message.obtain();
                    msg.arg1 = i;
                    SystemClock.sleep(100);
                    mHandler.sendMessage(msg);
                    if (i==100){
                        flag = false;
                    }
                    i++;
                }
            }
        });
        thread.start();
    }



    private void asyncTaskThread() {

        UpdateProgressTask task = new UpdateProgressTask();
        task.execute();
    }

    class UpdateProgressTask extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            boolean flag = true;
            int i = 0;
            while (flag){
                SystemClock.sleep(100);
                publishProgress(i);
                if (i==100){
                    flag = false;
                }
                i++;

            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarAsyncTask.setProgress(values[0]);
        }
    }
}
