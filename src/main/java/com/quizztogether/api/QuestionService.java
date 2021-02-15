package com.quizztogether.api;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class QuestionService {

    public void getQuestions(int id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference docRef = dbFirestore.collection("questions");
        // asynchronously retrieve the document
        ApiFuture<QuerySnapshot> future = docRef.get();
        // ...
        // future.get() blocks on response
        QuerySnapshot document = future.get();
        System.out.println("Document data: " + document.getDocuments());
    }
}
