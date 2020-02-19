package com.rivne.vmm408.brainring.startmenu.fxpackage;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;
import com.rivne.vmm408.brainring.startmenu.StartMenuPresenter;
import com.rivne.vmm408.brainring.startmenu.StartMenuPresenterImpl;
import com.rivne.vmm408.brainring.startmenu.StartMenuView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.util.List;

public class StartMenuFXView extends Application implements StartMenuView {
    @FXML
    private CheckBox id_team_cb;
    @FXML
    private CheckBox id_duel_cb;
    @FXML
    private TextField id_team_count_tf;
    @FXML
    private TextField id_question_team_tf;
    @FXML
    private TextField id_duel_count_tf;
    @FXML
    private TextField id_question_duel_tf;
    @FXML
    private TextField id_question_set_tf;
    @FXML
    private Button id_generate_btn;
    @FXML
    private ScrollPane id_result_list;
    private StartMenuPresenter startMenuPresenter =
            new StartMenuPresenterImpl(this, new DataPresenterImpl());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(initParentScene());
//        initComponents();
        primaryStage.show();
    }

    private Scene initParentScene() {
        try {
            return new Scene(FXMLLoader.load(getClass().getResource("StartMenuFXView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    private void initComponents(){
//        initListener(id_team_count_tf);
//        initListener(id_question_team_tf);
//        initListener(id_duel_count_tf);
//        initListener(id_question_duel_tf);
//        initListener(id_question_set_tf);
//    }

//    private void initListener(TextField field) {
//        field.setEditable(false);
//        field.(null);
//        field.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(java.awt.event.KeyEvent e) {
//                if (field.getText().length() >= 3) e.consume();
//                if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != '\b') e.consume();
//            }
//        });
//        field.
//    }

    @Override
    public void teamFieldsAreEditable(boolean isEditable) {
        id_team_count_tf.setDisable(!isEditable);
        id_question_team_tf.setDisable(!isEditable);
    }

    @Override
    public void duelFieldsAreEditable(boolean isEditable) {
        id_duel_count_tf.setDisable(!isEditable);
        id_question_duel_tf.setDisable(!isEditable);
    }

    @Override
    public void questionNumIsEditable(boolean isEditable) {
        id_question_set_tf.setDisable(!isEditable);
    }

    @Override
    public void generateBtnIsEnabled(boolean isEnabled) {
        id_generate_btn.setDisable(!isEnabled);
    }

    @Override
    public int getTeamNum() {
        return Integer.parseInt(id_team_count_tf.getText());
    }

    @Override
    public int getQuestionNumPerTeam() {
        return Integer.parseInt(id_question_team_tf.getText());
    }

    @Override
    public int getDuelNum() {
        return Integer.parseInt(id_duel_count_tf.getText());
    }

    @Override
    public int getQuestionNumPerDuel() {
        return Integer.parseInt(id_question_duel_tf.getText());
    }

    @Override
    public int getQuestionNum() {
        return Integer.parseInt(id_question_set_tf.getText());
    }

    @Override
    public void showResults(List<String> stringList) {
    }

    public void team_cb_on_click(ActionEvent actionEvent) {
        startMenuPresenter.teamCheckBoxIsSelected(id_team_cb.isSelected());
    }

    public void duel_cb_on_click(ActionEvent actionEvent) {
        startMenuPresenter.duelCheckBoxIsSelected(id_duel_cb.isSelected());
    }

    public void generate_btn_on_click() {
        startMenuPresenter.generateListBtnPressed();
    }

    public void id_key_listener_tf(KeyEvent event) {
//        System.out.println("listen");
//        System.out.println(event);
//        if (event.getTarget().toString().length() >= 3) {
//            event.consume();
//            System.out.println("isCon");
        }
//        if ((event.getKeyChar() < '0' || event.getKeyChar() > '9') && event.getKeyChar() != '\b') event.consume();
//    }
}
