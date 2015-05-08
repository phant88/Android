package com.example.lucascoaquira.gnirak.audiolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lucascoaquira.gnirak.R;

/**
 * Created by Lucas Coaquira on 07/05/2015.
 */
public class ListAudio extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.audio_list, container, false);
    }
}
