package com.example.ayush.eduon;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

import static android.media.CamcorderProfile.get;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity mcontext;
    private Map<String, List<String>> extlist;
    private List<String> mlist;

    public ExpandableListAdapter(Activity context, List<String> list, Map<String, List<String>> elist){

        this.mcontext = context;
        this.extlist = elist;
        this.mlist = list;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return extlist.get(mlist.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String string = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = mcontext.getLayoutInflater();

        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView item = convertView.findViewById(R.id.ListItem);
        item.setText(string);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return extlist.get(mlist.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mlist.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return mlist.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String string1 = (String) getGroup(groupPosition);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grouplist, null);
        }
        TextView item = convertView.findViewById(R.id.ListHeader);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(string1);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
