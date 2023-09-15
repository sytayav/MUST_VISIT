package it.visit.mustvisit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivityRed extends AppCompatActivity {

    SearchView searchView;
    ListView listView;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_red);

        searchView = findViewById(R.id.searchViewRed);
        listView = findViewById(R.id.listViewRed);
        listView.setVisibility(View.GONE);

        arrayList = new ArrayList<>();
        arrayList.add("Mac");
        arrayList.add("Mab");
        arrayList.add("Men");
        arrayList.add("Menra");
        arrayList.add("Mev");

        adapter = new ArrayAdapter<>(this, R.layout.my_list_item, arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                listView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }

}