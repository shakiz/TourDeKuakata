package com.shakil.tourdekuakata.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.adapters.Hotel;
import com.shakil.tourdekuakata.adapters.HotelListAdapter;
import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    private RecyclerView recyclerView;
    private HotelListAdapter hotelListAdapter;
    private ArrayList<Hotel> hotelList;

    public HotelsFragment() {
    }


    public static HotelsFragment newInstance(String param1, String param2) {
        HotelsFragment fragment = new HotelsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static HotelsFragment newInstance() {
        HotelsFragment fragment = new HotelsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        init(view);
        createInstances();
        bindUIWithComponents();
        return view;
    }

    private void createInstances() {
        hotelList = new ArrayList<>();
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
    }

    private void bindUIWithComponents() {
        setAdapter();
    }

    private void setAdapter() {
        hotelListAdapter = new HotelListAdapter(hotelList,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(hotelListAdapter);
        hotelListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
