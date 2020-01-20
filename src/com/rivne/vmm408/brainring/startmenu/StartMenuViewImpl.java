package com.rivne.vmm408.brainring.startmenu;

import com.rivne.vmm408.brainring.data.DataPresenterImpl;
import com.rivne.vmm408.brainring.models.DuelModel;
import com.rivne.vmm408.brainring.models.TeamModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class StartMenuViewImpl implements StartMenuView {
    private StartMenuPresenter startMenuPresenter;
    private JFrame frame;
    private JTextField teamsCountText;
    private JTextField questionsPerTeamText;
    private JTextField duelsCountText;
    private JTextField questionsPerDuelText;
    private JTextField questionsSetText;

    public static void main(String[] args) {
        new StartMenuViewImpl();
    }

    public StartMenuViewImpl() {
        startMenuPresenter = new StartMenuPresenterImpl(this);
        initFrame();
        initComponents();
        frame.pack();
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setTitle("Menu Brain Rank");
        frame.setLocation(300, 300);
        frame.getContentPane().setLayout(new FlowLayout());
        initFrameExitConfirmDialog();
        frame.setVisible(true);
    }

    private void initFrameExitConfirmDialog() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the program?", "Exit Program",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    private void initComponents() {
        frame.getContentPane().add(new JLabel("   Teams:"));
        frame.getContentPane().add(teamsCountText = new JTextField(3));
        frame.getContentPane().add(new JLabel("   Questions per team:"));
        frame.getContentPane().add(questionsPerTeamText = new JTextField(3));
        frame.getContentPane().add(new JLabel("   Duels:"));
        frame.getContentPane().add(duelsCountText = new JTextField(3));
        frame.getContentPane().add(new JLabel("   Questions per duel:"));
        frame.getContentPane().add(questionsPerDuelText = new JTextField(3));
        frame.getContentPane().add(new JLabel("   Questions count:"));
        frame.getContentPane().add(questionsSetText = new JTextField(3));
        JButton generateBtn;
        frame.getContentPane().add(generateBtn = new JButton("Generate"));
        generateBtn.addActionListener(e -> startMenuPresenter.generateListBtnPressed());
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
    public void showResults() {
        java.util.List<Integer> integerList = DataPresenterImpl.getIntegerList();
        java.util.List<TeamModel> teamModelList = DataPresenterImpl.getTeamModelList();
        java.util.List<DuelModel> duelModelList = DataPresenterImpl.getDuelModelList();

        DefaultListModel<String> list = new DefaultListModel<>();

        for (TeamModel teamModel : teamModelList) {
            StringBuilder text = new StringBuilder("TEAM_" + teamModel.getId() + ":     ");
            java.util.List<Integer> integers = teamModel.getIntegerList();
            for (Integer integer : integers) {
                text.append(integer).append("   ");
            }
            list.addElement(text.toString());
        }

        for (DuelModel duelModel : duelModelList) {
            StringBuilder text = new StringBuilder("DUEl_" + duelModel.getId() + ":     ");
            List<Integer> integers = duelModel.getIntegerList();
            for (Integer integer : integers) {
                text.append(integer).append("   ");
            }
            list.addElement(text.toString());
        }

        StringBuilder text = new StringBuilder("Extra Questions:     ");
        for (Integer integer : integerList) {
            text.append(integer).append("   ");
        }
        list.addElement(text.toString());


        frame.getContentPane().add(new JList<>(list));
        frame.pack();
    }
}
