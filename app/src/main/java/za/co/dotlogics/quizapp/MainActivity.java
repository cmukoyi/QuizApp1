package za.co.dotlogics.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int Q2_ANSWER = R.id.yes_radio_button;
    String Q3_ANSWER = "Google";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // check quiz answers and increment score

    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestionOne()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if (checkQuestionTwo()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        if (checkQuestionThree()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if (checkQuestionFour()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if (checkQuestionFive()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }


        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/5 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private boolean checkQuestionOne() {

        CheckBox questionOneCheckBox = (CheckBox) findViewById(R.id.q1_btn);
        CheckBox questionTwoCheckBox = (CheckBox) findViewById(R.id.q2_btn);
        CheckBox questionThreeCheckBox = (CheckBox) findViewById(R.id.q3_btn);

        if (questionOneCheckBox.isChecked() && questionTwoCheckBox.isChecked() && !questionThreeCheckBox.isChecked()) {

            return true;
        }
        return false;

    }

    private boolean checkQuestionTwo() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.q2_radio_group);

        if (rg.getCheckedRadioButtonId() == Q2_ANSWER) {
            return true;
        }

        return false;
    }

    private boolean checkQuestionThree() {
        EditText et = (EditText) findViewById(R.id.name_edit_view);

        return et.getText().toString().equalsIgnoreCase(Q3_ANSWER);
    }

    private boolean checkQuestionFour() {

        CheckBox questionOneCheckBox = (CheckBox) findViewById(R.id.q4_question);
        CheckBox questionTwoCheckBox = (CheckBox) findViewById(R.id.q4_question2);
        CheckBox questionThreeCheckBox = (CheckBox) findViewById(R.id.q4_question3);

        if (questionTwoCheckBox.isChecked() && !questionOneCheckBox.isChecked() && !questionThreeCheckBox.isChecked()) {

            return true;
        }
        return false;

    }

    private boolean checkQuestionFive() {

        CheckBox questionOneCheckBox = (CheckBox) findViewById(R.id.q5_1);
        CheckBox questionTwoCheckBox = (CheckBox) findViewById(R.id.q5_2);
        CheckBox questionThreeCheckBox = (CheckBox) findViewById(R.id.q5_3);

        if (questionThreeCheckBox.isChecked() && !questionTwoCheckBox.isChecked() && !questionOneCheckBox.isChecked()) {

            return true;
        }
        return false;

    }

    //clears selected answers by reset button

    public void ResetAll(View view){

        CheckBox checkBox = (CheckBox) findViewById(R.id.q1_btn);
        checkBox.setChecked(false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q2_btn);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q3_btn);
        checkBox3.setChecked(false);
        RadioButton rg = (RadioButton) findViewById(R.id.yes_radio_button);
        rg.setChecked(false);
        RadioButton rg2 = (RadioButton) findViewById(R.id.no_radio_button);
        rg2.setChecked(false);
        EditText et = (EditText) findViewById(R.id.name_edit_view);
        et.setText("");
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q4_question);
        checkBox4.setChecked(false);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.q4_question2);
        checkBox4.setChecked(false);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.q4_question3);
        checkBox6.setChecked(false);
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.q5_1);
        checkBox7.setChecked(false);
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.q5_2);
        checkBox8.setChecked(false);
        CheckBox checkBox9 = (CheckBox) findViewById(R.id.q5_3);
        checkBox9.setChecked(false);

    }

}
