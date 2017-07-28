package uk.co.mali.flickrtest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by alig2 on 28/07/2017.
 */


public abstract class BaseActivity extends AppCompatActivity {


    BaseActivity(){

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initComponents();
    }

    public abstract int getContentLayout();

    public abstract void initComponents();

}
