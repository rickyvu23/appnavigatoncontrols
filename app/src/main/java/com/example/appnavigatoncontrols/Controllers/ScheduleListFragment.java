package com.example.appnavigatoncontrols.Controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnavigatoncontrols.R;
import com.example.appnavigatoncontrols.ViewModels.ScheduleListViewModel;

public class ScheduleListFragment extends Fragment {
    private static final String TAG = "Schedule List";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedulelist_fragment,container,false);
        ScheduleListViewModel model = new ScheduleListViewModel();
        TextView textView = (TextView) view.findViewById(R.id.txt_schedulelist1);
        textView.setText(model.txt1);
        return view;
    }
}
