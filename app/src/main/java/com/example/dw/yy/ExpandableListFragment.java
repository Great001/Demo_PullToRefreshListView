package com.example.dw.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * Created by DW on 2016/8/9.
 */
public class ExpandableListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.expandable_listview,null);
        ExpandableListView listview=(ExpandableListView)view.findViewById(R.id.expandable_lv);
        ExpandaLVdapter adapter=new ExpandaLVdapter(getActivity());
        listview.setAdapter(adapter);


        for(int i=0;i<3;i++){
            listview.expandGroup(i);
        }


        listview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        return view;
    }
}
