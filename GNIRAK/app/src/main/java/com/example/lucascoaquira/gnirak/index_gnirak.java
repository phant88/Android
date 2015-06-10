package com.example.lucascoaquira.gnirak;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


public class index_gnirak extends FragmentActivity {

    Handler handler;
    ThreadKaring thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_gnirak);
        handler = new Handler();
        thread = new ThreadKaring(this.getBaseContext(),this,handler);
        handler.postDelayed(thread,100000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(thread);
    }
}
