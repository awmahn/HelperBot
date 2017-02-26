package com.example.awmahn.helperbot;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class questionsListSinglton {
    private static questionsListSinglton sQuestionsListSinglton;

    dbHandler mdbHandler;

    private List<questions> mQuestions;

    // If null then create a new questionsListSinglton
    public static questionsListSinglton get(Context context) {
        if (sQuestionsListSinglton == null) {
            sQuestionsListSinglton = new questionsListSinglton(context);
        }
        return sQuestionsListSinglton;
    }

    private questionsListSinglton(Context context) {
        mdbHandler = new dbHandler(context, null);

        mQuestions = new ArrayList<>();

    }

    public List<questions> getmQuestions() {
        return mQuestions;
    }

    public questions getQuestion(UUID id) {
        for(questions question : mQuestions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }
}
