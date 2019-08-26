package com.example.appnavigatoncontrols.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.appnavigatoncontrols.Common.ScheduleTypeList;

import java.util.ArrayList;

public class ScheduleTypesViewModel extends ViewModel {
    public ArrayList<ScheduleTypeList> scheduleTypeList;

    public ScheduleTypesViewModel() {
        scheduleTypeList = new ArrayList<>();
    }

}
