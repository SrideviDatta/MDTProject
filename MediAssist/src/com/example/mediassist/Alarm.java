package com.example.mediassist;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Alarm implements Parcelable{

	String startDate;
	String endDate;
	String freqWk;
	String freqDay;
	String freqHr;
	String medicine;
	String desc;
	
	public Alarm(String s, String e, String fw, String fd, String fh, String m, String d)
	{
		startDate = s;
		endDate = e;
		freqWk = fw;
		freqDay = fd;
		freqHr = fh;
		medicine = m;
		desc = d;
	}

	public Alarm(Parcel dest) {
		startDate = dest.readString();
        endDate = dest.readString();
        freqDay = dest.readString();
        freqHr = dest.readString();
        freqWk = dest.readString();
        medicine = dest.readString();
        desc = dest.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeString(freqDay);
        dest.writeString(freqHr);
        dest.writeString(freqWk);
        dest.writeString(medicine);
        dest.writeString(desc);
		
	}
	
	public static final Parcelable.Creator<Alarm> CREATOR = new Parcelable.Creator<Alarm>() {
        public Alarm createFromParcel(Parcel in) {
            return new Alarm(in);
        }

        public Alarm[] newArray(int size) {
            return new Alarm[size];
        }
    };
}
