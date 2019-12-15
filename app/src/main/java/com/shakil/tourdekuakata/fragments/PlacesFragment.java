package com.shakil.tourdekuakata.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private String[] placeTitleArray;

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
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        createInstances();
        bindUIWithComponents();
    }

    private void init(View view) {
        sliderView = view.findViewById(R.id.Slider);
        placeTitleArray = getResources().getStringArray(R.array.place_name);
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
        placeList.add(new Place(placeTitleArray[0],R.drawable.kuakata,getResources().getString(R.string.kuakata)));
        placeList.add(new Place(placeTitleArray[1],R.drawable.local_delicacies,getResources().getString(R.string.local_delicacies)));
        placeList.add(new Place(placeTitleArray[2],R.drawable.bike_ride_seah_shore,getResources().getString(R.string.bike_ride)));
        placeList.add(new Place(placeTitleArray[3],R.drawable.fatrar_chor,getResources().getString(R.string.fatrar_chor)));
        placeList.add(new Place(placeTitleArray[4],R.drawable.jhau_bon_2,getResources().getString(R.string.jhau_bon)));
        placeList.add(new Place(placeTitleArray[5],R.drawable.buddhist_temple,getResources().getString(R.string.buddhist_temples)));
        placeList.add(new Place(placeTitleArray[6],R.drawable.lebur_chor,getResources().getString(R.string.lebur_chor)));
        placeList.add(new Place(placeTitleArray[7],R.drawable.shutki_polly,getResources().getString(R.string.shutki_polli)));
        return placeList;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
