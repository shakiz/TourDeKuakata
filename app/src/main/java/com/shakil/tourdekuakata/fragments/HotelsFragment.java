package com.shakil.tourdekuakata.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.models.Hotel;
import com.shakil.tourdekuakata.adapters.HotelListAdapter;
import java.util.ArrayList;
import dmax.dialog.SpotsDialog;

public class HotelsFragment extends Fragment {

    private RecyclerView recyclerView;
    private HotelListAdapter hotelListAdapter;
    private ArrayList<Hotel> hotelList;
    private String[] hotelNames;
    private String[] phoneNumbersHotel;
    private Dialog itemDialog;
    private RelativeLayout dialogLayout;
    private AlertDialog progressDialog;
    private TextView HotelName,MobileNumber,FacebookPage;
    private ImageView HotelIcon;

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
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        createInstances();
        bindUIWithComponents();
    }

    private void createInstances() {
        hotelList = new ArrayList<>();
        hotelNames = getResources().getStringArray(R.array.hotel_names);
        phoneNumbersHotel = getResources().getStringArray(R.array.phone_numbers);
        progressDialog = new SpotsDialog(getContext(),R.style.CustomProgressDialog);
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
    }

    private void bindUIWithComponents() {
        progressDialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    setAdapter();
                }
            }
        }, 1000);

    }

    private void setAdapter() {
        hotelListAdapter = new HotelListAdapter(getData(), getContext(), new HotelListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Hotel hotel) {
                showDialog(hotel);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(hotelListAdapter);
        hotelListAdapter.notifyDataSetChanged();
    }

    private ArrayList<Hotel> getData() {
        for(int index=0;index<hotelNames.length;index++){
            hotelList.add(new Hotel(R.drawable.ic_hotel,phoneNumbersHotel[index],hotelNames[index]));
        }
        return hotelList;
    }

    private void showDialog(Hotel hotel) {
        itemDialog = new Dialog(getContext());
        itemDialog.setContentView(R.layout.hotel_details_layout);
        customViewInit(itemDialog);
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        setCustomLayoutData(hotel);
        itemDialog.show();

        MobileNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(getContext(),R.string.permission_request,Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},0);
                }
                else{
                    makeCall(MobileNumber.getText().toString());
                }
            }
        });

        FacebookPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Coming soon...",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCustomLayoutData(Hotel hotel) {
        HotelName.setText(hotel.getHotelName());
        MobileNumber.setText(hotel.getMobileNumber());
        Glide.with(getContext()).load(hotel.getIcon()).into(HotelIcon);
    }

    private void customViewInit(Dialog itemDialog) {
        dialogLayout = itemDialog.findViewById(R.id.hotel_details_layout);
        HotelName = itemDialog.findViewById(R.id.HotelName);
        MobileNumber = itemDialog.findViewById(R.id.MobileNumber);
        FacebookPage = itemDialog.findViewById(R.id.FacebookPage);
        HotelIcon = itemDialog.findViewById(R.id.HotelImage);
    }

    private void makeCall(String number){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +number));
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
