package com.teamwork.doubanapp_4a.mine.view.doulie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by Administrator on 2017/5/6.
 */

public class Create extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mine_doulie_create,container,false);
		return view;
	}
}
