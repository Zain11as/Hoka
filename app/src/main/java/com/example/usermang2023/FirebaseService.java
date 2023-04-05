package com.example.usermang2023;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseService {
    private static FirebaseService instance;
    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;


    public FirebaseService(){

        auth= FirebaseAuth.getInstance();
        fire= FirebaseFirestore.getInstance();
        storage=FirebaseStorage.getInstance();
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseAuth getAuth() {
        return auth;
    }

    public static FirebaseService getInstance(){

        if(instance==null){
            instance= new FirebaseService();
        }
        return instance;
    }


}
