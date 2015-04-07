package com.example.lucascoaquira.gnirak;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Lucas Coaquira on 20/03/2015.
 */
public class TouchListener implements View.OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                v.setVisibility(View.INVISIBLE);
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
                break;
            case MotionEvent.ACTION_CANCEL:
                v.setVisibility(View.VISIBLE);
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                break;
            default:
                break;

        }

        return true;
    }
}
