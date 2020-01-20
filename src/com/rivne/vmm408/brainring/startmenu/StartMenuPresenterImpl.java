package com.rivne.vmm408.brainring.startmenu;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;

public class StartMenuPresenterImpl implements StartMenuPresenter {
    private StartMenuView startMenuView;

    public StartMenuPresenterImpl(StartMenuView startMenuView) {
        this.startMenuView = startMenuView;
    }

    @Override
    public void generateListBtnPressed() {
        DataPresenterImpl.removeAllData();
        getDataFromView();
        generateLists();
        startMenuView.showResults();
    }

    private void getDataFromView() {
        DataPresenterImpl.duelNum = startMenuView.getDuelNum();
        DataPresenterImpl.teamNum = startMenuView.getTeamNum();
        DataPresenterImpl.questionNumPerTDuel = startMenuView.getQuestionNumPerDuel();
        DataPresenterImpl.questionNumPerTeam = startMenuView.getQuestionNumPerTeam();
        DataPresenterImpl.questionNum = startMenuView.getQuestionNum();
    }

    private void generateLists() {
        DataPresenterImpl.generateOriginalListOfQuestions();
        DataPresenterImpl.setRandomQuestionsForTeams();
        DataPresenterImpl.setRandomQuestionsForDuels();
    }
}
