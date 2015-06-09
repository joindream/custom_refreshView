package com.example.custompulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

public class Pull2RefreshListView extends PullToRefreshListView{

	public Pull2RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public Pull2RefreshListView(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle style) {
		super(context, mode, style);
		// TODO Auto-generated constructor stub
	}

	public Pull2RefreshListView(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode) {
		super(context, mode);
		// TODO Auto-generated constructor stub
	}

	public Pull2RefreshListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected LoadingLayout createLoadingLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, TypedArray attrs) {
		return new BoreLoadingLayout(context, mode, getPullToRefreshScrollDirection(), attrs);
	}
	
}
