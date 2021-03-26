package com.quizztogether.api.Models;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.Random;
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
        for(QueryDocumentSnapshot doc : col.getDocuments()) {
            QuestionDocument questionDocument = doc.toObject(QuestionDocument.class);
            ret.add(new Question(questionDocument.id, questionDocument.statement, questionDocument.answers));
        }
        return ret;
    }

    public Question getRandomQuestion() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference colRef = dbFirestore.collection("questions");
        ApiFuture<QuerySnapshot> future = colRef.whereEqualTo("id", (int) (new Random().nextFloat() * 15))
                .get();
        QuerySnapshot questionRandom = future.get();
        QueryDocumentSnapshot doc = questionRandom.getDocuments().get(0);
        QuestionDocument questionDocument = doc.toObject(QuestionDocument.class);
        return new Question(questionDocument.id, questionDocument.statement, questionDocument.answers);
    }
}