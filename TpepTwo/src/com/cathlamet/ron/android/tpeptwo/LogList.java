package com.cathlamet.ron.android.tpeptwo;
import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;



public class LogList {
	private ArrayList<LogItem> mLogItems;
	private static LogList sLogList;
	private Context mAppContext;
	
	private LogList(Context appContext){
		mAppContext = appContext;
		mLogItems = new ArrayList<LogItem>();
		for (int i=0;i<100;i++){
			LogItem c = new LogItem();
			c.setTitle("LogItem #" + i);
			mLogItems.add(c);
		}
	}
public static LogList get(Context c){
	if (sLogList == null){
		sLogList = new LogList(c.getApplicationContext());
	}
	return sLogList;
}
public ArrayList<LogItem> getLogItems(){
	return mLogItems;
}
public LogItem getLogItem(UUID id){
	for (LogItem c: mLogItems){
		if (c.getId().equals(id))
			return c;
	}
	return null;
}
}
