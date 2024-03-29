package com.akatsuki777crossroads2014;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.akatsuki777.crossroads2014.adapter.NavDrawerListAdapter;
import com.akatsuki777.crossroads2014.navigate.NavigateDrawer;


public class MainActivity extends FragmentActivity {
	    private DrawerLayout mDrawerLayout;
	    private ListView mDrawerList;
	    private ActionBarDrawerToggle mDrawerToggle;
	 
	   
	    private CharSequence mDrawerTitle;
	 
	    
	    private CharSequence mTitle;
	 
	    
	    private String[] navMenuTitles;
	    private TypedArray navMenuIcons;
	 
	    private ArrayList<NavigateDrawer> NavigateDrawers;
	    private NavDrawerListAdapter adapter;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	 
	        mTitle = mDrawerTitle = getTitle();
	 
	        
	        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
	 
	        
	        navMenuIcons = getResources()
	                .obtainTypedArray(R.array.nav_drawer_icons);
	 
	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
	 
	        NavigateDrawers = new ArrayList<NavigateDrawer>();
	 
	        
	        NavigateDrawers.add(new NavigateDrawer(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
	       
	        NavigateDrawers.add(new NavigateDrawer(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
	        
	        NavigateDrawers.add(new NavigateDrawer(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
	        
	        NavigateDrawers.add(new NavigateDrawer(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
	        
	         
	 
	        
	        navMenuIcons.recycle();
	 
	        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
	 
	        
	        adapter = new NavDrawerListAdapter(getApplicationContext(),
	                NavigateDrawers);
	        mDrawerList.setAdapter(adapter);
	 
	        
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        getActionBar().setHomeButtonEnabled(true);
	 
	        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
	                R.drawable.icon_drawer, 
	                R.string.app_name, 
	                R.string.app_name 
	        ) {
	            public void onDrawerClosed(View view) {
	                getActionBar().setTitle(mTitle);
	                
	                invalidateOptionsMenu();
	            }
	 
	            public void onDrawerOpened(View drawerView) {
	                getActionBar().setTitle(mDrawerTitle);
	                
	                invalidateOptionsMenu();
	            }
	        };
	        mDrawerLayout.setDrawerListener(mDrawerToggle);
	 
	        if (savedInstanceState == null) {
	            
	            displayView(0);
	        }
	    }
	 
	    /**
	     * Slide menu item click listener
	     * */
	    private class SlideMenuClickListener implements
	            ListView.OnItemClickListener {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position,
	                long id) {
	            
	            displayView(position);
	        }
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	 
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	        }
	        
	        switch (item.getItemId()) {
	        case R.id.action_settings:
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	 
	   
	    @Override
	    public boolean onPrepareOptionsMenu(Menu menu) {
	        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
	        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
	        return super.onPrepareOptionsMenu(menu);
	    }
	 
	    /**
	     * Diplaying fragment view for selected nav drawer list item
	     * */
	    private void displayView(int position) {
	        // update the main content by replacing fragments
	        Fragment fragment = null;
	        switch (position) {
	        case 0:
	            fragment = new Home();
	            break;
	        case 1:
	            fragment = new Schedule();
	            break;
	        case 2:
	            fragment = new Photos();
	            break;
	        case 3:
	            fragment = new About();
	            break;
	 
	        default:
	            break;
	        }
	 
	        if (fragment != null) {
	            FragmentManager fragmentManager = getSupportFragmentManager();
	            fragmentManager.beginTransaction()
	                    .replace(R.id.frame_container, fragment).commit();
	 
	            // update selected item and title, then close the drawer
	            mDrawerList.setItemChecked(position, true);
	            mDrawerList.setSelection(position);
	            setTitle(navMenuTitles[position]);
	            mDrawerLayout.closeDrawer(mDrawerList);
	        } 
	    }
	 
	    @Override
	    public void setTitle(CharSequence title) {
	        mTitle = title;
	        getActionBar().setTitle(mTitle);
	    }
	 
	   
	 
	    @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	       
	        mDrawerToggle.syncState();
	    }
	 
	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }
	 
	}

