package com.example.musync;

import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
public class MoodAdapter extends BaseAdapter {
    private final Context context;
    private final String[] moods;

    public MoodAdapter(Context context, String[] moods) {
        this.context = context;
        this.moods = moods;
    }

    @Override
    public int getCount() {
        return moods.length;
    }

    @Override
    public Object getItem(int position) {
        return moods[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text = new TextView(context);
        text.setText(moods[position]);
        text.setTextColor(0xFFFFFFFF);
        text.setBackgroundColor(0xFF2E2E2E);
        text.setGravity(Gravity.CENTER);
        text.setPadding(20, 40, 20, 40);
        return text;
    }

}
