package ui;

import data.VolleyballPlayer;
import logic.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ManagerWidget extends Widget{
     private Manager currManager;

    @Override
    public void Reload(){}
    @Override
    public void mainMenu(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым

        JPanel panel = new JPanel(new GridLayout(6,1));

        JLabel topLabel = new JLabel("Режим менеджера");
        topLabel.setVerticalAlignment(JLabel.TOP);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(topLabel);


        JButton play = new JButton("Сыграть матч");
        JButton buy = new JButton("Купить игрока");
        JButton sell = new JButton("Продать игрока");
        JButton change = new JButton("Изменить состав");
        JButton view = new JButton("Моя команда");
        JButton finish = new JButton("Завершить карьеру");
        JButton menu = new JButton("Главное меню");

        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playMatch();}
        });

        buy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                buyPlayer();}
        });

        sell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               sellPlayer();}
        });
        change.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changePlayers();}
        });

        view.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               viewTeam();}
        });

        finish.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                finishCareer();}
        });
        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              MainMenu mm = new MainMenu();
                mm.start();}
        });

        panel.add(play);
        panel.add(buy);
        panel.add(sell);
        panel.add(change);
        panel.add(view);
        panel.add(finish);
        panel.add(menu);


        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void changePlayers(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currManager.changePlayers(currManager.viewTeam().get((int) (Math.random() * currManager.viewTeam().size())), currManager.viewTeam().get((int) (Math.random() * currManager.viewTeam().size())));
        JOptionPane.showMessageDialog(frame,"You've bought a new volleyball player" );
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void buyPlayer(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currManager.buyPlayer(new VolleyballPlayer());
        JOptionPane.showMessageDialog(frame,"You've bought a new volleyball player" );
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void sellPlayer(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        String[] items = new String[20]; int i = 0;
        for (i=0; i < currManager.viewTeam().size(); i++) items[i] = currManager.viewTeam().get(i).name;
        JComboBox comboBox = new JComboBox(items);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currManager.sellPlayer((String) comboBox.getSelectedItem());
            }
        };

        JOptionPane.showMessageDialog(frame,"You've sold volleyball player" );
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void viewTeam(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
          JList list = new JList((ListModel) currManager.viewTeam());
        list.setLayoutOrientation(JList.VERTICAL);

        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void playMatch(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        if(currManager.playMatch())
            JOptionPane.showMessageDialog(frame,"You've win");
        else JOptionPane.showMessageDialog(frame,"You've lost");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void finishCareer(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currManager.finishCareer();
        JOptionPane.showMessageDialog(frame,"You've played"+ currManager.getNumOfGames()+"/n You've won "+ currManager.getNumOfWins() + "/n Your budget is "+ currManager.getBudget());
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setCurrManager(Manager currManager) {
        this.currManager = currManager;
    }
}
