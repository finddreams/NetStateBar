package com.finddreams.netstate;

import java.util.LinkedList;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.nettest.R;
import com.finddreams.bean.RecentChat;
import com.finddreams.network.NetUtils;
import com.finddreams.receiver.NetReceiver;

import de.greenrobot.event.EventBus;

/**
 * @Description:网络状态条的显示控制
 * @author http://blog.csdn.net/finddreams
 */
public class MainActivity extends Activity {

	private NewsAdapter adapter;
	private LinkedList<RecentChat> chats = new LinkedList<RecentChat>();
	private NetReceiver mReceiver;
	private ListView listView;
	private RelativeLayout no_network_rl;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initReceive();
		initView();
		EventBus.getDefault().register(this);

	}

	private void initView() {

		chats.add(new RecentChat("章泽天", "好好学习天天向上", "16:30", ""));
		chats.add(new RecentChat("宋茜", "好好学习天天向上", "17:30", ""));
		chats.add(new RecentChat("韩孝珠", "好好学习天天向上", "昨天", ""));
		chats.add(new RecentChat("景甜", "好好学习天天向上", "星期一", ""));
		chats.add(new RecentChat("刘亦菲", "好好学习天天向上", "17:30", ""));
		chats.add(new RecentChat("邓紫棋", "好好学习天天向上", "星期一", ""));
		listView = (ListView) findViewById(R.id.lv_news);
		adapter = new NewsAdapter(this, chats, listView);
		listView.setAdapter(adapter);
		no_network_rl = (RelativeLayout) findViewById(R.id.net_view_rl);
	}

	private void initReceive() {
		mReceiver = new NetReceiver();
		IntentFilter mFilter = new IntentFilter();
		mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(mReceiver, mFilter);
	}

	public void onEventMainThread(NetEvent event) {

		setNetState(event.isNet());
	}

	public void setNetState(boolean netState) {

		if (no_network_rl != null) {
			no_network_rl.setVisibility(netState ? View.GONE : View.VISIBLE);
			no_network_rl.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					NetUtils.startToSettings(MainActivity.this);
				}
			});
		}
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(mReceiver);
		EventBus.getDefault().unregister(this);
		super.onDestroy();
	}
}
