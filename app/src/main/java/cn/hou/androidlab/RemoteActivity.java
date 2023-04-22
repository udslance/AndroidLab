package cn.hou.androidlab;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import cn.hou.commonutil.NullUtils;

/**
 * @author H
 */
public class RemoteActivity extends AppCompatActivity {
    private static final String TAG = "RemoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "call onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        initActionBar();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (!NullUtils.isNull(actionBar)) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(cn.hou.recyclerview.R.drawable.ic_back_button);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}