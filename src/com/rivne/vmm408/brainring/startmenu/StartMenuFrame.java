package com.rivne.vmm408.brainring.startmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartMenuFrame extends JFrame {
    public StartMenuFrame() throws HeadlessException {
        initFrame();
        initFrameExitConfirmDialog();
        setVisible(true);
    }

    private void initFrame() {
        setTitle("Menu Brain Rank");
        setLocation(300, 300);
        getContentPane().setLayout(new FlowLayout());
    }

    private void initFrameExitConfirmDialog() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the program?", "Exit Program",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}
