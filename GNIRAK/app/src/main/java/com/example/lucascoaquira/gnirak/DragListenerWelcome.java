package com.example.lucascoaquira.gnirak;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Lucas Coaquira on 20/03/2015.
 */
public class DragListenerWelcome implements View.OnDragListener {
    Drawable enterShape;
    Drawable normalShape;

    public DragListenerWelcome(Drawable enter, Drawable normal) {
        enterShape = enter;
        normalShape = normal;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:

                break;
            case DragEvent.ACTION_DRAG_EXITED:

                break;
            case DragEvent.ACTION_DROP:
                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                GridLayout container = (GridLayout) ((LinearLayout) v).findViewById(R.id.loveLayout);
                view.setScaleX(0.2f);
                view.setScaleY(0.2f);
                view.setOnTouchListener(null);
                container.addView(view);
                if (container.getChildCount() == 2) {
                    Toast toast = Toast.makeText(v.getContext(), "Juntos al fin!", Toast.LENGTH_LONG);
                    toast.show();
                }

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        return true;
    }
}
