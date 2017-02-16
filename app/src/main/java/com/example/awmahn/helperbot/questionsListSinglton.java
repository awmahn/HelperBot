package com.example.awmahn.helperbot;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Robert on 2/14/2017.
 */

public class questionsListSinglton {
    private static questionsListSinglton sQuestionsListSinglton;

    private List<questions> mQuestions;

    public static questionsListSinglton get(Context context) {
        if (sQuestionsListSinglton == null) {
            sQuestionsListSinglton = new questionsListSinglton(context);
        }
        return sQuestionsListSinglton;
    }

    private questionsListSinglton(Context context) {
        mQuestions = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            questions question = new questions();
            question.setName("Search #" + i);
            mQuestions.add(question);
        }
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
