package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private String[] titleNames;
    private String[] detailsNames;

    List<String> listTitle;
    HashMap <String, List<String>> listDetails;

    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeListData();

        expandableListView = findViewById(R.id.expandableId);

        customAdapter = new CustomAdapter(this, listTitle, listDetails);
        expandableListView.setAdapter(customAdapter);


        // Expand Listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                String titleName = listTitle.get(i);
                Toast.makeText(getApplicationContext(),titleName + " is expand", Toast.LENGTH_SHORT).show();
            }
        });


        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                String titleName = listTitle.get(i);
                Toast.makeText(getApplicationContext(),titleName + " is collapse", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void makeListData() {
        titleNames = getResources().getStringArray(R.array.title_names);
        detailsNames = getResources().getStringArray(R.array.details_names);

        listTitle = new ArrayList<>();
        listDetails = new HashMap<>();

        for (int i=0; i<titleNames.length; i++){

            listTitle.add(titleNames[i]);

            List<String> details = new ArrayList<>();
            details.add(detailsNames[i]);

            listDetails.put(listTitle.get(i),details);
        }
    }
}