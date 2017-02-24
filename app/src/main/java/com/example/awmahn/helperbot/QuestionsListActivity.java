package com.example.awmahn.helperbot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


//Initial code comes from https://guides.codepath.com/android/using-the-recyclerview and the textbook


public class QuestionsListActivity extends AppCompatActivity{
    dbHandler mdbHandler;
    private List<searchDB> Searches;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);


        RecyclerView rvQuestions = (RecyclerView) findViewById(R.id.rvQuestions);

        mdbHandler = new dbHandler(getApplicationContext(), null);
        Searches = mdbHandler.findAllSearches();
        mdbHandler.close();


        QuestionAdapter mAdapter= new QuestionAdapter(this, Searches);
        rvQuestions.setAdapter(mAdapter);

        rvQuestions.setLayoutManager(new LinearLayoutManager(this));

    }





    private class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
        private List<searchDB> mSearches;
        private Context mContext;

        public QuestionAdapter(Context context, List<searchDB> Searches) {
            mSearches = Searches;
            mContext = context;
        }

        private Context getContext() {
            return mContext;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mNameTextView;
            public Button mSearchButton;

            public ViewHolder(View itemView) {
                super(itemView);

                mNameTextView = (TextView) itemView.findViewById(R.id.search_name);
                mSearchButton = (Button) itemView.findViewById(R.id.load_Question_Search_Button);

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
            final searchDB search = mSearches.get(position);
            TextView textView = holder.mNameTextView;
            textView.setText(search.get_name());

            Button searchButton = holder.mSearchButton;
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(search.get_url());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mSearches.size();
        }
    }

}
