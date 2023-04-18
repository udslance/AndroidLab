package cn.hou.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import cn.hou.commonutil.NullUtils;

/**
 * RecyclerActivity
 *
 * @author H
 * @since 2023-04-15
 */
public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RecyclerActivity";

    private final List<DeviceInfo> mSelectedDeviceList = new LinkedList<>();

    private RecyclerView mSelectedRecyclerView;

    private SelectListAdapter mSelectListAdapter;

    private DefaultItemAnimator mDefaultItemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_recycler);
        setTitle(R.string.title_recyclerview);
        initButtonArea();
        initActionBar();
        prepareAnimator();
        initSelectedArea();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (!NullUtils.isNull(actionBar)) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_button);
        }
    }

    private void initButtonArea() {
        Button btnAddPhone = findViewById(R.id.btn_add_phone);
        btnAddPhone.setOnClickListener(this);
        Button btnRemovePhone = findViewById(R.id.btn_remove_phone);
        btnRemovePhone.setOnClickListener(this);

        Button btnAddTablet = findViewById(R.id.btn_add_tablet);
        btnAddTablet.setOnClickListener(this);
        Button btnRemoveTablet = findViewById(R.id.btn_remove_tablet);
        btnRemoveTablet.setOnClickListener(this);

        Button btnAddWatch = findViewById(R.id.btn_add_watch);
        btnAddWatch.setOnClickListener(this);
        Button btnRemoveWatch = findViewById(R.id.btn_remove_watch);
        btnRemoveWatch.setOnClickListener(this);
    }

    private void prepareAnimator() {
        mDefaultItemAnimator = new DefaultItemAnimator();
        mDefaultItemAnimator.setAddDuration(500);
        mDefaultItemAnimator.setRemoveDuration(500);
    }

    private void initSelectedArea() {
        mSelectedRecyclerView = findViewById(R.id.selected_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mSelectedRecyclerView.setLayoutManager(layoutManager);
        mSelectListAdapter = new SelectListAdapter(mSelectedDeviceList);
        mSelectedRecyclerView.setAdapter(mSelectListAdapter);
        mSelectedRecyclerView.setItemAnimator(mDefaultItemAnimator);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_phone) {
            mSelectedDeviceList.add(DeviceSupplier.getRandomPhone());
            mSelectListAdapter.notifyItemInserted(mSelectListAdapter.getItemCount());
        } else {
            Log.w(TAG, "unknown button clicked");
        }
    }
}