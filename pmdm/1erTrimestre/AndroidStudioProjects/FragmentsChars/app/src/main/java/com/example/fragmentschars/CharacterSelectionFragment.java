package com.example.fragmentschars;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterSelectionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView iv1, iv2, iv3;
    public interface OnCharacterChange {
        void onCharacterChange(GameCharacter gameCharacter, CharacterSelectionFragment fragment);

    }
    OnCharacterChange listener;




    public CharacterSelectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterSelectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterSelectionFragment newInstance(String param1, String param2) {
        CharacterSelectionFragment fragment = new CharacterSelectionFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_character_selection, container, false);
        iv1 = layout.findViewById(R.id.iv1);
        iv2 = layout.findViewById(R.id.iv2);
        iv3 = layout.findViewById(R.id.iv3);
        iv1.setTag(GameCharacter.FRODO);
        iv2.setTag(GameCharacter.GANDALF);
        iv3.setTag(GameCharacter.LEGOLAS);



        View.OnClickListener handler = view -> {
            ImageView imageView = (ImageView) view;
            if (imageView.getTag().equals(GameCharacter.FRODO)){
                listener.onCharacterChange(GameCharacter.FRODO, this);
            } else if (imageView.getTag().equals(GameCharacter.GANDALF)) {
                listener.onCharacterChange(GameCharacter.GANDALF, this);
            } else if (imageView.getTag().equals(GameCharacter.LEGOLAS)) {
                listener.onCharacterChange(GameCharacter.LEGOLAS, this);
            }

//            int currenIntScore = Integer.parseInt(currentScore);
//            currenIntScore += 1;
//            button.setText(String.valueOf(currenIntScore));
//            if(currenIntScore >= MAX_SCORE){
//                textViewField.setVisibility(View.GONE);
//                buttonRed.setVisibility(View.GONE);
//                buttonBlue.setVisibility(View.GONE);
//                textViewCourt.setVisibility(View.GONE);
//                listener.onGameEnd(courtName + " ->  Red " + buttonRed.getText() + " - " + buttonBlue.getText() + " Blue");
//            }
        };

        iv1.setOnClickListener(handler);
        iv2.setOnClickListener(handler);
        iv3.setOnClickListener(handler);
        return layout;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnCharacterChange){
            listener = (OnCharacterChange) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement gameEndListener interface");
        }
    }
}