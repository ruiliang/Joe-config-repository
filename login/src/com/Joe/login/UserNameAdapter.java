package com.Joe.login;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserNameAdapter extends BaseAdapter{
	
	List<String> listOfdiscription = null;
	Context context = null;
	public UserNameAdapter(Context context, List<String> objects) {
		super();
		this.listOfdiscription = objects;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		int totalItem = listOfdiscription.size();
		return totalItem;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listOfdiscription.get(position);
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rawView = inflator.inflate(R.layout.username_listitem, null);
		TextView username = (TextView) rawView.findViewById(R.id.textView1);
//		ImageView userPic = (ImageViewi) rawView.findViewById(R.id.imageView1);
		
		username.setText(listOfdiscription.get(position));
//		userPic.setImageResource(R.drawable.ic_launcher);
		
		return rawView;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
