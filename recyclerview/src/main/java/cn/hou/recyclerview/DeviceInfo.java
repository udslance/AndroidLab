package cn.hou.recyclerview;

import android.util.Log;

import cn.hou.commonutil.ConstantUtils;

/**
 * DeviceInfo
 *
 * @author: Hou
 * @since: 2023-04-15 23:26
 **/
public class DeviceInfo {
    private static final String TAG = "DeviceInfo";

    private String mName;

    private int mIntType;

    private int mDeivceIcon;

    private String mID;

    public DeviceInfo(String name, int intType, String id) {
        mName = name;
        mIntType = intType;
        mID = id;
        initDeivceIcon();
    }

    private void initDeivceIcon() {
        switch (mIntType) {
            case ConstantUtils.DEVICETYPE_PHONE:
                mDeivceIcon = R.drawable.ic_phone;
                break;
            case ConstantUtils.DEVICETYPE_TABLET:
                mDeivceIcon = R.drawable.ic_tablet;
                break;
            case ConstantUtils.DEVICETYPE_WATCH:
                mDeivceIcon = R.drawable.ic_watch;
                break;
            default:
                Log.w(TAG, "unknown device int type");
                break;
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIntType() {
        return mIntType;
    }

    public void setIntType(int intType) {
        mIntType = intType;
    }

    public int getDeivceIcon() {
        return mDeivceIcon;
    }

    public void setDeivceIcon(int deivceIcon) {
        mDeivceIcon = deivceIcon;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }
}

