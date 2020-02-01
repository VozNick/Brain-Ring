package com.rivne.vmm408.brainring.startmenu;

import java.util.List;

public interface StartMenuView {
    void teamFieldsAreEditable(boolean isEditable);

    void duelFieldsAreEditable(boolean isEditable);

    void questionNumIsEditable(boolean isEditable);

    void generateBtnIsEnabled(boolean isEnabled);

    int getTeamNum();

    int getQuestionNumPerTeam();

    int getDuelNum();

    int getQuestionNumPerDuel();

    int getQuestionNum();

    void showResults(List<String> stringList);
}
