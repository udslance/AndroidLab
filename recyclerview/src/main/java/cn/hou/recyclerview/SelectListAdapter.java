package cn.hou.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * SelectListAdapter
 *
 * @author: Hou
 * @since: 2023-04-15 23:23
 **/
public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.ViewHolder> {
    private final List<DeviceInfo> mDeviceInfoList;

    public SelectListAdapter(List<DeviceInfo> devices) {
        mDeviceInfoList = devices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DeviceInfo deviceInfo = mDeviceInfoList.get(position);
        holder.mDeviceNameTextView.setText(deviceInfo.getName());
        holder.mDeviceIcon.setImageResource(deviceInfo.getDeivceIcon());
    }

    @Override
    public int getItemCount() {
        return mDeviceInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mDeviceNameTextView;

        public ImageView mDeviceIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mDeviceNameTextView = itemView.findViewById(R.id.device_name);
            mDeviceIcon = itemView.findViewById(R.id.device_icon);
        }
    }
}
