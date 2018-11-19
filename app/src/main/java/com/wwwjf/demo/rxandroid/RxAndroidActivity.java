package com.wwwjf.demo.rxandroid;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.wwwjf.demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RxAndroidActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = RxAndroidActivity.class.getSimpleName();

    @BindView(R.id.swipeRefreshLayout_rxAndroid)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recyclerView_rxaAndroid)
    RecyclerView mRecyclerView;

    private List<AppInfoEntity> mDataList;
    AppInfoAdapter mAppInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid);
        ButterKnife.bind(this);
        mDataList = new ArrayList<>();
        mAppInfoAdapter = new AppInfoAdapter(mDataList);
        mRecyclerView.setAdapter(mAppInfoAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSwipeRefreshLayout.setOnRefreshListener(this);

        initData();
    }

    private void initData() {

        /*getAppInfo().toSortedList().subscribe(new SingleObserver<List<AppInfoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onSuccess(List<AppInfoEntity> appInfoEntities) {
                Log.e(TAG, "onSuccess:========== " + appInfoEntities.size());
                Log.e(TAG, "subscribe: thread  " + Thread.currentThread().getName());
                mDataList.clear();
                mDataList.addAll(appInfoEntities);
                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(RxAndroidActivity.this, "查询出错了", Toast.LENGTH_SHORT).show();
            }
        });*/

        /*getAppInfo().subscribe(new Observer<AppInfoEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDataList.clear();
                mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onNext(AppInfoEntity appInfoEntity) {
                mDataList.add(appInfoEntity);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(RxAndroidActivity.this, "查询出错了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                mSwipeRefreshLayout.setRefreshing(false);
                mAppInfoAdapter.notifyDataSetChanged();
                Toast.makeText(RxAndroidActivity.this, "查询完成,size="+mDataList.size(), Toast.LENGTH_SHORT).show();
            }
        });*/

        getAppInfo2().subscribe(new Observer<List<AppInfoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: =======");
                mDataList.clear();
                mSwipeRefreshLayout.setRefreshing(true);

            }

            @Override
            public void onNext(List<AppInfoEntity> appInfoEntities) {
                mDataList.addAll(appInfoEntities);
                Log.e(TAG, "onNext: =======");

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: =======");
                mSwipeRefreshLayout.setRefreshing(false);
                mAppInfoAdapter.notifyDataSetChanged();
                Toast.makeText(RxAndroidActivity.this, "查询完成2，size="+mDataList.size(), Toast.LENGTH_SHORT).show();
            }
        });

//        mapFunc();
        funcTimer();
//        funcZip();
    }

    private void mapFunc() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onNext(300);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                Toast.makeText(RxAndroidActivity.this, "Integer类型转换为 String类型 "+integer, Toast.LENGTH_SHORT).show();
                return "Integer类型转换为 String类型 "+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: s="+s);
            }
        });
    }

    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }

    /**
     *倒计时
     */
    private void funcTimer(){
        //隔一秒发一次，到120结束
        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "onNext: "+(120-aLong));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ====");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: 计时完成");
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void funcZip(){
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "subscribe: +++100");
                emitter.onNext(100);
                Log.e(TAG, "subscribe: +++200");
                emitter.onNext(200);
                Log.e(TAG, "subscribe: +++300");
                emitter.onNext(300);
                Log.e(TAG, "subscribe: +++400");
                emitter.onNext(400);
                Log.e(TAG, "subscribe: +++400");
                emitter.onNext(400);
                Log.e(TAG, "subscribe: +++onComplete1");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "subscribe: ---A");
                emitter.onNext("A");
                Log.e(TAG, "subscribe: ---B");
                emitter.onNext("B");
                Log.e(TAG, "subscribe: ---C");
                emitter.onNext("C");
                Log.e(TAG, "subscribe: ---D");
                emitter.onNext("D");
                Log.e(TAG, "subscribe: ---E");
                emitter.onNext("E");
                Log.e(TAG, "subscribe: ---onComplete2");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer+s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "~~~onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "~~~onNext: s="+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "~~~onComplete");
            }
        });
    }


    /**
     * @return
     */
    private Observable<AppInfoEntity> getAppInfo() {
        return Observable.create(new ObservableOnSubscribe<AppInfoEntity>() {
            @Override
            public void subscribe(ObservableEmitter<AppInfoEntity> emitter) throws Exception {
                List<AppInfoEntity> list = new ArrayList<>();
                Intent intent = new Intent(Intent.ACTION_MAIN, null);
                List<PackageInfo> installedList = getApplication().getPackageManager().getInstalledPackages(0);
                Log.e(TAG, "subscribe: thread  "+Thread.currentThread().getName());
                for (PackageInfo packageInfo : installedList) {
                    AppInfoEntity appInfoEntity = new AppInfoEntity();
                    appInfoEntity.setName(packageInfo.packageName);
                    appInfoEntity.setIcon(packageInfo.applicationInfo.loadIcon(getApplication().getPackageManager()));
                    list.add(appInfoEntity);
                    emitter.onNext(appInfoEntity);
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())//子线程中执行
                .observeOn(AndroidSchedulers.mainThread());//UI线程中更新
    }
    private Observable<List<AppInfoEntity>> getAppInfo2() {
        return Observable.create(new ObservableOnSubscribe<List<AppInfoEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<AppInfoEntity>> emitter) throws Exception {
                List<AppInfoEntity> list = new ArrayList<>();
                Intent intent = new Intent(Intent.ACTION_MAIN, null);
                List<PackageInfo> installedList = getApplication().getPackageManager().getInstalledPackages(0);
                Log.e(TAG, "subscribe: thread  "+Thread.currentThread().getName());
                for (PackageInfo packageInfo : installedList) {
                    AppInfoEntity appInfoEntity = new AppInfoEntity();
                    appInfoEntity.setName(packageInfo.packageName);
                    appInfoEntity.setIcon(packageInfo.applicationInfo.loadIcon(getApplication().getPackageManager()));
                    list.add(appInfoEntity);
                }
                emitter.onNext(list);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())//子线程中执行
                .observeOn(AndroidSchedulers.mainThread());//UI线程中更新
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
