package com.example.root.exercicefragment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.exercicefragment.Items;
import com.example.root.exercicefragment.R;

public class DetailFragment extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            if(getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);

        tvTitle.setText(Items.Menu[position]);
        tvDetails.setText(Items.Details[position]);
    }

    public void updateView(int position){
        tvTitle.setText(Items.Menu[position]);
        tvDetails.setText(Items.Details[position]);
    }
}
