package com.wwwjf.demo.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.wwwjf.demo.R;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GreendaoActivity extends AppCompatActivity {

    @BindView(R.id.textView_activity_data)
    TextView mTextViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);

        ButterKnife.bind(this);

        insertUser();

        readUser();
    }

    private void readUser() {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(this).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> userQueryBuilder = userDao.queryBuilder();
        List<User> list = userQueryBuilder.list();
        StringBuilder sbData = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            Log.e("GreenDaoDemo", "readUser: user:"+user.getId()+","+user.getName());
            sbData.append("id=").append(user.getId())
                    .append(",name=").append(user.getName()).append("\n");
        }
        mTextViewData.setText(sbData.toString());
    }

    private void insertUser() {
        DaoMaster daoMaster = new DaoMaster(DBManager.getInstance(this).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        User user = new User();
        user.setName("wengjf");
        userDao.insert(user);
    }
}
