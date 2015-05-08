package com.example.lucascoaquira.gnirak;


import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class RadioFragment extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, View.OnClickListener {

    MediaPlayer mp;
    View frgView;
    final String URLStream = "http://142.4.217.133:8856/live";

    enum estadoRadio {stop, playing}

    estadoRadio radioState;

    public RadioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frgView = inflater.inflate(R.layout.fragment_radio, container, false);
        ImageView imgBtn = (ImageView) frgView.findViewById(R.id.playerBtn);
        imgBtn.setOnClickListener(RadioFragment.this);
        radioState = estadoRadio.stop;
        mp = new MediaPlayer();
        // Inflate the layout for this fragment
        return frgView;
    }


    /*Radio callbacks*/
    @Override
    public void onPrepared(MediaPlayer mp) {
        chgMessageRadio(getString(R.string.RadioMessage) + " .... Playing");
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        chgMessageRadio(getString(R.string.RadioMessage) + "Solo para ti");
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        //progress.dismiss();
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            radioState = estadoRadio.stop;
        }
        return false;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mp != null && mp.isPlaying()) {
            StopRadio();
        }
    }

    @Override
    public void onClick(View v) {
        switch (radioState) {
            case stop:
                IniciarRadio();
                break;
            case playing:
                StopRadio();
                break;
            default:
        }
        chgImgController();
    }

    private void IniciarRadio() {
        try {
            chgMessageRadio(getString(R.string.RadioMessage) + " .... Iniciando");
            mp.setDataSource(URLStream);
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    Activity activity = getActivity();
                    if (activity != null) {
                        Log.d("RadioStream", "Radio ->" + percent);
                    }
                }

            });
            mp.prepareAsync();
            mp.setOnPreparedListener(RadioFragment.this);
            mp.setOnCompletionListener(RadioFragment.this);
            radioState = estadoRadio.playing;
        } catch (IOException exception) {
            Log.e("AudioDemo", exception.getMessage());
            chgMessageRadio(getString(R.string.RadioMessage) + ".. ERROR!!");
        }
    }

    private void StopRadio() {
        mp.stop();
        chgMessageRadio(getString(R.string.RadioMessage));
        mp.reset();
        radioState = estadoRadio.stop;
    }

    private void chgImgController() {
        switch (radioState) {
            case playing:
                frgView.findViewById(R.id.playerBtn).setBackgroundResource(R.drawable.stop);
                break;
            case stop:
                frgView.findViewById(R.id.playerBtn).setBackgroundResource(R.drawable.playbutton);
                break;
            default:
        }
    }

    private void chgMessageRadio(String message) {
        TextView radioTitle = (TextView) frgView.findViewById(R.id.radioTitle);
        radioTitle.setText(message);
    }
}
