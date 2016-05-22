package edu.macalester.macathon.sixpack.data;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zoray on 2/20/16.
 */
public class Challenge extends SugarRecord<Challenge> implements Serializable {
    private String challengeeName;
    private double reward;
    private String description;
    private boolean completed;

    public Challenge(String challengeeName, double reward, String description, boolean completed) {
        this.challengeeName = challengeeName;
        this.reward = reward;
        this.description = description;
        this.completed = completed;
    }

    public Challenge(){};

    public String getChallengeeName() {
        return challengeeName;
    }

    public void setChallengeeName(String challengeeName) {
        this.challengeeName = challengeeName;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
