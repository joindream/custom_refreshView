package com.example.custompulltorefresh;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

public class BoreLoadingLayout extends LoadingLayout {
	
	// ������ɺ��֡����,������
	private AnimationDrawable animationDrawableLoading;
	
	// �������������仯��֡����,������
	private AnimationDrawable animationDrawable;
		
	public BoreLoadingLayout(Context context, Mode mode, Orientation scrollDirection, TypedArray attrs) {
		super(context, mode, scrollDirection, attrs);
		initFrame(context);
		
		mHeaderImage.setImageDrawable(animationDrawable);
	}

	private void initFrame(Context context) {
		Resources res = context.getResources();
		
		animationDrawableLoading = new AnimationDrawable();
		animationDrawableLoading.addFrame(
				res.getDrawable(R.drawable.dropdown_loading_00), 150);
		animationDrawableLoading.addFrame(
				res.getDrawable(R.drawable.dropdown_loading_01), 150);
		animationDrawableLoading.addFrame(
				res.getDrawable(R.drawable.dropdown_loading_02), 150);
		animationDrawableLoading.setOneShot(false);
		
		animationDrawable = new AnimationDrawable();
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_00), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_01), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_02), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_03), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_04), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_05), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_06), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_07), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_08), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_09), 100);
		animationDrawable.addFrame(
				res.getDrawable(R.drawable.dropdown_anim_10), 100);
	}

	@Override
	protected int getDefaultDrawableResId() {
		Log.i("PULL", "getDefaultDrawableResId()");
		return R.drawable.dropdown_anim_00;
	}

	@Override
	protected void onLoadingDrawableSet(Drawable imageDrawable) {
		Log.i("PULL", "onLoadingDrawableSet()");
	}

	// ��������, �����������벥��ָ��֡���������ӽ���Ͷ���
	// scaleOfLayoutΪ�������������ͷ���ֵĸ߶ȱ���, ��scaleOfLayout > 1fʱ,���ֺ�����ˢ��
	@Override
	protected void onPullImpl(float scaleOfLayout) {
		// һ��11֡����,����ÿһ֡��Ӧ��scale��
		float scaleOfFrame = 1f / animationDrawable.getNumberOfFrames();
		// ��ǰ����scaleֵ����ÿһ֡scale�������ǰӦ�ò�����һ֡����
		int idx = (int) (scaleOfLayout / scaleOfFrame);
		// �����������ʱ(��ӦscaleOfLayout > 1f),ͣ�������һ֡
		if(idx > animationDrawable.getNumberOfFrames() - 1) {
			idx = animationDrawable.getNumberOfFrames() - 1;
		}
		// ���õ�ǰ֡�Ǳ�
		animationDrawable.selectDrawable(idx);
		Log.i("PULL", "onPullImpl() ... scaleOfLayout = " + scaleOfLayout + " ... idx = " + idx);
	}

	@Override
	protected void pullToRefreshImpl() {
		Log.i("PULL", "pullToRefreshImpl()");
	}

	// �����ͷź�ʼˢ��ing, ��ʱ���Ž���������
	@Override
	protected void refreshingImpl() {
		Log.i("PULL", "refreshingImpl()");
		// �����ͷź�,��ʼ������һ��loading����
		mHeaderImage.clearAnimation();
		mHeaderImage.setImageDrawable(animationDrawableLoading);
		animationDrawableLoading.start();
	}

	@Override
	protected void releaseToRefreshImpl() {
		Log.i("PULL", "releaseToRefreshImpl()");
	}

	@Override
	protected void resetImpl() {
		Log.i("PULL", "resetImpl()");
		
		// ��ʼ����ǰ����,�������ó԰��Ӷ���
		mHeaderImage.clearAnimation();
		mHeaderImage.setImageDrawable(animationDrawable);
	}

}
