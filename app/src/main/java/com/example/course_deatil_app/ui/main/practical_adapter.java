package com.example.course_deatil_app.ui.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.course_deatil_app.R;
import com.example.course_deatil_app.practical_two_view_cont;

import java.util.ArrayList;
import java.util.List;

public class practical_adapter extends BaseAdapter {
    private Context mContext;
    private List<practical_two_view_cont> final_practical_list;


    public practical_adapter(Context mContext, List<practical_two_view_cont> final_practical_list) {
        this.mContext=mContext;
        this.final_practical_list=final_practical_list;


    }

    @Override
    public int getCount() {
        return final_practical_list.size();
    }

    @Override
    public Object getItem(int position) {
        return final_practical_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(mContext, R.layout.practical_content_two_view,null);
        TextView title_tv=view.findViewById(R.id.title_view);
        TextView content_tv=view.findViewById(R.id.practical_content_view);
        title_tv.setText(final_practical_list.get(position).title);
        content_tv.setText(final_practical_list.get(position).content);
        return view;
    }
}
