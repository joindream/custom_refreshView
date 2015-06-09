package com.example.custompulltorefresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public class MainActivity extends Activity {

	private Pull2RefreshListView plv;
	
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			plv.onRefreshComplete();
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		plv = (Pull2RefreshListView) findViewById(R.id.plv);
		plv.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				handler.sendEmptyMessageDelayed(0, 1500);
			}
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 20; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("name", "name" + i);
			hashMap.put("phone", "1391339123" + i);
			data.add(hashMap);
		}
		plv.setAdapter(new SimpleAdapter(this, data, R.layout.item,
				new String[] { "name", "phone" }, new int[] { R.id.tv_name, R.id.tv_phone }));
	}
}
