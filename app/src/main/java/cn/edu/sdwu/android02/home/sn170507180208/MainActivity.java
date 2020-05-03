package cn.edu.sdwu.android02.home.sn170507180208;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
    }

    //界面跳转
    public void start1(View view) {
        //界面跳转
        Intent intent = new Intent(this, homework1.class);
        startActivity(intent);

    }
    public void start2(View view) {
        //界面跳转
        Intent intent = new Intent(this, homework2.class);
        startActivity(intent);

    }

}
