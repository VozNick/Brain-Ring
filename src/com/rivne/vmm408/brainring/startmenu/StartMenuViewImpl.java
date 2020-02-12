package com.rivne.vmm408.brainring.startmenu;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class StartMenuViewImpl implements StartMenuView {
    private StartMenuPresenter startMenuPresenter;
    private JFrame startMenuFrame;
    private JTextField teamsCountText;
    private JTextField questionsPerTeamText;
    private JTextField duelsCountText;
    private JTextField questionsPerDuelText;
    private JTextField questionsSetText;
    private JButton generateBtn;

//    public static void main(String[] args) {
//        new StartMenuViewImpl();
//    }

    public StartMenuViewImpl() {
        setupFrame();
        startMenuPresenter = new StartMenuPresenterImpl(this, new DataPresenterImpl());
    }

    private void setupFrame() {
//        startMenuFrame = new StartMenuFrame();
        startMenuFrame.getContentPane().add(initComponents());
        startMenuFrame.getContentPane().add(initGenerateBtn());
        startMenuFrame.pack();
    }

    private JPanel initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        panel.add(initTextFieldPanel(new JLabel("Teams:"), teamsCountText = new JTextField()));
        panel.add(initTextFieldPanel(new JLabel("Questions per team:"), questionsPerTeamText = new JTextField()));
        panel.add(initTextFieldPanel(new JLabel("Duels:"), duelsCountText = new JTextField()));
        panel.add(initTextFieldPanel(new JLabel("Questions per duel:"), questionsPerDuelText = new JTextField()));
        panel.add(initTextFieldPanel(new JLabel("Questions count:"), questionsSetText = new JTextField()));


        JCheckBox teamCheckBox = new JCheckBox("Team");
        teamCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                startMenuPresenter.teamCheckBoxIsSelected(true);
            } else {
                startMenuPresenter.teamCheckBoxIsSelected(false);
            }
        });
        JCheckBox duelCheckBox = new JCheckBox("Duel");
        duelCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                startMenuPresenter.duelCheckBoxIsSelected(true);
            } else {
                startMenuPresenter.duelCheckBoxIsSelected(false);
            }
        });

        panel.add(teamCheckBox);
        panel.add(duelCheckBox);
        return panel;
    }

    private JPanel initTextFieldPanel(JLabel jLabel, JTextField jTextField) {
        initListener(jTextField);
        JPanel panel = new JPanel();
        panel.add(jLabel);
        panel.add(jTextField);
        return panel;
    }

    private void initListener(JTextField jTextField) {
        jTextField.setColumns(3);
        jTextField.setEditable(false);
        jTextField.setTransferHandler(null);
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField.getText().length() >= 3) e.consume();
                if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != '\b') e.consume();
            }
        });
    }

    private JButton initGenerateBtn() {
        generateBtn = new JButton("Generate");
        generateBtn.setEnabled(false);
        generateBtn.addActionListener(e -> startMenuPresenter.generateListBtnPressed());
        return generateBtn;
    }

    @Override
    public void teamFieldsAreEditable(boolean isEditable) {
        teamsCountText.setEditable(isEditable);
        questionsPerTeamText.setEditable(isEditable);
    }

    @Override
    public void duelFieldsAreEditable(boolean isEditable) {
        duelsCountText.setEditable(isEditable);
        questionsPerDuelText.setEditable(isEditable);
    }

    @Override
    public void questionNumIsEditable(boolean isEditable) {
        questionsSetText.setEditable(isEditable);
    }

    @Override
    public void generateBtnIsEnabled(boolean isEnabled) {
        generateBtn.setEnabled(isEnabled);
    }

    @Override
    public int getTeamNum() {
        return Integer.parseInt(teamsCountText.getText());
    }

    @Override
    public int getQuestionNumPerTeam() {
        return Integer.parseInt(questionsPerTeamText.getText());
    }

    @Override
    public int getDuelNum() {
        return Integer.parseInt(duelsCountText.getText());
    }

    @Override
    public int getQuestionNumPerDuel() {
        return Integer.parseInt(questionsPerDuelText.getText());
    }

    @Override
    public int getQuestionNum() {
        return Integer.parseInt(questionsSetText.getText());
    }

    @Override
    public void showResults(List<String> stringList) {
        JScrollPane jScrollPane = new JScrollPane(new JList<>(getList(stringList)));
        jScrollPane.createVerticalScrollBar();
        startMenuFrame.getContentPane().add(jScrollPane);
        startMenuFrame.pack();
    }

    private DefaultListModel<String> getList(List<String> stringList) {
        DefaultListModel<String> list = new DefaultListModel<>();
        for (String s : stringList) {
            list.addElement(s);
        }
        return list;
    }
}
