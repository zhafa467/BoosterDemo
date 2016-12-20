package com.zhafa467.boosterdemo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhafa467.boosterdemo.R;
import com.zhafa467.boosterdemo.common.BusProvider;
import com.zhafa467.boosterdemo.common.InvestorTypeScheme;
import com.zhafa467.boosterdemo.common.Questions;
import com.zhafa467.boosterdemo.common.UpdateUIEvent;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fan zhang on 16/12/21.
 */

public class QuestionnaireFragment extends Fragment {
    public static final int LAST_ONE = 3;
    private int currentQuestion = 0;
    private int score = 0;
    private int[] investorTypeScheme = new int[]{};
    private ArrayList<Questions.Question> questions;
    @BindView(R.id.rbOption1)
    RadioButton option1;
    @BindView(R.id.rbOption2)
    RadioButton option2;
    @BindView(R.id.rbOption3)
    RadioButton option3;
    @BindView(R.id.rbOption4)
    RadioButton option4;
    @BindView(R.id.rbOption5)
    RadioButton option5;
    @BindView(R.id.rgOptions)
    RadioGroup options;
    @BindView(R.id.tvQuestion)
    TextView questionView;
    @BindView(R.id.btnNext)
    Button btnNext;
    @BindView(R.id.btnDone)
    Button btnDone;
    @BindView(R.id.selectionView)
    LinearLayout selectionView;
    @BindView(R.id.resultView)
    LinearLayout resultView;
    @BindView(R.id.tvResultInvestorType)
    TextView tvResultInvestorType;
    @BindView(R.id.tvResultScore)
    TextView tvResultScore;

    @OnClick(R.id.btnNext)
    public void onNextButtonClick() {
        Questions.Question question;
        if (currentQuestion == LAST_ONE) {
            btnDone.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.GONE);
        }
        currentQuestion++;
        question = questions.get(currentQuestion);
        questionView.setText(question.getQuestionId());
        option1.setText(question.getOptionId1());
        option2.setText(question.getOptionId2());
        option3.setText(question.getOptionId3());
        option4.setText(question.getOptionId4());
        option5.setText(question.getOptionId5());
        increaseScore();
    }

    @OnClick(R.id.btnDone)
    public void onDoneButtonClick() {
        int investorType = 0;
        if (score >= 5 && score <= 12) {
            investorType = R.string.defensive;
            investorTypeScheme = InvestorTypeScheme.DEFENSIVE;
        } else if (score >= 13 && score <= 20) {
            investorType = R.string.conservative;
            investorTypeScheme = InvestorTypeScheme.CONSERVATIVE;
        } else if (score >= 21 && score <= 29) {
            investorType = R.string.balanced;
            investorTypeScheme = InvestorTypeScheme.BALANCED;
        } else if (score >= 30 && score <= 37) {
            investorType = R.string.balanced_growth;
            investorTypeScheme = InvestorTypeScheme.BALANCED_GROWTH;
        } else if (score >= 38 && score <= 44) {
            investorType = R.string.growth;
            investorTypeScheme = InvestorTypeScheme.GROWTH;
        } else if (score >= 45 && score <= 50) {
            investorType = R.string.aggressive_growth;
            investorTypeScheme = InvestorTypeScheme.AGGRESSIVE_GROWTH;
        }
        selectionView.setVisibility(View.GONE);
        resultView.setVisibility(View.VISIBLE);
        tvResultScore.setText(String.format(Locale.ENGLISH, "%d", score));
        tvResultInvestorType.setText(String.format(Locale.ENGLISH, getString(R.string.result_investor_type), getResources().getString(investorType)));

    }

    @OnClick(R.id.btnShow)
    public void onShowButtonClick() {
        UpdateUIEvent event = new UpdateUIEvent(investorTypeScheme, score);
        BusProvider.getBus().post(event);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire, container, false);
        ButterKnife.bind(this, view);
        questions = new Questions().getQuestions();
        initSelection();
        return view;
    }

    private void initSelection() {
        option1.setChecked(true);
        score++;
    }

    private void increaseScore() {
        int selectedScore = 0;
        switch (getSelectedIndex()) {
            case 0:
                selectedScore = 1;
                break;
            case 1:
                selectedScore = 3;
                break;
            case 2:
                selectedScore = 5;
                break;
            case 3:
                selectedScore = 7;
                break;
            case 4:
                selectedScore = 10;
                break;
        }
        score += selectedScore;
    }

    private int getSelectedIndex() {
        int radioButtonID = options.getCheckedRadioButtonId();
        View radioButton = options.findViewById(radioButtonID);
        return options.indexOfChild(radioButton);
    }
}
