package com.example.spinner;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.spinner.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<String> parentTitleList = new ArrayList<>();
    private List<List<String>> childTitleList = new ArrayList<>();
    private List<String> dataList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initViews();
        initListener();
    }

    private void initViews() {

        parentTitleList.add("Title 1");
        parentTitleList.add("Title 2");
        parentTitleList.add("Title 3");
        parentTitleList.add("Title 4");
        parentTitleList.add("Title 5");

        for (int i = 1; i <= parentTitleList.size(); i++) {

            List<String> childItem = new ArrayList<>();

            for (int i1 = 1; i1 <= 5; i1++) {

                childItem.add(parentTitleList.get(i - 1) + " : " + i1);

            }

            childTitleList.add(childItem);
        }

        adapter = new ArrayAdapter<String>(this, R.layout.layout_spinner, R.id.titleTv, parentTitleList);
        binding.parentSpinner.setAdapter(adapter);
        dataList = childTitleList.get(0);
        adapter1 = new ArrayAdapter<String>(this, R.layout.layout_spinner, R.id.titleTv, dataList);
        binding.childSpinner.setAdapter(adapter1);

    }

    private void initListener() {

        binding.parentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                changeChildSpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void changeChildSpinner(int position) {

        dataList = childTitleList.get(position);
        adapter1 = new ArrayAdapter<String>(this, R.layout.layout_spinner, R.id.titleTv, dataList);
        binding.childSpinner.setAdapter(adapter1);

    }
}
