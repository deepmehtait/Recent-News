package deepmehtait.com.recentnews.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import deepmehtait.com.recentnews.R;
import fragments.Business;
import fragments.Sports;
import fragments.Technology;
import fragments.TopStories;
import modals.SearchQuery;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    static final int DILOG_ID = 0;
    int year_x, month_x, date_x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new setViewAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        final Calendar  c=Calendar.getInstance();
        year_x= c.get(Calendar.YEAR);
        month_x=c.get(Calendar.MONTH);
        date_x=c.get(Calendar.DAY_OF_MONTH);
        int currentItem = viewPager.getCurrentItem();
        if (currentItem == 0) {
            getSupportActionBar().setTitle("Top Stories");
        } else if (currentItem == 1) {
            getSupportActionBar().setTitle("Technology");
        } else if (currentItem == 2) {
            getSupportActionBar().setTitle("Sports");
        } else {
            getSupportActionBar().setTitle("Business");
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("page scrol", " "+ position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("page selected", " "+ position);
                if (position == 0) {
                    getSupportActionBar().setTitle("Top Stories");
                } else if (position == 1) {
                    getSupportActionBar().setTitle("Technology");
                } else if (position == 2) {
                    getSupportActionBar().setTitle("Sports");
                } else {
                    getSupportActionBar().setTitle("Business");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class setViewAdapter extends FragmentPagerAdapter {
        public setViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new TopStories();
            } else if (position == 1) {
                return new Technology();
            } else if (position == 2) {
                return new Sports();
            } else {
                return new Business();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.search:
            {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();
                Button save = (Button) dialog.findViewById(R.id.btn_save);
                Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);
                final CheckBox cbArts = (CheckBox) dialog.findViewById(R.id.artsCheckbox);
                final CheckBox cbFashion = (CheckBox) dialog.findViewById(R.id.FashionCheckbox);
                final CheckBox cbSports = (CheckBox) dialog.findViewById(R.id.sportsCheck);
                final EditText inputSearch = (EditText) dialog.findViewById(R.id.input_search);
                ImageButton imageButton=(ImageButton)dialog.findViewById(R.id.datepicker);
                TextView dateValue = (TextView) dialog.findViewById(R.id.TxtViewDate);
                RadioGroup orderType = (RadioGroup) dialog.findViewById(R.id.toDoRG);
                int id = orderType.getCheckedRadioButtonId();
                View radioButton = orderType.findViewById(id);
                int radioId = orderType.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) orderType.getChildAt(radioId);
                final String RadioSelection = (String) btn.getText();
                dateValue.setText("Date: "+year_x+"-"+month_x+"-"+date_x);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog(DILOG_ID);
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String updatedMonth = month_x <=9 ? "0"+month_x : ""+month_x;
                        String dateString = year_x+""+updatedMonth+""+date_x;
                        String searchQuery = inputSearch.getText().toString();
                        String atTypes = new String();
                        if (cbArts.isChecked()) {
                            atTypes = "Arts";
                        }
                        if (cbFashion.isChecked()) {
                            atTypes += " Fashion";
                        }
                        if (cbSports.isChecked()) {
                            atTypes += " Sports";
                        }
                        SearchQuery sq = new SearchQuery();
                        sq.setArticleType(atTypes);
                        sq.setDateString(dateString);
                        sq.setSearchText(searchQuery);
                        sq.setSortOrder(RadioSelection);
                        Log.d("xx", atTypes+" "+dateString+" "+ searchQuery + " "+ RadioSelection);
                        Intent i = new Intent(dialog.getContext(), searchResult.class);
                        i.putExtra("searchQuery", sq);
                        dialog.getContext().startActivity(i);
                    }
                });
            }
                Log.d("dep", "Main top stories.");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Dialog onCreateDialog(int id){
        if(id == DILOG_ID){
            return new DatePickerDialog(this,dpickerListner,year_x,month_x,date_x);
        }else{
            return null;
        }
    }
    private DatePickerDialog.OnDateSetListener dpickerListner= new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfYear){
            year_x=year;
            month_x=monthOfYear+1;
            date_x=dayOfYear;
            Toast.makeText(getApplicationContext(),year_x+"/"+month_x+"/"+date_x, Toast.LENGTH_SHORT).show();
        }
    };
}
