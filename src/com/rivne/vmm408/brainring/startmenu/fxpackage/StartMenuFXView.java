package com.rivne.vmm408.brainring.startmenu.fxpackage;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;
import com.rivne.vmm408.brainring.startmenu.StartMenuPresenter;
import com.rivne.vmm408.brainring.startmenu.StartMenuPresenterImpl;
import com.rivne.vmm408.brainring.startmenu.StartMenuView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class StartMenuFXView extends Application implements StartMenuView {
    private StartMenuPresenter startMenuPresenter;
    @FXML
    private CheckBox checkBox;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        startMenuPresenter = new StartMenuPresenterImpl(this, new DataPresenterImpl());
    }

    @Override
    public void teamFieldsAreEditable(boolean isEditable) {

    }

    @Override
    public void duelFieldsAreEditable(boolean isEditable) {

    }

    @Override
    public void questionNumIsEditable(boolean isEditable) {

    }

    @Override
    public void generateBtnIsEnabled(boolean isEnabled) {

    }

    @Override
    public int getTeamNum() {
        return 0;
    }

    @Override
    public int getQuestionNumPerTeam() {
        return 0;
    }

    @Override
    public int getDuelNum() {
        return 0;
    }

    @Override
    public int getQuestionNumPerDuel() {
        return 0;
    }

    @Override
    public int getQuestionNum() {
        return 0;
    }

    @Override
    public void showResults(List<String> stringList) {

    }
}
