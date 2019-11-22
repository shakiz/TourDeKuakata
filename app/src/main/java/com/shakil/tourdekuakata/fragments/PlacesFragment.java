package com.shakil.tourdekuakata.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.adapters.PlacesSliderAdapter;
import com.shakil.tourdekuakata.models.Place;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    private SliderView sliderView;
    private PlacesSliderAdapter sliderViewAdapter;
    private ArrayList<Place> placeList;

    public PlacesFragment() {
    }


    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static PlacesFragment newInstance() {
        PlacesFragment fragment = new PlacesFragment();
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
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        init(view);
        createInstances();
        bindUIWithComponents();
        return view;
    }

    private void init(View view) {
        sliderView = view.findViewById(R.id.Slider);
    }

    private void createInstances() {
        placeList = new ArrayList<>();
        sliderViewAdapter = new PlacesSliderAdapter(setData(),getContext());
    }

    private void bindUIWithComponents() {
        sliderView.setSliderAdapter(sliderViewAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorPadding(8);
    }

    private ArrayList<Place> setData(){
        placeList.add(new Place(R.drawable.places,getResources().getString(R.string.sample_description)));
        placeList.add(new Place(R.drawable.places,getResources().getString(R.string.sample_description)));
        placeList.add(new Place(R.drawable.places,getResources().getString(R.string.sample_description)));
        return placeList;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
