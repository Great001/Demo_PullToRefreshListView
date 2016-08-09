package com.example.dw.yy;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnRefreshListview,mBtnExpandableListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Demo");
        setSupportActionBar(toolbar);

        mBtnExpandableListview=(Button)findViewById(R.id.btn_expandableListView);
        mBtnRefreshListview=(Button)findViewById(R.id.btn_pull_to_refresh_listview);


        mBtnRefreshListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.add(R.id.container,new PullToRefreshListViewFragment());
                ft.addToBackStack(null);
                ft.commitAllowingStateLoss();

            }
        });

        mBtnExpandableListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.add(R.id.container,new ExpandableListFragment());
                ft.addToBackStack(null);
                ft.commitAllowingStateLoss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
