package com.florida.receiptapp.adapters;

import java.util.ArrayList;

import com.florida.receiptapp.R;
import com.florida.receiptapp.classes.GridItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeNavGridAdapter extends ArrayAdapter<GridItem> {
	Context context;
	int layout_resource_id;
	ArrayList<GridItem> data = new ArrayList<GridItem>();
	
	public HomeNavGridAdapter(Context context, int layout_resource_id, ArrayList<GridItem> data) {
		super(context, layout_resource_id, data);
		this.context = context;
		this.layout_resource_id = layout_resource_id;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RowHolder holder = null;
		
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layout_resource_id, parent, false);
			
			holder = new RowHolder();
			holder.txt_title = (TextView) row.findViewById(R.id.item_text);
			row.setTag(holder);
		} else {
			holder = (RowHolder) row.getTag();
		}
		
		GridItem item = data.get(position);
		holder.txt_title.setText(item.getTitle());
		holder.txt_title.setCompoundDrawablesWithIntrinsicBounds(0, item.getImage(), 0, 0);	
		
		return row;
	}
	
	static class RowHolder {
		TextView txt_title;
		ImageView image_item;
	}
	
	
}
