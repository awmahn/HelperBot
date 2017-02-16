package com.example.awmahn.helperbot;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


//Initial code comes from https://guides.codepath.com/android/using-the-recyclerview and the textbook


public class QuestionsListActivity extends AppCompatActivity{
    private questionsListSinglton QuestionsList = questionsListSinglton.get(this);
    private List<questions> Questions = QuestionsList.getmQuestions();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);


        RecyclerView rvQuestions = (RecyclerView) findViewById(R.id.rvQuestions);


        QuestionAdapter mAdapter= new QuestionAdapter(this, Questions);
        rvQuestions.setAdapter(mAdapter);

        rvQuestions.setLayoutManager(new LinearLayoutManager(this));

    }





    private class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
        private List<questions> mQuestions;
        private Context mContext;

        public QuestionAdapter(Context context, List<questions> Questiones) {
            mQuestions = Questiones;
            mContext = context;
        }

        private Context getContext() {
            return mContext;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mNameTextView;

            public ViewHolder(View itemView) {
                super(itemView);

                mNameTextView = (TextView) itemView.findViewById(R.id.search_name);
            }

        }




        @Override
        public QuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View questionView = inflater.inflate(R.layout.load_question, parent, false);

            ViewHolder viewHolder = new ViewHolder(questionView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(QuestionAdapter.ViewHolder holder, int position) {
            questions question = mQuestions.get(position);
            TextView textView = holder.mNameTextView;
            textView.setText(question.getName());
        }

        @Override
        public int getItemCount() {
            return mQuestions.size();
        }
    }

}
