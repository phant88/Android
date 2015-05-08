package com.example.lucascoaquira.gnirak.audiolist;

/**
 * Created by Lucas Coaquira on 06/04/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucascoaquira.gnirak.LoveData;
import com.example.lucascoaquira.gnirak.R;

import java.util.ArrayList;
import java.util.List;

public class AudioListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<AudioData> loveItems;

    public AudioListAdapter(List<AudioData> loveItems, Activity activity) {
        this.loveItems = loveItems;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return loveItems.size();
    }

    @Override
    public Object getItem(int position) {
        return loveItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_audio, null);

        /*if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);*/
        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.playerBtn);
        TextView title = (TextView) convertView.findViewById(R.id.titleAudio);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionAudio);

        // getting movie data for the row
        AudioData m = loveItems.get(position);

        // thumbnail image
        thumbNail.setImageResource(m.getImageID());

        // title
        title.setText(m.getTitle());

        description.setText(m.getDescription());

        return convertView;
    }

    public void addItem(AudioData item){
        if(loveItems == null){
            loveItems = new ArrayList<AudioData>();
        }
        loveItems.add(item);
    }
}
