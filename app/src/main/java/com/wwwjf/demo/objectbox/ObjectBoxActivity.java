package com.wwwjf.demo.objectbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wwwjf.demo.R;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.rx.RxQuery;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ObjectBoxActivity extends AppCompatActivity {

    public static final String TAG = ObjectBoxActivity.class.getSimpleName();
    private Box<ParamPayType> paramPayTypeBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_box);

        ParamPayType paramPayType = new ParamPayType();
        paramPayType.setCode("86-" + new Date().getTime());
        paramPayType.setName("china-" + new Date().getTime());

        paramPayTypeBox = ObjectBoxManager.get().boxFor(ParamPayType.class);

        paramPayTypeBox.put(paramPayType);

        List<ParamPayType> list = paramPayTypeBox.getAll();
        Log.e(TAG, "============onCreate: " + list.size());

        for (ParamPayType payType : list) {
            Log.e(TAG, "============onCreate: code=" + payType.getCode() + ",name=" + payType.getName());

        }

        Disposable disposable = getPaywayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ParamPayType>>() {
                    @Override
                    public void accept(List<ParamPayType> paramPayTypes) throws Exception {
                        for (ParamPayType payType : paramPayTypes) {
                            Log.e(TAG, "accept========onCreate: code=" + payType.getCode() + ",name=" + payType.getName());

                        }
                    }
                });
    }

    private Observable<List<ParamPayType>> getPaywayList() {
        Query<ParamPayType> query = paramPayTypeBox.query()
                .order(ParamPayType_.code)
                .build();
        return RxQuery.observable(query);
    }
}
