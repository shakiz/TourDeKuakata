package com.shakil.tourdekuakata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.shakil.tourdekuakata.R;
import java.util.ArrayList;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private ArrayList<Hotel> hotelList;
    private Context context;

    public HotelListAdapter(ArrayList<Hotel> hotelList, Context context) {
        this.hotelList = hotelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_layout_hotels,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hotel hotel = hotelList.get(position);
        holder.HotelName.setText(hotel.getHotelName());
        holder.MobileNumber.setText(hotel.getMobileNumber());
        Glide.with(context).load(hotel.getIcon()).into(holder.Icon);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Icon;
        TextView HotelName,MobileNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Icon = itemView.findViewById(R.id.Icon);
            HotelName = itemView.findViewById(R.id.HotelName);
            MobileNumber = itemView.findViewById(R.id.MobileNumber);
        }
    }
}