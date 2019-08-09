package com.example.appnavigatoncontrols.Controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnavigatoncontrols.R;

public class CalendarFragment extends Fragment {
    private static final String TAG = "Calendar";
    private TextView textView;
    private Button btbCalendar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment,container,false);
//        CalendarViewModel model = new CalendarViewModel();
//        textView = (TextView) view.findViewById(R.id.txt_calendar1);
//        textView.setText(model.txt1);

//        btbCalendar = (Button) view.findViewById(R.id.buttoncalendar);
//        btbCalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),"test calendar button", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
