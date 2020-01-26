package com.example.customadaptor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {

    private final String TAG = "Myactivity";
    Activity activity;
    ArrayList customlist;
    LayoutInflater layoutin = null;
    boolean[] itemChecked;

    public CustomAdaptor(Activity activity, ArrayList customlist) {
        this.activity = activity;
        this.customlist = customlist;
        layoutin = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemChecked = new boolean[customlist.size()];
    }

    @Override
    public int getCount() {
        return customlist.size();
    }

    @Override
    public Object getItem(int i) {
        return customlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    ViewHolder viewholder=null;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vie = view;
        final int pos = i;
        //String txt = getItem(pos).toString();
        CustomData data = (CustomData) getItem(pos);
        Log.i(TAG,"printing"+data.toString());
        if(vie == null){
            viewholder = new ViewHolder();
            vie = layoutin.inflate(R.layout.activity_dynamic,null);
            viewholder.txtview = (TextView)vie.findViewById(R.id.textView);
            viewholder.chkbox = (CheckBox)vie.findViewById(R.id.checkBox);
            vie.setTag(viewholder);
        }
        else
        {
            viewholder = (ViewHolder)vie.getTag();
        }
        //String text = null;
        viewholder.txtview.setText(data.getItems());
        viewholder.chkbox.setChecked(false);
        if(itemChecked[pos]) {
            viewholder.chkbox.setChecked(true);
        }
        else {
            viewholder.chkbox.setChecked(false);
        }
        viewholder.chkbox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vie1){
                if(viewholder.chkbox.isChecked())
                    itemChecked[pos]=true;
                else
                    itemChecked[pos]=false;
            }
        }
        );

        return vie;
    }
    private static class ViewHolder{
        TextView txtview;
        CheckBox chkbox;
    }
}
