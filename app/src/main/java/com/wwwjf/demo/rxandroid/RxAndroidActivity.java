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

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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

        getAppInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppInfoEntity>() {
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
        });
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
