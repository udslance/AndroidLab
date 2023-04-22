package cn.hou.androidlab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;

import cn.hou.commonutil.NullUtils;
import cn.hou.recyclerview.RecyclerActivity;

/**
 * MainActivity
 *
 * @author H
 * @since 2023-04-15
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    private Button mButtonToRecyc;

    private Button mButtonShowBadge;

    private Button mButtonHideBadge;

    private Switch mShowRemoteSwitch;

    private MenuItem mMenuItem;

    private PopupMenu mPopupMenu;

    private Drawable mIconDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mButtonToRecyc = findViewById(R.id.btn_go_recyc);
        mButtonToRecyc.setOnClickListener(this);

        mButtonShowBadge = findViewById(R.id.btn_show_badge);
        mButtonShowBadge.setOnClickListener(this);

        mButtonHideBadge = findViewById(R.id.btn_hide_badge);
        mButtonHideBadge.setOnClickListener(this);

        mShowRemoteSwitch = findViewById(R.id.switch_show_remote);
        mShowRemoteSwitch.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mMenuItem = menu.findItem(R.id.action_menu);
        mIconDrawable = mMenuItem.getIcon();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // 检查菜单项的 id 是否为 action_settings
        if (id == R.id.action_menu) {
            if (NullUtils.isNull(mPopupMenu)) {
                initPopupMenu();
            }
            // 显示弹出式菜单
            mPopupMenu.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initPopupMenu() {
        // 创建 PopupMenu 对象，并设置其显示位置和参照视图
        mPopupMenu = new PopupMenu(this, findViewById(R.id.action_menu));
        MenuInflater inflater = mPopupMenu.getMenuInflater();
        // 加载弹出式菜单的布局文件
        inflater.inflate(R.menu.popup_menu, mPopupMenu.getMenu());

        mPopupMenu.setOnMenuItemClickListener(item -> {
            // 检查菜单项的 id 是否为 action_settings
            switch (item.getItemId()) {
                case R.id.action_diagnosis:
                    return intentToDiagnosis();
                case R.id.action_remote:
                    return intentToRemote();
                case R.id.action_setting:
                    return intentToSettings();
                default:
                    Log.w(TAG, "Unknown menu item");
                    break;
            }
            return false;
        });
    }

    private boolean intentToDiagnosis() {
        Intent intentToDiagnosis = new Intent();
        intentToDiagnosis.setClass(MainActivity.this, DiagnosisActivity.class);
        startActivity(intentToDiagnosis);
        return true;
    }

    private boolean intentToRemote() {
        Intent intentToRemote = new Intent();
        intentToRemote.setClass(MainActivity.this, RemoteActivity.class);
        startActivity(intentToRemote);
        return true;
    }

    private boolean intentToSettings() {
        Intent intentToSetting = new Intent();
        intentToSetting.setClass(MainActivity.this, SettingActivity.class);
        startActivity(intentToSetting);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_go_recyc:
                Log.i(TAG, "clicked R.id.btn_go_recyc");
                intentToRecyclerView();
                break;
            case R.id.btn_show_badge:
                Log.i(TAG, "clicked R.id.btn_show_badge");
                showBadge();
                break;
            case R.id.btn_hide_badge:
                Log.i(TAG, "clicked R.id.btn_hide_badge");
                hideBadge();
                break;
            case R.id.switch_show_remote:
                Log.i(TAG, "clicked R.id.switch_show_remote");
                setShowRemote();
                break;
            default:
                Log.w(TAG, "Unknown button clicked");
                break;
        }
    }

    private void showBadge() {
        // 在菜单项图标上显示一个小红点
        Bitmap canvasBitmap = Bitmap.createBitmap(mIconDrawable.getIntrinsicWidth(),
            mIconDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(canvasBitmap);
        mIconDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        mIconDrawable.draw(canvas);

        Drawable redCircle = ContextCompat.getDrawable(this, R.drawable.red_circle);
        redCircle.setBounds(canvas.getWidth() - redCircle.getIntrinsicWidth(), 0, canvas.getWidth(), redCircle.getIntrinsicHeight());
        redCircle.draw(canvas);

        BitmapDrawable newIcon = new BitmapDrawable(getResources(), canvasBitmap);
        mMenuItem.setIcon(newIcon);
    }

    private void hideBadge() {
        mMenuItem.setIcon(mIconDrawable);
    }

    private void setShowRemote() {
        if (NullUtils.isNull(mPopupMenu)) {
            initPopupMenu();
        }
        MenuItem remoteItem = mPopupMenu.getMenu().findItem(R.id.action_remote);
        remoteItem.setVisible(mShowRemoteSwitch.isChecked());
    }

    private void intentToRecyclerView() {
        Intent intentToRecyclerView = new Intent();
        intentToRecyclerView.setClass(MainActivity.this, RecyclerActivity.class);
        startActivity(intentToRecyclerView);
    }
}

