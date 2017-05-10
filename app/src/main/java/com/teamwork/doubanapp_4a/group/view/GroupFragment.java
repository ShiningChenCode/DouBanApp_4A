package com.teamwork.doubanapp_4a.group.view;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.adapter.OftenAdapter;
import com.teamwork.doubanapp_4a.group.view.adapter.SiftAdapter;
import com.teamwork.doubanapp_4a.group.view.mixedcontract.MixedContract;
import com.teamwork.doubanapp_4a.group.view.db.MySqlite;
import com.teamwork.doubanapp_4a.group.view.groupdata.MorelData;
import com.teamwork.doubanapp_4a.group.view.groupdata.SiftData;
import com.teamwork.doubanapp_4a.group.view.presenter.MixedGroupPresenter;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;
import com.teamwork.doubanapp_4a.group.view.view.DetailActivity;
import com.teamwork.doubanapp_4a.group.view.view.NewEstTopicActivity;
import com.teamwork.doubanapp_4a.group.view.view.PublishActivity;
import com.teamwork.doubanapp_4a.group.view.view.RecentlyBrowseActivity;
import com.teamwork.doubanapp_4a.group.view.view.RecommandActivity;
import com.teamwork.doubanapp_4a.group.view.view.ResponseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements View.OnClickListener, MixedContract.IFindMoreView<SiftData.MixedRecGroupsBean> {

	private RecyclerView siftRecycleView;
	private RecyclerView oftenRecycleView;
	private OftenAdapter mOftenAdapter;
	private Button look;
	private SiftData mSiftData;
	private SiftAdapter mSiftAdapter;
	private RelativeLayout newesttopic;
	private RelativeLayout publish;
	private RelativeLayout response;
	private RelativeLayout brose;
	private ImageView search_img;
	private ImageView chat_img;
	private MySqlite mSqlite;
	private SQLiteDatabase database;
	private Cursor cursor = null;
	private List<MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean> grouplist = new
            ArrayList<>();
	private MixedGroupPresenter mMixedGroupPresenter;
	private final static String mixedUrl = "http://60.205.189.201/douban/group/mixedgroups.php";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
		// Inflate the layout for this fragment
		mMixedGroupPresenter = new MixedGroupPresenter(this);
		mSqlite = new MySqlite(getActivity(), "Group.db", null, 1);
		database = mSqlite.getWritableDatabase();
		View view = inflater.inflate(R.layout.fragment_group, container, false);
		siftRecycleView = (RecyclerView) view.findViewById(R.id.siftrecycle);
		oftenRecycleView = (RecyclerView) view.findViewById(R.id.oftenrecycleview);
		look = (Button) view.findViewById(R.id.look);
		newesttopic = (RelativeLayout) view.findViewById(R.id.newesttopic);
		publish = (RelativeLayout) view.findViewById(R.id.publish);
		response = (RelativeLayout) view.findViewById(R.id.response);
		brose = (RelativeLayout) view.findViewById(R.id.brose);
		search_img = (ImageView) view.findViewById(R.id.serach_img);
		chat_img = (ImageView) view.findViewById(R.id.chat_img);

		newesttopic.setOnClickListener(this);
		publish.setOnClickListener(this);
		response.setOnClickListener(this);
		brose.setOnClickListener(this);
		look.setOnClickListener(this);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mMixedGroupPresenter.mixed(mixedUrl);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.look:
				Intent intent = new Intent(getActivity(), RecommandActivity.class);
				startActivity(intent);
				break;
			case R.id.newesttopic:
				Intent intent1 = new Intent(getActivity(), NewEstTopicActivity.class);
				startActivity(intent1);
				break;
			case R.id.publish:
				Intent intent2 = new Intent(getActivity(), PublishActivity.class);
				startActivity(intent2);
				break;
			case R.id.response:
				Intent intent3 = new Intent(getActivity(), ResponseActivity.class);
				startActivity(intent3);
				break;
			case R.id.brose:
				Intent intent4 = new Intent(getActivity(), RecentlyBrowseActivity.class);
				startActivity(intent4);
				break;
			case R.id.serach_img:
				break;
			case R.id.chat_img:
				break;
		}

	}

	String TAG = "666";

	@Override
	public void onResume() {
		super.onResume();
		grouplist.clear();
		cursor = database.query(MySqlite.table_name, null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Log.i(TAG, "onResume: " + "---------------------------");
				MorelData.RecGroupsBean.ClassifiedGroupsBean.GroupsBean groupsBean = new MorelData
                        .RecGroupsBean.ClassifiedGroupsBean.GroupsBean();
				groupsBean.setAvatar(cursor.getString(cursor.getColumnIndex(MySqlite.Img_url)));
				groupsBean.setUrl(cursor.getString(cursor.getColumnIndex(MySqlite.Detail_url)));
				groupsBean.setName(cursor.getString(cursor.getColumnIndex(MySqlite.Title_text)));
				grouplist.add(groupsBean);
			} while (cursor.moveToNext());
		}
		mOftenAdapter = new OftenAdapter(grouplist, getActivity());
		oftenRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()) {
			@Override
			public boolean canScrollVertically() {
				return false;
			}
		});
		oftenRecycleView.setAdapter(mOftenAdapter);
		mOftenAdapter.setItemClickListener(new ItemClickListener() {
			@Override
			public void onItemClickListener(View v, int position) {
				cursor.moveToPosition(position);
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				String url = cursor.getString(cursor.getColumnIndex(MySqlite.Detail_url));
				String imgUrl = cursor.getString(cursor.getColumnIndex(MySqlite.Img_url));
				String content = cursor.getString(cursor.getColumnIndex(MySqlite.Title_text));
				intent.putExtra("url", url);
				intent.putExtra("imgUrl", imgUrl);
				intent.putExtra("content_text", content);
				startActivity(intent);
			}
		});
	}


	@Override
	public void showMixedGroup(final List<SiftData.MixedRecGroupsBean> data) {
		mSiftAdapter = new SiftAdapter(data, getActivity());
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
			@Override
			public boolean canScrollVertically() {
				return false;
			}
		};
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		siftRecycleView.setLayoutManager(linearLayoutManager);
		siftRecycleView.setAdapter(mSiftAdapter);
		mSiftAdapter.setItemClickListener(new ItemClickListener() {
			@Override
			public void onItemClickListener(View v, int position) {
				SiftData.MixedRecGroupsBean mixedRecGroupsBean = data.get(position);
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				intent.putExtra("url", mixedRecGroupsBean.getUri());
				startActivity(intent);
			}
		});

	}

	@Override
	public void showFailed() {

	}
}
