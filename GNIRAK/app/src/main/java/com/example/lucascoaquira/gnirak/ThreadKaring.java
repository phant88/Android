package com.example.lucascoaquira.gnirak;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.lucascoaquira.gnirak.dropbox.PhotoRoulette;
import com.example.lucascoaquira.gnirak.messages.MessagesFragment;

/**
 * Created by Lucas Coaquira on 08/05/2015.
 */
public class ThreadKaring implements Runnable {

    Context context;
    Activity act;
    Handler handler;

    public ThreadKaring(Context cont, Activity activity, Handler hand) {
        context = cont;
        act = activity;
        handler = hand;
    }

    @Override
    public void run() {
        try {
            FragmentManager manager = act.getFragmentManager();
            MessagesFragment fragment = (MessagesFragment) manager.findFragmentById(R.id.messagesFrag);
            fragment.changeMessage();
            PhotoRoulette fragmentBox = (PhotoRoulette)manager.findFragmentById(R.id.photoFragment);
            fragmentBox.cargarImagenDropBox();
        } catch (Exception e) {
            Log.e("ERROR","Error en thread");
        } finally {
            handler.postDelayed(this, 10000);
        }


    }
}
