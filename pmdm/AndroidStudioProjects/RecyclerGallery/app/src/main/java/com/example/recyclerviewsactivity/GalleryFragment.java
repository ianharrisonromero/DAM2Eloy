package com.example.recyclerviewsactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ArrayList<GalleryGameModel> gameList;
    private GalleryGameAdapter galleryGameAdapter;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_game, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        gameList = getSampleData(); // Simulated data from API
        galleryGameAdapter = new GalleryGameAdapter(gameList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(galleryGameAdapter);

        return view;
    }

    private ArrayList<GalleryGameModel> getSampleData() {
        // Simulate data fetched from an API
        ArrayList<GalleryGameModel> sampleData = new ArrayList<>();
        sampleData.add(new GalleryGameModel(1, R.drawable.game1photo, "vitality", "2024-03-01 12:00 PM"));
        sampleData.add(new GalleryGameModel(2, R.drawable.game2photo, "etzRitz", "2023-06-02 3:30 PM"));
        sampleData.add(new GalleryGameModel(3, R.drawable.game3photo, "álvaro", "2023-05-02 3:30 PM"));
        sampleData.add(new GalleryGameModel(4, R.drawable.game4photo, "mmhuevo4", "2023-03-02 3:30 PM"));
        sampleData.add(new GalleryGameModel(5, R.drawable.game5photo, "mmhuevo5", "2023-02-02 3:30 PM"));
        sampleData.add(new GalleryGameModel(6, R.drawable.game6photo, "mmhuevo6", "2023-01-02 3:30 PM"));

        // Add more data as needed
        return sampleData;
    }


}