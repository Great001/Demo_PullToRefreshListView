package com.example.dw.yy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PullToRefreshListViewFragment extends Fragment {

    private PullToRefreshListView pullToRefreshListView;
    private ListView mElvnums;
    private List<Integer> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_pull_to_refresh_list_view,null);
        pullToRefreshListView=(PullToRefreshListView)view.findViewById(R.id.pull_to_refresh_listview);
        mElvnums=(ListView)view.findViewById(R.id.lv_nums);
        list=new ArrayList<>();
        for(int i=1;i<50;i++){
            list.add(i);
        }
        LvAdapter adapter=new LvAdapter(getActivity(),list);
        mElvnums.setAdapter(adapter);
        return view;
    }
}
