package com.cathlamet.ron.android.tpeptwo;


import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class LogListFragment extends ListFragment {
	private ArrayList<LogItem> mLogItems;
	private static final String TAG = "LogListFragment";
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.logItems_title);
		mLogItems = LogList.get(getActivity()).getLogItems();
		
		
		LogItemAdapter adapter = new LogItemAdapter(mLogItems);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		
		LogItem c = ((LogItemAdapter)getListAdapter()).getItem(position);
		
		//start a logItem Pager Activity
		Intent i = new Intent(getActivity(), LogItemPagerActvity.class);
		i.putExtra(LogItemFragment.EXTRA_LOGITEM_ID,  c.getId());
		startActivity(i);
		
	}
	
	@Override
	public void onResume(){
		super.onResume();
		((LogItemAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
private class LogItemAdapter extends ArrayAdapter<LogItem>{
	
	public LogItemAdapter(ArrayList<LogItem> logItems){
		super(getActivity(), 0, logItems);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		// if we weren't given a view, inflate one
		if (convertView == null){
			convertView = getActivity().getLayoutInflater()
					.inflate(R.layout.list_item_logitem, null);
		}
		
		// configure the view for this logItem
		LogItem c = getItem(position);
		TextView titleTextView = 
				(TextView)convertView.findViewById(R.id.log_item_list_item_titleTextView);
		titleTextView.setText(c.getTitle());
		TextView dateTextView = 
				(TextView)convertView.findViewById(R.id.log_item_list_item_dateTextView);
		dateTextView.setText(c.getDate().toString());
		
		return convertView;
		
	}
	}
}

