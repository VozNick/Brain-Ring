package com.rivne.vmm408.brainring.data;

import com.rivne.vmm408.brainring.models.DuelModel;
import com.rivne.vmm408.brainring.models.TeamModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataPresenterImpl {
    private static List<Integer> integerList = new LinkedList<>();
    private static List<TeamModel> teamModelList = new ArrayList<>();
    private static List<DuelModel> duelModelList = new ArrayList<>();

    public static int duelNum;
    public static int teamNum;
    public static int questionNumPerTDuel;
    public static int questionNumPerTeam;
    public static int questionNum;

    public static List<Integer> getIntegerList() {
        return integerList;
    }

    public static List<TeamModel> getTeamModelList() {
        return teamModelList;
    }

    public static List<DuelModel> getDuelModelList() {
        return duelModelList;
    }

    public static void removeAllData() {
        integerList.clear();
        teamModelList.clear();
        duelModelList.clear();
        duelNum = 0;
        teamNum = 0;
        questionNumPerTDuel = 0;
        questionNumPerTeam = 0;
        questionNum = 0;
    }

    public static void generateOriginalListOfQuestions() {
        for (int i = 0; i < questionNum; i++) {
            integerList.add(i + 1);
        }
    }

    public static void setRandomQuestionsForTeams() {
        for (int i = 0; i < teamNum; i++) {
            TeamModel teamModel = new TeamModel();
            teamModel.setId(i + 1);
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j < questionNumPerTeam; j++) {
                int random = getRandomNum();
                integers.add(integerList.get(random));
                integerList.remove(random);
            }
            teamModel.setIntegerList(integers);
            teamModelList.add(teamModel);
        }
    }

    public static void setRandomQuestionsForDuels() {
        for (int i = 0; i < duelNum; i++) {
            DuelModel duelModel = new DuelModel();
            duelModel.setId(i + 1);
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j < questionNumPerTDuel; j++) {
                int random = getRandomNum();
                integers.add(integerList.get(random));
                integerList.remove(random);
            }
            duelModel.setIntegerList(integers);
            duelModelList.add(duelModel);
        }
    }

    private static int getRandomNum() {
        return new Random().nextInt(integerList.size());
    }
}
