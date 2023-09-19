package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    List<String> listTitle;
    HashMap<String, List<String>> listDetails;

    public CustomAdapter(Context context, List<String> listTitle, HashMap<String, List<String>> listDetails) {
        this.context = context;
        this.listTitle = listTitle;
        this.listDetails = listDetails;
    }

    @Override
    public int getGroupCount() {
        return listTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listDetails.get(listTitle.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listDetails.get(listTitle.get(i)).get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String titleText = (String) getGroup(i);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.title_layout,null);
        }

        TextView textView = view.findViewById(R.id.titleLayoutId);
        textView.setText(titleText);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String detailsText = (String) getChild(i,i1);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.details_layout,null);
        }

        TextView textView = view.findViewById(R.id.detailsLayoutId);
        textView.setText(detailsText);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
