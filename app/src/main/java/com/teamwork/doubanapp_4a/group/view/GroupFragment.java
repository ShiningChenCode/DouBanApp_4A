package com.teamwork.doubanapp_4a.group.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.teamwork.doubanapp_4a.R;
import com.teamwork.doubanapp_4a.group.view.activity.RecommandActivity;
import com.teamwork.doubanapp_4a.group.view.adapter.SiftAdapter;
import com.teamwork.doubanapp_4a.group.view.groupdata.SiftData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements View.OnClickListener{

    private RecyclerView siftRecycleView;
    private Button look;
    private List<SiftData> mSiftDataList = new ArrayList<>();
    private SiftAdapter mSiftAdapter;
    private RelativeLayout newesttopic;
    private RelativeLayout publish;
    private RelativeLayout response;
    private RelativeLayout brose;
    private ImageView search_img;
    private ImageView chat_img;
    public GroupFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group,container,false);
        siftRecycleView = (RecyclerView) view.findViewById(R.id.siftrecycle);
        look = (Button) view.findViewById(R.id.look);
        newesttopic = (RelativeLayout) view.findViewById(R.id.newesttopic);
        publish = (RelativeLayout) view.findViewById(R.id.publish);
        response = (RelativeLayout) view.findViewById(R.id.response);
        brose= (RelativeLayout) view.findViewById(R.id.brose);
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
        initData();
        mSiftAdapter = new SiftAdapter(mSiftDataList,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        siftRecycleView.setLayoutManager(linearLayoutManager);
        siftRecycleView.setAdapter(mSiftAdapter);
    }

    private void initData() {
        for (int i=0 ;i<5 ;i++){
            SiftData siftData = new SiftData();
            siftData.setImgId(R.drawable.bg_player_default);
            mSiftDataList.add(siftData);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.look:
                Intent intent = new Intent(getActivity(), RecommandActivity.class);
                startActivity(intent);
                break;
            case R.id.newesttopic:
                break;
            case R.id.publish:
                break;
            case R.id.response:
                break;
            case R.id.brose:
                break;
            case R.id.serach_img:
                break;
            case R.id.chat_img:
                break;
        }

    }
}
