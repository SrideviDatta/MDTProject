package com.example.mediassist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AlarmAdapter extends ArrayAdapter<Alarm>{

	Context c;
	int id;
	ArrayList<Alarm> al;
	LayoutInflater li;
	
	public AlarmAdapter(Context c, int n, ArrayList<Alarm> al)
	{
		super(c,n,al);
		this.c =c;
		this.id = n;
		this.al = al;
		li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	
	@Override
	public View getView(int p, View v, ViewGroup vg)
	{
		View view;
		LayoutInflater li = ((Activity) c).getLayoutInflater();
        view = li.inflate(R.layout.activity_lvcontent, vg, false);
        
        ViewClass vc = new ViewClass();
        vc.med = (TextView)view.findViewById(R.id.tVMedicine2);
        vc.freq = (TextView)view.findViewById(R.id.tVFreq2);
        ArrayList<Alarm> temp = AlarmActivity.alarmList;
        vc.med.setText(((Alarm)temp.get(p)).medicine);
        vc.freq.setText(((Alarm)temp.get(p)).freqWk+" days "+((Alarm)temp.get(p)).freqDay+" hours "+((Alarm)temp.get(p)).freqHr+" minutes");
        view.setTag(vc);
		return view;
		
	}
	
	
	
}
