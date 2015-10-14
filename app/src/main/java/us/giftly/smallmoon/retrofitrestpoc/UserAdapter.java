package us.giftly.smallmoon.retrofitrestpoc;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import models.User;

/**
 * Created by Alec on 10/8/2015.
 */
public class UserAdapter extends BaseAdapter {
    private List<User> users;
    private Context context;

    public UserAdapter(Context context, List<User> users){
        super();
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.cell, parent, false);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        User user = users.get(position);
        tv.setText(user.getFname());
        Log.d("Adapter", user.getFname());
        return v;
    }
}
