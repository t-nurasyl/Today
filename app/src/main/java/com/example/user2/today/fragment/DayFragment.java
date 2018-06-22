package com.example.user2.today.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user2.today.R;

public class DayFragment extends Fragment {
    TextView title;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        title = (TextView) view.findViewById(R.id.textView);

//        String username = this.getArguments().getString("name").toString();
//        System.out.println(username);
//
//        title.setText(username);

        return view;}

    public interface OnfragmentInteractionListener {
    }
}
