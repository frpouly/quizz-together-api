package com.quizztogether.api;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            FileInputStream serviceAccount =
                    new FileInputStream(classLoader.getResource("serviceAccountKey.json").getFile());

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://quizz-together-default-rtdb.europe-west1.firebasedatabase.app/")
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
