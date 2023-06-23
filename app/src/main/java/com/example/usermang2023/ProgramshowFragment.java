package com.example.usermang2023;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgramshowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgramshowFragment extends Fragment implements ProgramshowInterface {

    RecyclerView recyclerView;
    ArrayList<Program> programsArrayList;
    private programadapter adapterprogram;
    FirebaseFirestore gg;
    ProgressDialog progressDialog;
    //private RecyclerView recyclerView;
    //private programadapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProgramshowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgramshowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgramshowFragment newInstance(String param1, String param2) {
        ProgramshowFragment fragment = new ProgramshowFragment();
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
      /* getActivity().setContentView(R.layout.activity_start);

        // Initialize RecyclerView and adapter
        recyclerView = getView().findViewById(R.id.Manasra);
        adapterprogram = new programadapter(getActivity(),programsArrayList);

        // Set the click listener
        adapterprogram.setOnItemClickListener((programadapter.OnItemClickListener) getActivity());

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapterprogram);
    }
    public void onItemClick(int position) {
        // Handle item click event
        // You can access the clicked item using the position parameter*/

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programshow, container, false);
    }
  /*  public interface OnItemClickListener {
        void onItemClick(int position);
    }*/

    @Override
    public void onStart() {
        super.onStart();

        progressDialog= new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetcjing Data... ");
        progressDialog.show();

        recyclerView=getView().findViewById(R.id.Manasra);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        gg = FirebaseFirestore.getInstance();
        programsArrayList = new ArrayList<Program>();
        adapterprogram=new programadapter(getActivity(),programsArrayList,this);

        recyclerView.setAdapter(adapterprogram);

        try {

            EventChangeListener();
        }
        catch (Exception exception)
        {
            Log.e("onStart: ", exception.getMessage());
        }
    }

    private void EventChangeListener() {
        gg.collection("program").orderBy("name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error!= null){
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("FireStore error",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc: value.getDocumentChanges()){

                            if (dc.getType()==DocumentChange.Type.ADDED) {


                                programsArrayList.add(dc.getDocument().toObject(Program.class));


                            }

                        }
                        adapterprogram.notifyDataSetChanged();
                        if(progressDialog.isShowing())
                            progressDialog.dismiss();

                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        /*Intent intent = new Intent(getActivity(), Explain.class);
        startActivity(intent);*/
       FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.Basel, new Programexplain(programsArrayList.get(position).getAbout(),programsArrayList.get(position).getLink()));
        ft.commit();

        //programsArrayList.get(position).getAbout(),programsArrayList.get(position).getLink())
        /*(getActivity(),  programsArrayList.get(position).getAbout()+" " +
                " "+programsArrayList.get(position).getLink(), Toast.LENGTH_SHORT).show();*/

    }
}