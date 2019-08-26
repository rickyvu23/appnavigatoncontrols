package com.example.appnavigatoncontrols.Controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnavigatoncontrols.Common.RecyclerViewAdapter;
import com.example.appnavigatoncontrols.Common.ScheduleTypeList;
import com.example.appnavigatoncontrols.Common.modalDialog;
import com.example.appnavigatoncontrols.R;
import com.example.appnavigatoncontrols.ViewModels.ScheduleTypesViewModel;

import java.util.ArrayList;

public class ScheduleTypesFragment extends Fragment {
    private static final String TAG = "Calendar";
    private TextView textView;
    private Button btbCalendar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ScheduleTypesViewModel scheduleTypesViewModel = new ScheduleTypesViewModel();
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set this is onCreateView works too. This get create before onCreateView
        scheduleTypesViewModel.scheduleTypeList.add(new ScheduleTypeList(R.drawable.ic_about_us, "Line 1", "Line 2"));
        scheduleTypesViewModel.scheduleTypeList.add(new ScheduleTypeList(R.drawable.ic_calendar_black, "Line 3", "Line 4"));
        scheduleTypesViewModel.scheduleTypeList.add(new ScheduleTypeList(R.drawable.ic_menu_camera, "Line 5", "Line 6"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scheduletypes,container,false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new GridLayoutManager(getActivity(),3); //inline grid
        mLayoutManager = new LinearLayoutManager(getActivity());
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mAdapter = new RecyclerViewAdapter(scheduleTypesViewModel.scheduleTypeList);
        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
                openDialog();
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        buttonInsert = view.findViewById(R.id.button_insert);
        buttonRemove = view.findViewById(R.id.button_remove);
        editTextInsert = view.findViewById(R.id.edittext_insert);
        editTextRemove = view.findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position = Integer.parseInt(editTextInsert.getText().toString());
                String NewScheduleType = editTextInsert.getText().toString();
                insertItem(NewScheduleType);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

        return view;
    }
    public void insertItem(String NewScheduleType) {
        int position = scheduleTypesViewModel.scheduleTypeList.size();
        scheduleTypesViewModel.scheduleTypeList.add(position, new ScheduleTypeList(R.drawable.ic_calendar_black, "New Item:" + NewScheduleType, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        if(position > scheduleTypesViewModel.scheduleTypeList.size()){
            Toast.makeText(getActivity(),"There is no item in this position", Toast.LENGTH_SHORT).show();
        }else{
            scheduleTypesViewModel.scheduleTypeList.remove(position);
            mAdapter.notifyItemRemoved(position);
        }
    }
    public void changeItem(int position, String text) {
        scheduleTypesViewModel.scheduleTypeList.get(position).Title = text;
        mAdapter.notifyItemChanged(position);
    }
    public void openDialog() {
        modalDialog mDialog = new modalDialog();
        mDialog.show(getFragmentManager(), "example dialog");
    }
}
