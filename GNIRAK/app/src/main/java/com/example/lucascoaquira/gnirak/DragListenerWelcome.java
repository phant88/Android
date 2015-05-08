package com.example.lucascoaquira.gnirak;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Coaquira on 20/03/2015.
 */
public class DragListenerWelcome implements View.OnDragListener {
    Drawable enterShape;
    Drawable normalShape;
    List<LoveData> loveItems;

    public DragListenerWelcome(Drawable enter, Drawable normal, List<LoveData> items) {
        enterShape = enter;
        normalShape = normal;
        loveItems = items;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        LoveData itemLucas = new LoveData("Lucas WOLF", "Tontus Dramaticus", R.drawable.lobo);
        LoveData itemKaring = new LoveData("Karing SHEEP", "Lindis Princesus", R.drawable.oveja);

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
                final View rootView = (View)owner.getRootView();
                owner.removeView(view);
                ListView lstView = (ListView) rootView.findViewById(R.id.listLove);
                switch (view.getId()) {
                    case R.id.imgBtnLobo:
                        loveItems.add(itemLucas);
                        break;
                    case R.id.imgBtnOveja:
                        loveItems.add(itemKaring);
                        break;
                    default:
                }

                ((BaseAdapter)lstView.getAdapter()).notifyDataSetChanged();

                if(lstView.getAdapter().getCount()==2){
                    Toast message = Toast.makeText(view.getContext(),"Ahora si podemos jugar!!", Toast.LENGTH_LONG);
                    message.show();
                    ImageView imageChng = (ImageView)rootView.findViewById(R.id.imgLock);
                    imageChng.setImageResource(R.drawable.love);
                    imageChng.setClickable(true);
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
