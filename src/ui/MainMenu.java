package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainMenu {

    private List<Widget> widgetList;

    public void start(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым

        widgetList = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(6,1));

        JLabel topLabel = new JLabel("Главное окно");
        topLabel.setVerticalAlignment(JLabel.TOP);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(topLabel);


        JButton manager = new JButton("Менеджер");
        JButton player = new JButton("Игрок");
        JButton exit = new JButton("Выход");

        manager.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseManager();}
            });

        player.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePlayer();}
        });

        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               exit();}
        });

        panel.add(manager);
        panel.add(player);
        panel.add(exit);


        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    public void chooseManager(){
        ManagerWidget managerWidget = new ManagerWidget();
        managerWidget.mainMenu();
    }

    public void choosePlayer(){
        PlayerWidget playerWidget = new PlayerWidget();
        playerWidget.distributePoints();
    }

    public void exit(){System.exit(1);}
}
