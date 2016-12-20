package com.zhafa467.boosterdemo.common;

import com.zhafa467.boosterdemo.R;

import java.util.ArrayList;

/**
 * Created by zhangho on 16/12/21.
 */

public class Questions {

    public ArrayList<Question> getQuestions() {
        return new ArrayList<Question>() {{
            add(new Question(R.string.question1, R.string.question1_option1, R.string.question1_option2, R.string.question1_option3, R.string.question1_option4, R.string.question1_option5));
            add(new Question(R.string.question2, R.string.question2_option1, R.string.question2_option2, R.string.question2_option3, R.string.question2_option4, R.string.question2_option5));
            add(new Question(R.string.question3, R.string.question3_option1, R.string.question3_option2, R.string.question3_option3, R.string.question3_option4, R.string.question3_option5));
            add(new Question(R.string.question4, R.string.question4_option1, R.string.question4_option2, R.string.question4_option3, R.string.question4_option4, R.string.question4_option5));
            add(new Question(R.string.question5, R.string.question5_option1, R.string.question5_option2, R.string.question5_option3, R.string.question5_option4, R.string.question5_option5));
        }};
    }

    public class Question {
        private int questionId;
        private int optionId1;
        private int optionId2;
        private int optionId3;
        private int optionId4;
        private int optionId5;

        public Question(int questionId, int optionId1, int optionId2, int optionId3, int optionId4, int optionId5) {
            this.questionId = questionId;
            this.optionId1 = optionId1;
            this.optionId2 = optionId2;
            this.optionId3 = optionId3;
            this.optionId4 = optionId4;
            this.optionId5 = optionId5;
        }

        public int getQuestionId() {
            return questionId;
        }

        public int getOptionId1() {
            return optionId1;
        }

        public int getOptionId2() {
            return optionId2;
        }

        public int getOptionId3() {
            return optionId3;
        }

        public int getOptionId4() {
            return optionId4;
        }

        public int getOptionId5() {
            return optionId5;
        }
    }
}
