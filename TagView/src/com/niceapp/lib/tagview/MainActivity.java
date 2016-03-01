package com.niceapp.lib.tagview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.niceapp.lib.tagview.widget.Tag;
import com.niceapp.lib.tagview.widget.TagListView;
import com.niceapp.lib.tagview.widget.TagListView.OnDelClickListener;
import com.niceapp.lib.tagview.widget.TagListView.OnTagClickListener;
import com.niceapp.lib.tagview.widget.TagView;

public class MainActivity extends Activity {

	private TagListView mTagListView;
	private final List<Tag> mTags = new ArrayList<Tag>();
	private final String[] titles = { "安全必备", "音乐", "父母学", "上班族必备", "360手机卫士",
			"QQ", "输入法", "微信", "最美应用", "AndevUI", "蘑菇街", "添加" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_tag_activity);

		mTagListView = (TagListView) findViewById(R.id.tagview);
		// mTagListView.setTagViewTextColorRes(Color.parseColor("#ff999999"));
		// mTagListView.setDeleteMode(true);
		setUpData();
		mTagListView.setTags(mTags);
		mTagListView.setOnTagClickListener(new OnTagClickListener() {

			@Override
			public void onTagClick(TagView tagView, Tag tag) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), tag.getTitle(),
						Toast.LENGTH_LONG).show();

				for (Tag mTag : mTags) {
					if (mTag.equals(tag)) {
						mTag.setChecked(true);
					} else {
						mTag.setChecked(false);
					}
				}
				mTagListView.setTags(mTags);
			}
		});
		mTagListView.setOnDelClickListener(new OnDelClickListener() {

			@Override
			public void onDelClick(TextView textView, Tag tag) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "删除" + tag.getTitle(),
						Toast.LENGTH_LONG).show();
			}
		});
	}

	private void setUpData() {
		for (int i = 0; i < titles.length; i++) {
			Tag tag = new Tag();
			tag.setId(i);
			if (i % 2 == 0) {
				tag.setChecked(true);
			} else {
				tag.setChecked(false);
			}
			if (titles[i].equals("添加")) {
				tag.setShowDel(false);
			}
			tag.setTitle(titles[i]);
			mTags.add(tag);
		}
	}
}
