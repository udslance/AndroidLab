package cn.hou.androidlab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.hou.recyclerview.RecyclerActivity;

/**
 * MainActivity
 *
 * @author H
 * @since 2023-04-15
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    private Button mButtonToRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonToRecyclerView = findViewById(R.id.button_to_RecyclerViewLab);
        mButtonToRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_to_RecyclerViewLab:
                Log.i(TAG, "clicked R.id.button_to_RecyclerViewLab");
                intentToRecyclerView();
                break;
            default:
                Log.w(TAG, "Unknown button clicked");
                break;
        }
    }

    private void intentToRecyclerView() {
        Intent intentToRecyclerView = new Intent();
        intentToRecyclerView.setClass(MainActivity.this, RecyclerActivity.class);
        startActivity(intentToRecyclerView);
    }
}

