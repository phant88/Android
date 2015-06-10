package com.example.lucascoaquira.gnirak.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.lucascoaquira.gnirak.R;
import com.example.lucascoaquira.gnirak.RadioFragment;

/**
 * Created by Lucas Coaquira on 07/05/2015.
 */
public class VideoFragment extends Fragment {
    VideoView videoView;
    View videoPlayerView;
    MediaController mediaController;
    String uriPath = "android.resource://";
    boolean isPrepared = false;
    boolean isImgClick = false;
    ImageView imageBg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        videoPlayerView = inflater.inflate(R.layout.video_player, container, false);
        videoView = (VideoView) videoPlayerView.findViewById(R.id.videoView);
        imageBg = (ImageView) videoPlayerView.findViewById(R.id.bgVideo);
        imageBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImgClick= true;
                v.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                StartVideo();
            }
        });
        if (mediaController == null) {
            mediaController = new MediaController(videoPlayerView.getContext());
        }
        try {
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse(uriPath + videoPlayerView.getContext().getPackageName() + "/" + R.raw.proposicion));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        videoView.requestFocus();
        videoView.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                isPrepared = true;
                // videoView.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                StopVideo();
            }
        });
        return videoPlayerView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (videoView != null && videoView.isPlaying()) {
            StopVideo();
        }
    }

    private void StartVideo(){
        if(isPrepared && isImgClick ){
            videoView.start();
        }
    }

    private void StopVideo(){
        isImgClick = false;
        imageBg.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        videoView.stopPlayback();
    }
}
