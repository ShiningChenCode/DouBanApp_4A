package com.teamwork.doubanapp_4a.mine.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.util.ItemClickListener;
import com.teamwork.doubanapp_4a.mine.view.activity.AlbumActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.BroadCastActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.DouBanTimeActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.DouLieActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.IndentActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.LocalActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.MovieActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.MusicActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.MyLikeActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.MyWalletActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.NoteActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.ReadingActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.RemindActivity;
import com.teamwork.doubanapp_4a.mine.view.activity.SettingActivity;
import com.teamwork.doubanapp_4a.mine.view.adapter.FuctionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener{

	private RecyclerView mFuctionRecyclerView;
	private FuctionAdapter mFuctionAdapter;
	private ImageView settingImg;
	private LinearLayout remindlayout;
	private List<int[]> mList = new ArrayList<>();
	private int[] Img = {R.drawable.ic_my_likes, R.drawable.ic_my_note, R.drawable.ic_my_album, R.drawable.ic_my_status,
			             R.drawable.ic_my_movies_tvs, R.drawable.ic_my_books,R.drawable.ic_my_music, R.drawable.ic_my_events,
			R.drawable.ic_douban_time, R.drawable.ic_my_doulist,R.drawable.ic_my_orders, R.drawable.ic_my_wallet};

	public MineFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_mine, container, false);
		mFuctionRecyclerView = (RecyclerView) view.findViewById(R.id.fuctionrecy);
		remindlayout = (LinearLayout) view.findViewById(R.id.remindlayout);
		settingImg = (ImageView) view.findViewById(R.id.settingImg);
		settingImg.setOnClickListener(this);
		remindlayout.setOnClickListener(this);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mList.add(Img);
		mFuctionAdapter = new FuctionAdapter(mList,getActivity());
		mFuctionRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
		mFuctionRecyclerView.setAdapter(mFuctionAdapter);
		mFuctionAdapter.setItemClickListener(new ItemClickListener() {
			@Override
			public void onItemClickListener(View v, int position) {
				if (position==0){
					startActivity(new Intent(getActivity(), MyLikeActivity.class));
				}
				if (position==1){
					startActivity(new Intent(getActivity(), NoteActivity.class));
				}
				if (position==2){
					startActivity(new Intent(getActivity(), AlbumActivity.class));
				}
				if (position==3){
					startActivity(new Intent(getActivity(), BroadCastActivity.class));
				}
				if (position==4){
					startActivity(new Intent(getActivity(), MovieActivity.class));
				}
				if (position==5){
					startActivity(new Intent(getActivity(), ReadingActivity.class));
				}
				if (position==6){
					startActivity(new Intent(getActivity(), MusicActivity.class));
				}
				if (position==7){
					startActivity(new Intent(getActivity(), LocalActivity.class));
				}
				if (position==8){
					startActivity(new Intent(getActivity(), DouBanTimeActivity.class));
				}
				if (position==9){
					startActivity(new Intent(getActivity(), DouLieActivity.class));
				}
				if (position==10){
					startActivity(new Intent(getActivity(), IndentActivity.class));
				}
				if (position==11){
					startActivity(new Intent(getActivity(), MyWalletActivity.class));
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.settingImg:
		        startActivity(new Intent(getActivity(), SettingActivity.class));
				break;
			case R.id.remindlayout:
				startActivity(new Intent(getActivity(), RemindActivity.class));
				break;
		}
	}
}
