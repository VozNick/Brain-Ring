package com.rivne.vmm408.brainring.startmenu;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;
import com.rivne.vmm408.brainring.pojo.DuelModel;
import com.rivne.vmm408.brainring.pojo.TeamModel;

import java.util.ArrayList;
import java.util.List;

public class StartMenuPresenterImpl implements StartMenuPresenter {
    private StartMenuView startMenuView;
    private DataPresenterImpl dataPresenterImpl;
    private boolean teamIsSelected;
    private boolean duelIsSelected;

    public StartMenuPresenterImpl(StartMenuView startMenuView, DataPresenterImpl dataPresenterImpl) {
        this.startMenuView = startMenuView;
        this.dataPresenterImpl = dataPresenterImpl;
    }

    @Override
    public void teamCheckBoxIsSelected(boolean isSelected) {
        teamIsSelected = isSelected;
        startMenuView.teamFieldsAreEditable(isSelected);
        checkIfSelected();
    }

    @Override
    public void duelCheckBoxIsSelected(boolean isSelected) {
        duelIsSelected = isSelected;
        startMenuView.duelFieldsAreEditable(isSelected);
        checkIfSelected();
    }

    private void checkIfSelected() {
        startMenuView.questionNumIsEditable(isEditable());
        startMenuView.generateBtnIsEnabled(isEditable());
    }

    private boolean isEditable() {
        return teamIsSelected || duelIsSelected;
    }

    @Override
    public void generateListBtnPressed() {
        dataPresenterImpl.removeAllData();
        getDataFromView();
        generateLists();
        startMenuView.showResults(returnResult());
    }

    private void getDataFromView() {
        if (teamIsSelected) {
            dataPresenterImpl.setTeamNum(startMenuView.getTeamNum());
            dataPresenterImpl.setQuestionNumPerTeam(startMenuView.getQuestionNumPerTeam());
        }
        if (duelIsSelected) {
            dataPresenterImpl.setDuelNum(startMenuView.getDuelNum());
            dataPresenterImpl.setQuestionNumPerTDuel(startMenuView.getQuestionNumPerDuel());
        }
        dataPresenterImpl.setQuestionNum(startMenuView.getQuestionNum());
    }

    private void generateLists() {
        dataPresenterImpl.generateOriginalListOfQuestions();
        if (teamIsSelected) {
            dataPresenterImpl.setRandomQuestionsForTeams();
        }
        if (duelIsSelected) {
            dataPresenterImpl.setRandomQuestionsForDuels();
        }
    }

    private List<String> returnResult() {
        List<String> stringList = new ArrayList<>();
        for (TeamModel teamModel : dataPresenterImpl.getTeamModelList()) {
            stringList.add(returnText("TEAM_" + teamModel.getId() + ":     ", teamModel.getIntegerList()));
        }
        for (DuelModel duelModel : dataPresenterImpl.getDuelModelList()) {
            stringList.add(returnText("DUEl_" + duelModel.getId() + ":     ", duelModel.getIntegerList()));
        }
        if (dataPresenterImpl.getIntegerList().size() != 0) {
            stringList.add(returnText("Extra Questions:     ", dataPresenterImpl.getIntegerList()));
        }
        return stringList;
    }

    private String returnText(String label, List<Integer> list) {
        StringBuilder text = new StringBuilder(label);
        for (Integer integer : list) {
            text.append(integer).append("   ");
        }
        return text.toString();
    }
}

