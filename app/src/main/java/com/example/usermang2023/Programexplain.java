package com.example.usermang2023;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Programexplain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Programexplain extends Fragment {
    TextView aboutex,link1,name;
    String about = "", link = "";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Programexplain() {
        // Required empty public constructor
    }

    public Programexplain(String about ,String link) {
        // Required empty public constructor
        this.about=about;
        this.link=link;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Programexplain.
     */
    // TODO: Rename and change types and number of parameters
    public static Programexplain newInstance(String param1, String param2) {
        Programexplain fragment = new Programexplain();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programexplain, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
       aboutex=getView().findViewById(R.id.explain);
        link1=getView().findViewById(R.id.Linkexplain);
       // name=getView().findViewById(R.id.about);

        aboutex.setText(about);
        link1.setText("Link: "+link);


    }
}