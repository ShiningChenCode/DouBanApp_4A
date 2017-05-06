package com.teamwork.doubanapp_4a.mine.view.moviefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by Administrator on 2017/5/4.
 */

public class WantSee extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mine_movie_wantsee,container,false);
		return view;
	}
}
