package com.example.lucascoaquira.gnirak;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class main_gnirak extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    TextView txtWelcome;
    ImageButton imgBtn;
    List<LoveData> loveItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utilCodes.getInstace(this);
        setContentView(R.layout.activity_main_gnirak);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Sweet Smile.ttf");
        txtWelcome.setTypeface(customFont);
        imgBtn = (ImageButton) findViewById(R.id.imgBtnLobo);
        imgBtn.setOnTouchListener(new TouchListener());

        ListView lstLove = (ListView) findViewById(R.id.listLove);
        loveItems = new ArrayList<LoveData>();
        lstLove.setAdapter(new CustomListAdapter(loveItems, this));

        findViewById(R.id.imgBtnOveja).setOnTouchListener(new TouchListener());
        findViewById(R.id.imgBtnLobo).setOnTouchListener(new TouchListener());

        findViewById(R.id.dropLayout).setOnDragListener(new DragListenerWelcome(getResources().getDrawable(R.drawable.shape),
                getResources().getDrawable(R.drawable.shape_droptarget), loveItems));

        findViewById(R.id.imgLock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(main_gnirak.this);
                dialogBuilder.setMessage("¿Aceptas desde este momento continuar un camino juntos?");
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Sí, Acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast msgAceptar = Toast.makeText(main_gnirak.this, "Estaremos juntos siempre", Toast.LENGTH_LONG);
                        msgAceptar.show();
                        Intent intent = new Intent(main_gnirak.this, index_gnirak.class);
                        utilCodes.getInstace(main_gnirak.this).savePreference(utilCodes.ACEPTO_RELACION, "SI");
                        startActivity(intent);
                    }
                });

                dialogBuilder.setNegativeButton("No acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast msgAceptar = Toast.makeText(main_gnirak.this, "Hubiera sido genial, que pena", Toast.LENGTH_LONG);
                        msgAceptar.show();
                        finish();
                    }
                });

                AlertDialog dialogLove = dialogBuilder.create();
                dialogLove.show();

            }
        });
        findViewById(R.id.imgLock).setClickable(false);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        // mViewPager = (ViewPager) findViewById(R.id.pager);
        //mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    public void goToMain(View view) {
        Intent intent = new Intent(this, index_gnirak.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main_gnirak, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_gnirak, container, false);
            return rootView;
        }
    }

}
