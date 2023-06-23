package com.example.usermang2023;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class programadapter extends RecyclerView.Adapter<com.example.usermang2023.programadapter.MyViewHolder>{
   // private programadapter.OnItemClickListener listener;
        private final ProgramshowInterface programshowInterface;
        //private static final int FIVE_MEGABYTE=5000000;

        Context context;
        ArrayList<Program> programArrayList;


    /*  public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }*/

    // ViewHolder and other methods...

    public programadapter(Context context,ArrayList<Program> programArrayList,ProgramshowInterface programshowInterface) {
            this.context = context;
            this.programArrayList = programArrayList;
            this.programshowInterface=programshowInterface;
        }

        @NonNull
        @Override
        public com.example.usermang2023.programadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v= LayoutInflater.from(context).inflate(R.layout.programitem,parent,false );
            return new MyViewHolder(v, programshowInterface);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.usermang2023.programadapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
           /* holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(position);
                    }
                }
            });*/
            Program program=programArrayList.get(position);
            holder.name.setText(program.getName());
            holder.country.setText(program.getCountry());
            //holder.about.setText(program.getAbout());
            holder.volunteerrype.setText(program.getVolunteerrype());
           // holder.link.setText(program.getLink());
        }

        @Override
        public int getItemCount() {
            return programArrayList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView name,country,about,volunteerrype,link;
            public MyViewHolder(@NonNull View itemView,ProgramshowInterface programshowInterface) {
                super(itemView);
                name= itemView.findViewById(R.id.tvname);
                volunteerrype= itemView.findViewById(R.id.tvVolunteertype);
                //about=itemView.findViewById(R.id.tvabout);
                country= itemView.findViewById(R.id.tvCountryprogram);
               // link= itemView.findViewById(R.id.tvLink);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(programshowInterface!= null){
                            int pos= getAdapterPosition();
                            if( pos!= RecyclerView.NO_POSITION){
                                programshowInterface.onItemClick(pos);
                            }

                        }
                    }
                });


            }
        }
    }


