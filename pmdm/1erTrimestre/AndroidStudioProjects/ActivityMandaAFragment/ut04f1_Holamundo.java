package com.example.pmdm_2324.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut04f1_Holamundo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut04f1_Holamundo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final double COLOR_RANGE = 256;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ut04f1_Holamundo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut04f1_Holamundo.
     */
    // TODO: Rename and change types and number of parameters
    public static ut04f1_Holamundo newInstance(String param1, String param2) {
        ut04f1_Holamundo fragment = new ut04f1_Holamundo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvHola;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.ut04f1_holamundo, container, false);

        tvHola = layout.findViewById(R.id.ut04f1idtvHola);

        tvHola.setOnClickListener((v)->{
            int c = Color.argb(
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE),
                    (int) (Math.random()*COLOR_RANGE)
            );
            tvHola.setBackgroundColor(c);

            if(observer!=null){
                observer.OnColorChange(c);
            }
        });

        return layout;
    }

    public void setColor(int a, int r, int g, int b){
        tvHola.setBackgroundColor(Color.argb(a, r,g,b));
    }

    public void setText(String msg){
        tvHola.append(msg);
    }

    public interface ICambioColor {
        public void OnColorChange(int c);
    }

    ICambioColor observer;

    public void setColorChangeListener(ICambioColor elQueRecibe){
        observer = elQueRecibe;
    }
}