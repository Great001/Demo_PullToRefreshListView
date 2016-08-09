package com.example.dw.yy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DW on 2016/8/9.
 */
public class LvAdapter extends BaseAdapter {

    List<Integer> nums;
    Context context;

    public LvAdapter(Context context,List<Integer> list){
        this.context=context;
        this.nums=list;
    }

    @Override
    public int getCount() {
        return nums.size();
    }

    @Override
    public Object getItem(int position) {
        return nums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new MyViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            viewHolder.textView=(TextView)convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        }

        else{
            viewHolder=(MyViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(nums.get(position)+"");
        return convertView;
    }

    public class MyViewHolder {
        TextView textView;
    }
}
