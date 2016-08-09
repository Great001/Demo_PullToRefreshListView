package com.example.dw.yy;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DW on 2016/8/8.
 */
public class ExpandaLVdapter extends BaseExpandableListAdapter {

    List<String> GroupList=new ArrayList<>();
    List<String> ItemList=new ArrayList<>();
    List<List<String>> list=new ArrayList<>();

    Context context;

    public ExpandaLVdapter(Context context){
        this.context=context;

        GroupList.add("one");
        GroupList.add("two");
        GroupList.add("three");

        for(int i=0; i<5;i++){
            ItemList.add(i+"");
        }


        list.add(ItemList);
        list.add(ItemList);
        list.add(ItemList);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).get(childPosition);
    }

    @Override
    public int getGroupCount() {
        return GroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ItemList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupHolder;

        if(convertView==null){
            groupHolder=new GroupViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.group_layout,null);
            groupHolder.textGroup=(TextView)convertView.findViewById(R.id.tv_group);
            convertView.setTag(groupHolder);
        }
        else{
            groupHolder=(GroupViewHolder)convertView.getTag();
        }

        groupHolder.textGroup.setText(GroupList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemViewHolder holder;
        if(convertView==null){
            holder=new ItemViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            holder.textItem=(TextView)convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }
        else{
            holder=(ItemViewHolder) convertView.getTag();

        }

        holder.textItem.setText(list.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    class GroupViewHolder{
        TextView textGroup;
    }

    class ItemViewHolder{
        TextView textItem;
    }



}
