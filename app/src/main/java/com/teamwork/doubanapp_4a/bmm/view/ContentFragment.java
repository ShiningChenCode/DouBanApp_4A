package com.teamwork.doubanapp_4a.bmm.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamwork.doubanapp_4a.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {
    private TextView tvTitle;
    private String title;

    public static Fragment newInstance(String title) {
        Bundle bundle = new Bundle();
        ContentFragment fragment = new ContentFragment();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ContentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bbm_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvTitle = (TextView) view.findViewById(R.id.tv);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title = getArguments().getString("title");
        tvTitle.setText(title);
    }
}
