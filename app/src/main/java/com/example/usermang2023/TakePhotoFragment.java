package com.example.usermang2023;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TakePhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class TakePhotoFragment extends Fragment {
    ImageView imgbtn;
    Button button, takepicture;
    PreferenceManager preferenceManager;
    Intent camera;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TakePhotoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TakePhotoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TakePhotoFragment newInstance(String param1, String param2) {
        TakePhotoFragment fragment = new TakePhotoFragment();
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
        return inflater.inflate(R.layout.fragment_take_photo, container, false);
    }
    public class PreferenceManager {

        private static PreferenceManager INSTANCE;
        private static SharedPreferences preferences;

        synchronized public static PreferenceManager getInstance(Context context){
            if(INSTANCE==null){
                INSTANCE=new PreferenceManager();
                preferences=context.getSharedPreferences("userinfo3",Context.MODE_PRIVATE);
            }
            return INSTANCE;
        }

        public void setString(String key,String value){
            preferences.edit().putString(key, value).apply();
        }

        public String getString(String key){
            return preferences.getString(key,"");
        }

    }




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            imgbtn = getView().findViewById(R.id.imageview);
            button = getView().findViewById(R.id.button3);
            takepicture = getView().findViewById(R.id.clickpicture);
            preferenceManager = PreferenceManager.getInstance(getActivity());
            button.setOnClickListener(getActivity());
            takepicture.setOnClickListener(getActivity());
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.clickpicture:
                    imgmethod();
                    break;
                case R.id.button3:
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
            }
        }

        private void imgmethod() {
            if ((ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{
                            Manifest.permission.CAMERA,
                    }, 123);
                }
            } else {
                camera = new Intent();
                camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, 118);
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 118 && resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgbtn.setImageBitmap(photo);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] b = baos.toByteArray();
                String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                preferenceManager.setString("image_data", encodedImage);
                Toast.makeText(this, "Image saved in SharedPreferences", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "could not captured", Toast.LENGTH_SHORT).show();
            }
        }


}