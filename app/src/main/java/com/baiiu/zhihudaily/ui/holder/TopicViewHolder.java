package com.baiiu.zhihudaily.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.baiiu.zhihudaily.R;
import com.baiiu.zhihudaily.ui.adapter.TopicAdapter;
import com.baiiu.zhihudaily.base.BaseViewHolder;
import com.baiiu.zhihudaily.pojo.TopStory;
import com.baiiu.zhihudaily.widget.indicator._interface.IPageIndicator;
import com.baiiu.zhihudaily.widget.loopvp.LoopViewPager;

import java.util.List;

import butterknife.Bind;

/**
 * author: baiiu
 * date: on 16/4/5 15:53
 * description:
 */
public class TopicViewHolder extends BaseViewHolder<List<TopStory>> {

  @Bind(R.id.loopViewPager) LoopViewPager viewPager;
  @Bind(R.id.indicator) IPageIndicator indicator;
  private TopicAdapter topicAdapter;

  public TopicViewHolder(Context context, ViewGroup parent, View.OnClickListener listener) {
    super(context, R.layout.holder_topic, parent, listener);
  }

  @Override public void bind(List<TopStory> data) {
    if (topicAdapter == null) {
      topicAdapter = new TopicAdapter(mContext, data, mListener);
      viewPager.setAdapter(topicAdapter);
      viewPager.startAutoScroll();
      indicator.setViewPager(viewPager);
    }
  }

  public void stop() {
    if (viewPager != null) {
      viewPager.stopAutoScroll();
    }
  }

  public void start() {
    if (viewPager != null) {
      viewPager.startAutoScroll();
    }
  }
}
