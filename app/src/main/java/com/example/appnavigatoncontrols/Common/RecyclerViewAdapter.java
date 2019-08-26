package com.example.appnavigatoncontrols.Common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.example.appnavigatoncontrols.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<ScheduleTypeList> scheduleTypeList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView Title;
        public TextView Description;

        public RecyclerViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            Title = itemView.findViewById(R.id.textTitle);
            Description = itemView.findViewById(R.id.textDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RecyclerViewAdapter(ArrayList<ScheduleTypeList> mScheduleTypeList) {
        scheduleTypeList = mScheduleTypeList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheduletype_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(v,mListener);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ScheduleTypeList currentItem = scheduleTypeList.get(position);

        holder.mImageView.setImageResource(currentItem.mImageResource);
        holder.Title.setText(currentItem.Title);
        holder.Description.setText(currentItem.Description);
    }

    @Override
    public int getItemCount() {
        return scheduleTypeList.size();
    }
}
