package com.inetra.shop.inetrashop.presentation.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.inetra.shop.inetrashop.R;
import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;

public class ProductsAdapter extends BaseExpandableListAdapter {
    private List<? extends Map<String, String>> groupData;
    private String[] groupFrom = new String[]{"groupName"};
    private int[] groupTo = new int[]{R.id.tv_category};
    private List<? extends List<? extends Map<String, ProductListModel>>> childData;
    private String[] childFrom = new String[]{"childName"};
    private int[] childTo = new int[]{R.id.tv_name, R.id.tv_subcategory};
    private LayoutInflater inflater;

    @Inject
    ProductsAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupData = Collections.emptyList();
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newGroupView(isExpanded, parent);
        } else {
            v = convertView;
        }
        bindGroupView(v, groupData.get(groupPosition), groupFrom, groupTo);
        return v;
    }

    private View newGroupView(boolean isExpanded, ViewGroup parent) {
        int expandedGroupLayout = R.layout.item_group;
        int collapsedGroupLayout = R.layout.item_group;
        return inflater.inflate((isExpanded) ? expandedGroupLayout : collapsedGroupLayout,
                parent, false);
    }

    private void bindGroupView(View view, Map<String, String> data, String[] from, int[] to) {
        TextView textViewCategory = view.findViewById(R.id.tv_category);
        textViewCategory.setText(data.get(from[0]));
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newChildView(isLastChild, parent);
        } else {
            v = convertView;
        }
        bindChildView(v, childData.get(groupPosition).get(childPosition), childFrom, childTo);
        return v;
    }

    private View newChildView(boolean isLastChild, ViewGroup parent) {
        int childLayout = R.layout.item_child;
        int lastChildLayout = R.layout.item_child;
        return inflater.inflate((isLastChild) ? lastChildLayout : childLayout, parent, false);
    }

    private void bindChildView(View view, Map<String, ProductListModel> data, String[] from, int[] to) {
        TextView textViewName = view.findViewById(R.id.tv_name);
        TextView textViewSubcategory = view.findViewById(R.id.tv_subcategory);
        textViewName.setText(data.get(from[0]).getName());
        textViewSubcategory.setText(data.get(from[0]).getSubCategory());
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setProductsCollection(List<? extends Map<String, String>> groupData, List<? extends List<? extends Map<String, ProductListModel>>> childData) {
        this.groupData = groupData;
        this.childData = childData;
        this.notifyDataSetChanged();
    }
}
