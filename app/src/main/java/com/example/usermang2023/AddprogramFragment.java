package com.example.usermang2023;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddprogramFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddprogramFragment extends Fragment {
    private EditText namepf, countrypf, aboutpf, volunteertype, links;
    private FirebaseService fbs;
    private Button addpr;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddprogramFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddprogramFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddprogramFragment newInstance(String param1, String param2) {
        AddprogramFragment fragment = new AddprogramFragment();
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
        return inflater.inflate(R.layout.fragment_addprogram, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        hudaifa();
    }

    private void hudaifa() {
        fbs = FirebaseService.getInstance();
        namepf = getView().findViewById(R.id.nameAddpf);
        countrypf = getView().findViewById(R.id.countryAddpf);
        aboutpf = getView().findViewById(R.id.aboutAddPF);
        volunteertype = getActivity().findViewById(R.id.volunteerAddpf);
        links = getActivity().findViewById(R.id.linkAddpf);
        addpr=getActivity().findViewById(R.id.btnAddprogrampf);

        addpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Program program= new Program( namepf.getText().toString(), countrypf.getText().toString(),volunteertype.getText().toString(), aboutpf.getText().toString(),links.getText().toString());
                fbs.getFire().collection("program").add(program)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentreference) {

                                //log.d(Tag,"DocumentSnapshot succesfully written!");
                                try {
                                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                    ft.replace(R.id.Basel, new ProgramshowFragment());
                                    ft.commit();
                                }
                                catch (Exception ex)
                                {
                                    Log.d("", ex.getMessage());
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //log.w(TAG,"Error writing document",e);

                            }
                        });
            }
        });

    }

}