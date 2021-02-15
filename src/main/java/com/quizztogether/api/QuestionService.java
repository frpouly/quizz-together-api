package com.quizztogether.api;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

@Service
public class QuestionService {

    public List<Question> getQuestions(int id) throws ExecutionException, InterruptedException {
        List<Question> ret = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference colRef = dbFirestore.collection("questions");
        ApiFuture<QuerySnapshot> future = colRef.get();
        QuerySnapshot col = future.get();
        for(QueryDocumentSnapshot doc : col.getDocuments())
        {
            ret.add(new Question(doc.get("statement", String.class), (List<String>) doc.get("answers")));
        }
        return ret;
    }
}