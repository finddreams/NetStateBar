package com.finddreams.netstate;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nettest.R;
import com.finddreams.bean.RecentChat;
/**
 * @Description:消息显示的adapter
 * @author http://blog.csdn.net/finddreams
 */ 
public class NewsAdapter extends BaseAdapter {
	protected static final String TAG = "NewsAdapter";
	private Context mContext;
	private List<RecentChat> lists;
	private ListView mListView;
	private HashMap<String, SoftReference<Bitmap>> hashMaps = new HashMap<String, SoftReference<Bitmap>>();

	public NewsAdapter(Context context, List<RecentChat> lists,
			ListView mListView) {
		this.mContext = context;
		this.lists = lists;
		this.mListView = mListView;
	}

	@Override
	public int getCount() {
		if (lists != null) {
			return lists.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Holder holder;
		RecentChat chat = lists.get(position);
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.news_item,
					null);
			holder = new Holder();
			holder.iv = (ImageView) convertView.findViewById(R.id.user_picture);
			holder.tv_name = (TextView) convertView
					.findViewById(R.id.user_name);
			holder.tv_feel = (TextView) convertView
					.findViewById(R.id.user_feel);
			holder.tv_time = (TextView) convertView
					.findViewById(R.id.user_time);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		String path = chat.getImgPath();
		

		holder.tv_name.setText(chat.getUserName());
		holder.tv_feel.setText(chat.getUserFeel());
		holder.tv_time.setText(chat.getUserTime());
		return convertView;
	}

	class Holder {
		ImageView iv;
		TextView tv_name;
		TextView tv_feel;
		TextView tv_time;
	}

}
