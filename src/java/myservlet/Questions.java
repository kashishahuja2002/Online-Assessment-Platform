/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.util.Objects;

/**
 *
 * @author m.boopathi
 */
public class Questions {

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.question);
        hash = 29 * hash + Objects.hashCode(this.option1);
        hash = 29 * hash + Objects.hashCode(this.option2);
        hash = 29 * hash + Objects.hashCode(this.option3);
        hash = 29 * hash + Objects.hashCode(this.option4);
        hash = 29 * hash + Objects.hashCode(this.correct);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questions other = (Questions) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.option1, other.option1)) {
            return false;
        }
        if (!Objects.equals(this.option2, other.option2)) {
            return false;
        }
        if (!Objects.equals(this.option3, other.option3)) {
            return false;
        }
        if (!Objects.equals(this.option4, other.option4)) {
            return false;
        }
        if (!Objects.equals(this.correct, other.correct)) {
            return false;
        }
        return true;
    }

    public Questions(String question, String option1, String option2, String option3, String option4, String correct) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct = correct;
    }

    public Questions() {
    }

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct;
    
}
