package com.nwhacks.connieho.sampleapplication.activity;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nwhacks.connieho.sampleapplication.R;
import com.nwhacks.connieho.sampleapplication.application.WiFindApplication;
import com.nwhacks.connieho.sampleapplication.datatype.WifiNetwork;

import java.util.ArrayList;
import java.util.List;

public class SavedNetworksActivity extends ListActivity {

    ListView listView;

    private static final String TAG = SavedNetworksActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        listView = getListView();

        List<WifiNetwork> networks = ((WiFindApplication) getApplication())
                .getGlobalServices()
                .getNetworkRepository()
                .getAllSavedNetworks();

        List<String> list = new ArrayList<>();
        for(WifiNetwork n : networks) {
            list.add(n.getSsid());
        }

        listView.setAdapter(new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.list_item,
                R.id.label,
                list
        ));

    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

}