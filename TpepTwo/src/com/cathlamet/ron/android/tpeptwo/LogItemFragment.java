package com.cathlamet.ron.android.tpeptwo;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class LogItemFragment extends Fragment {
	public static final String EXTRA_LOGITEM_ID = 
			"com.cathlamet.ron.android.tpeptwo.log_item_id";
private LogItem mLogItem;
private EditText mTitleField;
private Button mDateButton;

public static LogItemFragment newInstance(UUID logItemId){
	Bundle args = new Bundle();
	args.putSerializable(EXTRA_LOGITEM_ID,  logItemId);
	LogItemFragment fragment = new LogItemFragment();
	fragment.setArguments(args);
	return fragment;
}


@Override
public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	
	UUID logItemId = (UUID)getArguments()
			.getSerializable(EXTRA_LOGITEM_ID);
	mLogItem = LogList.get(getActivity()).getLogItem(logItemId);
	
	
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
View v = inflater.inflate(R.layout.fragment_log_item, parent, false);


mTitleField = (EditText)v.findViewById(R.id.log_item_title);
mTitleField.setText(mLogItem.getTitle());
mTitleField.addTextChangedListener(new TextWatcher(){
	public void onTextChanged(
			CharSequence c, int start, int before, int count){
		mLogItem.setTitle(c.toString());
	}
	
	public void beforeTextChanged(
		CharSequence c, int start, int count, int after){
	// this space intentionally left blank
			}
	public void afterTextChanged(Editable c){
		// this one too
	}

});

mDateButton = (Button)v.findViewById(R.id.log_item_date);
mDateButton.setText(mLogItem.getDate().toString());
mDateButton.setEnabled(false);


return v;
}
}
