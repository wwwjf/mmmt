package com.wwwjf.demo.thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.wwwjf.demo.R;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadDemoActivity extends AppCompatActivity {

    private static final String TAG = ThreadDemoActivity.class.getSimpleName();
    private ProgressBar progressBarHandler;
    private ProgressBar progressBarAsyncTask;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e(TAG, "handleMessage: msg.arg1="+msg.arg1);
            progressBarHandler.setProgress(msg.arg1);
        }
    };
    private UpdateProgressHandler mUpdateProgressHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);

        progressBarHandler = findViewById(R.id.pb_thread_handler);
        progressBarAsyncTask = findViewById(R.id.pb_thread_asynctask);

        mUpdateProgressHandler = new UpdateProgressHandler(this);

        handlerThread();

        asyncTaskThread();

        executorServiceThread();
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
                    Message msg = mUpdateProgressHandler.obtainMessage();
                    msg.arg1 = i;
                    SystemClock.sleep(1000);
                    mUpdateProgressHandler.sendMessage(msg);
                    if (i==100){
                        flag = false;
                    }
                    i++;
                }
            }
        });
        thread.start();
    }


    private void updateProgressView(int progress){
        Log.e(TAG, "updateProgressView: progress="+progress);
        progressBarHandler.setProgress(progress);
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

    static class UpdateProgressHandler extends Handler{
        WeakReference<Activity> mWeakReference;
        public UpdateProgressHandler(Activity activity){
            mWeakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ThreadDemoActivity activity = (ThreadDemoActivity) mWeakReference.get();
            if (activity == null){
                Log.e(TAG, "handleMessage: activity == null");
                return;
            }
            if (activity.isFinishing()){
                Log.e(TAG, "handleMessage: activity.isFinishing()");
                removeCallbacksAndMessages(null);
                return;
            }
            activity.updateProgressView(msg.arg1);
        }
    }


    // ExecutorService
    // newSingleThreadExecutor 单线程的线程池
    // newFixedThreadPool 固定大小的线程池，没提交一个任务，创建一个线程，直到最大
    // newCachedThreadPool 可变尺寸大小的线程池，如果60s不执行任务的线程会被回收
    // newScheduledThreadPool 延时执行或定时执行的线程池
    private void executorServiceThread() {

        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            threadPool2.execute(new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, "run: " + Thread.currentThread().getName());
                    SystemClock.sleep(1000);
                }
            });
        }

        ExecutorService threadPool3 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run: " + Thread.currentThread().getName());
            }
        },1, TimeUnit.SECONDS);
    }
}
