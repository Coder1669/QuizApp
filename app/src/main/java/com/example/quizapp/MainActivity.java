package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView NumberQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestions = com.example.quizapp.Quiz.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        NumberQuestionsTextView = findViewById(R.id.number_questions);
        questionTextView = findViewById(R.id.choices_layout);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        NumberQuestionsTextView.setText("Number Of Questions: " + totalQuestions);

        loadNewQuestions();

    }

    @Override
    public void onClick(View view) {

        resetChoicesBackground();

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(com.example.quizapp.Quiz.correctAnswer[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestions();


        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GRAY);
        }

    }

    private void resetChoicesBackground() {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
    }

    void loadNewQuestions() {

        if (currentQuestionIndex == totalQuestions) {
            finishQuiz();
            return;

        }

        questionTextView.setText(com.example.quizapp.Quiz.questions[currentQuestionIndex]);
        ansA.setText(com.example.quizapp.Quiz.choices[currentQuestionIndex][0]);
        ansB.setText(com.example.quizapp.Quiz.choices[currentQuestionIndex][1]);
        ansC.setText(com.example.quizapp.Quiz.choices[currentQuestionIndex][2]);
        ansD.setText(com.example.quizapp.Quiz.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestions * 0.55) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestions)
                .setPositiveButton("Restart", ((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestions();
    }
}