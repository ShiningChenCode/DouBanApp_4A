package com.teamwork.doubanapp_4a.mine.view.musicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by Administrator on 2017/5/5.
 */

public class WantListen extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mine_music_wantlisten, container, false);
		return view;
	}
}
