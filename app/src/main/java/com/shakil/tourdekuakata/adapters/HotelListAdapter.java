package com.shakil.tourdekuakata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.models.Hotel;
import java.util.ArrayList;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private ArrayList<Hotel> hotelList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public HotelListAdapter(ArrayList<Hotel> hotelList, Context context,OnItemClickListener itemClickListener) {
        this.hotelList = hotelList;
        this.context = context;
        this.onItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_layout_hotels,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Hotel hotel = hotelList.get(position);
        holder.bind(hotel,onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Icon;
        TextView HotelName,MobileNumber;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Icon = itemView.findViewById(R.id.Icon);
            HotelName = itemView.findViewById(R.id.HotelName);
            MobileNumber = itemView.findViewById(R.id.MobileNumber);
            cardView = itemView.findViewById(R.id.mainLayout);
        }

        public void bind(final Hotel hotel, final OnItemClickListener listener) {
            HotelName.setText(hotel.getHotelName());
            MobileNumber.setText(hotel.getMobileNumber());
            Glide.with(context).load(hotel.getIcon()).into(Icon);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hotel);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Hotel hotel);
    }


}