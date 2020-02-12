package com.rivne.vmm408.brainring.data;

import com.rivne.vmm408.brainring.pojo.DuelModel;
import com.rivne.vmm408.brainring.pojo.TeamModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataPresenterImpl {
    private List<Integer> integerList = new LinkedList<>();
    private List<TeamModel> teamModelList = new ArrayList<>();
    private List<DuelModel> duelModelList = new ArrayList<>();
    private int duelNum;
    private int teamNum;
    private int questionNumPerTDuel;
    private int questionNumPerTeam;
    private int questionNum;

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public List<TeamModel> getTeamModelList() {
        return teamModelList;
    }

    public List<DuelModel> getDuelModelList() {
        return duelModelList;
    }


    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public void setQuestionNumPerTeam(int questionNumPerTeam) {
        this.questionNumPerTeam = questionNumPerTeam;
    }

    public void setDuelNum(int duelNum) {
        this.duelNum = duelNum;
    }

    public void setQuestionNumPerTDuel(int questionNumPerTDuel) {
        this.questionNumPerTDuel = questionNumPerTDuel;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public void removeAllData() {
        integerList.clear();
        teamModelList.clear();
        duelModelList.clear();
        duelNum = 0;
        teamNum = 0;
        questionNumPerTDuel = 0;
        questionNumPerTeam = 0;
        questionNum = 0;
    }

    public void generateOriginalListOfQuestions() {
        for (int i = 0; i < questionNum; i++) {
            integerList.add(i + 1);
        }
    }

    public void setRandomQuestionsForTeams() {
        for (int i = 0; i < teamNum; i++) {
            TeamModel teamModel = new TeamModel();
            teamModel.setId(i + 1);
            teamModel.setIntegerList(returnIntegerList(questionNumPerTeam));
            teamModelList.add(teamModel);
        }
    }

    public void setRandomQuestionsForDuels() {
        for (int i = 0; i < duelNum; i++) {
            DuelModel duelModel = new DuelModel();
            duelModel.setId(i + 1);
            duelModel.setIntegerList(returnIntegerList(questionNumPerTDuel));
            duelModelList.add(duelModel);
        }
    }

    private List<Integer> returnIntegerList(int count) {
        List<Integer> integers = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            int random = getRandomNum();
            integers.add(integerList.get(random));
            integerList.remove(random);
        }
        return integers;
    }

    private int getRandomNum() {
        return new Random().nextInt(integerList.size());
    }
}
