package com.akatsuki777crossroads2014;

import com.akatsuki777crossroads2014.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Schedule extends Fragment{
	
	private WebView webView;
     
    public Schedule(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.shedule_activity, container, false);
      
          
        return rootView;
    }
}