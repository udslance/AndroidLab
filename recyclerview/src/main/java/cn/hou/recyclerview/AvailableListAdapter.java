package cn.hou.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public class AvailableListAdapter extends RecyclerView.Adapter<AvailableListAdapter.ExpandableViewHolder> {
    private final List<DeviceInfo> mDeviceInfoList;

    public AvailableListAdapter(List<DeviceInfo> devices) {
        mDeviceInfoList = devices;
    }

    @NonNull
    @Override
    public ExpandableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list_item, parent, false);
        return new ExpandableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpandableViewHolder holder, int position) {
        DeviceInfo deviceInfo = mDeviceInfoList.get(position);
        holder.mDeviceNameTextView.setText(deviceInfo.getName());
        holder.mDeviceIcon.setImageResource(deviceInfo.getDeivceIcon());
        holder.mLayout.setOnClickListener(v -> {
            mDeviceInfoList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return mDeviceInfoList.size();
    }

    public static class ExpandableViewHolder extends RecyclerView.ViewHolder {
        public TextView mDeviceNameTextView;

        public ImageView mDeviceIcon;

        public LinearLayout mLayout;

        public ImageView mExpandImage;

        public ExpandableViewHolder(View itemView) {
            super(itemView);
            mDeviceNameTextView = itemView.findViewById(R.id.device_name);
            mDeviceIcon = itemView.findViewById(R.id.device_icon);
            mLayout = itemView.findViewById(R.id.device_list_item);
            mExpandImage = itemView.findViewById(R.id.expand_image);
        }
    }
}
