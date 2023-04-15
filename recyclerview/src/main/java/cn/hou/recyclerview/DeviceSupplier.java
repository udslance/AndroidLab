package cn.hou.recyclerview;

import android.util.Log;

import java.util.Random;

import cn.hou.commonutil.ConstantUtils;

/**
 * DeviceSupplier
 *
 * @author: Hou
 * @since: 2023-04-16 00:41
 **/
public class DeviceSupplier {
    private static final String TAG = "DeviceSupplier";

    private static final String[] TABLET_NAMES = {"Galaxy Tab", "iPad", "Nexus 7", "Surface Go", "Fire HD"};

    private static final String[] PHONE_NAMES = {"Pixel", "iPhone", "Galaxy", "Moto", "OnePlus"};

    private static final String[] WATCH_NAMES = {"Samsung Watch", "Apple Watch", "Moto 360", "Fitbit", "Garmin"};

    private static final int ID_LENGTH = 16;

    private static final int NAME_LENGTH = 3;

    private static final Random RANDOM = new Random();

    public static DeviceInfo getRandomTablet() {
        Log.i(TAG, "call getRandomTablet");
        String name = TABLET_NAMES[RANDOM.nextInt(TABLET_NAMES.length)] + getRandomNumericString(NAME_LENGTH);
        int intType = ConstantUtils.DEVICETYPE_TABLET;
        String id = getRandomNumericString(ID_LENGTH);
        return new DeviceInfo(name, intType, id);
    }

    public static DeviceInfo getRandomPhone() {
        Log.i(TAG, "call getRandomPhone");
        String name = PHONE_NAMES[RANDOM.nextInt(TABLET_NAMES.length)] + getRandomNumericString(NAME_LENGTH);
        int intType = ConstantUtils.DEVICETYPE_PHONE;
        String id = getRandomNumericString(ID_LENGTH);
        return new DeviceInfo(name, intType, id);
    }

    public static DeviceInfo getRandomWatch() {
        Log.i(TAG, "call getRandomWatch");
        String name = WATCH_NAMES[RANDOM.nextInt(WATCH_NAMES.length)] + getRandomNumericString(NAME_LENGTH);
        int intType = ConstantUtils.DEVICETYPE_WATCH;
        String id = getRandomNumericString(ID_LENGTH);
        return new DeviceInfo(name, intType, id);
    }

    private static String getRandomNumericString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }
}
