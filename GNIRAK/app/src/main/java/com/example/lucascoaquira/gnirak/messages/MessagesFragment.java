package com.example.lucascoaquira.gnirak.messages;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucascoaquira.gnirak.R;

/**
 * Created by Lucas Coaquira on 08/05/2015.
 */

public class MessagesFragment extends Fragment {
    Handler handler;
    View messageView;
    TextView message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        messageView = inflater.inflate(R.layout.messages, container, false);
        message = (TextView) messageView.findViewById(R.id.txtMessage);
        int index = (int) (Math.random() * 16);
        message.setText(getStringId(index));

       /* Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int index = (int) (Math.random() * 16);
                    message.setText(getStringId(index));
                    Log.e("Mensaje","Mensaje aleatorio");
                }catch(Exception e){
                    Log.e("ERROR",e.getMessage());
                    e.printStackTrace();
                }finally {
                    handler.postDelayed(this,500000);
                }

            }
        };
        handler.postDelayed(runnable,500000);*/
        return messageView;
    }

    public void changeMessage(){
        int index = (int) (Math.random() * 16);
        message.setText(getStringId(index));
    }

    private int getStringId(int index) {
        switch (index) {
            case 1:
                return R.string.Message1;
            case 2:
                return R.string.Message2;
            case 3:
                return R.string.Message3;
            case 4:
                return R.string.Message4;
            case 5:
                return R.string.Message5;
            case 6:
                return R.string.Message6;
            case 7:
                return R.string.Message7;
            case 8:
                return R.string.Message8;
            case 9:
                return R.string.Message9;
            case 10:
                return R.string.Message10;
            case 11:
                return R.string.Message11;
            case 12:
                return R.string.Message12;
            case 13:
                return R.string.Message13;
            case 14:
                return R.string.Message14;
            case 15:
                return R.string.Message15;
            case 16:
                return R.string.Message16;
            default:
                return R.string.Message1;
        }
    }
}

