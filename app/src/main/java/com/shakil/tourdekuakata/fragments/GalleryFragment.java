package com.shakil.tourdekuakata.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.adapters.GalleryListAdapter;
import com.shakil.tourdekuakata.models.GalleyItem;
import java.util.ArrayList;
import dmax.dialog.SpotsDialog;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;
    private GalleryListAdapter galleryListAdapter;
    private ArrayList<GalleyItem> galleyItemList;
    private AlertDialog progressDialog;
    private TextView profileTextView;

    public GalleryFragment() {

    }

    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static GalleryFragment newInstance() {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
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
        galleyItemList = new ArrayList<>();
        progressDialog = new SpotsDialog(getContext(),R.style.CustomProgressDialog);
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

        profileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://121clicks.com/photo-stories/life-in-kuakata-by-nafi-sami"));
                startActivity(browserIntent);
            }
        });
    }
    private void setAdapter() {
        galleryListAdapter = new GalleryListAdapter(getData(), getContext(), new GalleryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GalleyItem galleyItem) {

            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(galleryListAdapter);
        galleryListAdapter.notifyDataSetChanged();
    }

    private ArrayList<GalleyItem> getData() {
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_4,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_5,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_6,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_7,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_8,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_9,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_10,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_11,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_12,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_13,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_14,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_15,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_16,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_17,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_18,"Landscape"));
        galleyItemList.add(new GalleyItem(R.drawable.kuakata_19,"Landscape"));
        return galleyItemList;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.mRecyclerView);
        profileTextView = view.findViewById(R.id.ProfileUrl);
    }
}
