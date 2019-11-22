package com.shakil.tourdekuakata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.models.Place;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.List;

public class PlacesSliderAdapter extends SliderViewAdapter<PlacesSliderAdapter.SliderAdapterVH> {

    private List<Place> placeList;
    private Context context;

    public PlacesSliderAdapter(List<Place> placeList, Context context) {
        this.placeList = placeList;
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout_places
                , null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Place place = placeList.get(position);
        viewHolder.Description.setText(place.getDescription());
        Glide.with(context).load(place.getIcon()).into(viewHolder.Icon);
    }

    @Override
    public int getCount() {
        return placeList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView Icon;
        TextView Description;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            Icon = itemView.findViewById(R.id.Icon);
            Description = itemView.findViewById(R.id.Description);
            this.itemView = itemView;
        }
    }
}