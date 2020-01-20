package com.rivne.vmm408.brainring.startmenu;

public interface StartMenuView {
    public int getTeamNum();

    public int getQuestionNumPerTeam();

    public int getDuelNum();

    public int getQuestionNumPerDuel();

    public int getQuestionNum();

    public void showResults();
}
