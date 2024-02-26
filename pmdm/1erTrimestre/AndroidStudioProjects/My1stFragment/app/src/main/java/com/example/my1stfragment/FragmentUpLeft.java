package com.example.my1stfragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUpLeft#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUpLeft extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentUpLeft() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentUpLeft.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUpLeft newInstance(String param1, String param2) {
        FragmentUpLeft fragment = new FragmentUpLeft();
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

    TextView tvColor, tvContador;
    int contador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_up_left, container, false);

        tvColor = layout.findViewById(R.id.tvColor);
        tvContador = layout.findViewById(R.id.tvContador);
        //tvHelloWorld = layout.findViewById(R.id.tvHelloWorld);

        tvColor.setOnClickListener(v -> {
            tvColor.setBackgroundColor(Color.argb((int)(Math.random() * 256),
                                        (int)(Math.random() * 256),
                                        (int)(Math.random() * 256),
                                        (int)(Math.random() * 256)));
            contador = Integer.parseInt((String)tvContador.getText());
            contador = increment(contador);
            String contadorString = String.valueOf(contador);
            tvContador.setText(contadorString);

        });


        return layout;
    }

    public int increment(int contador){
        return contador+=1;
    }
}