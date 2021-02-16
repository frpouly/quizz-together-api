package com.quizztogether.api;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

@Service
public class QuestionService {

    public List<Question> getQuestions() throws ExecutionException, InterruptedException {
        List<Question> ret = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference colRef = dbFirestore.collection("questions");
        ApiFuture<QuerySnapshot> future = colRef.get();
        QuerySnapshot col = future.get();
        for(QueryDocumentSnapshot doc : col.getDocuments())
        {
            ret.add(new Question(doc.getId(), doc.get("statement", String.class), (List<String>) doc.get("answers")));
        }
        return ret;
    }

    public Question getRandomQuestion() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference colRef = dbFirestore.collection("questions");
        ApiFuture<QuerySnapshot> future = colRef.whereGreaterThanOrEqualTo("id", (int)(Math.random()*(1 + 1)))
                .orderBy("id", Query.Direction.DESCENDING)
                .limitToLast(1)
                .get();
        QuerySnapshot questionRandom = future.get();
        QueryDocumentSnapshot doc = questionRandom.getDocuments().get(0);
        return new Question(doc.getId(), doc.get("statement", String.class), (List<String>) doc.get("answers"));
    }
}