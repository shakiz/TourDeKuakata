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
import com.shakil.tourdekuakata.models.GalleyItem;
import java.util.ArrayList;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.ViewHolder> {

    private ArrayList<GalleyItem> galleyItemList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public GalleryListAdapter(ArrayList<GalleyItem> galleyItemList, Context context, OnItemClickListener itemClickListener) {
        this.galleyItemList = galleyItemList;
        this.context = context;
        this.onItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_layout_galley_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GalleyItem galleyItem = galleyItemList.get(position);
        holder.bind(galleyItem,onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return galleyItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Icon;
        TextView PlaceName;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Icon = itemView.findViewById(R.id.Icon);
            PlaceName = itemView.findViewById(R.id.PlaceName);
            cardView = itemView.findViewById(R.id.mainLayout);
        }

        public void bind(final GalleyItem galleyItem, final OnItemClickListener listener) {
            PlaceName.setText(galleyItem.getPlaceName());
            Glide.with(context).load(galleyItem.getIcon()).into(Icon);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(galleyItem);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(GalleyItem galleyItem);
    }


}