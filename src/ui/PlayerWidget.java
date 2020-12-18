package ui;

import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PlayerWidget extends Widget{

    private Player currPlayer;

    private List<Widget> widgetList;
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

        widgetList = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(6,1));

        JLabel topLabel = new JLabel("Режим игрока");
        topLabel.setVerticalAlignment(JLabel.TOP);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(topLabel);


        JButton play = new JButton("Сыграть матч");
        JButton transfer = new JButton("Запросить трансфер");
        JButton train = new JButton("Тренировка");
        JButton rest = new JButton("Отдых");
        JButton changeNT = new JButton("Сменить сборную");
        JButton finish = new JButton("Завершить карьеру");
        JButton menu = new JButton("Главное меню");

        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playMatch();}
        });

        transfer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTeam();}
        });

        train.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                train();}
        });
        rest.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rest();}
        });

        changeNT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeNationalTeam();}
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
        panel.add(transfer);
        panel.add(train);
        panel.add(rest);
        panel.add(changeNT);
        panel.add(finish);
        panel.add(menu);


        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void changeTeam(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currPlayer.askForTransfer();
        JOptionPane.showMessageDialog(frame,"You've joined new team "+ currPlayer.getTeam());
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void train(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currPlayer.train();
        JOptionPane.showMessageDialog(frame,"You've trained");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void rest(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currPlayer.rest();
        JOptionPane.showMessageDialog(frame,"You've rested");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  }

    public void changeNationalTeam(){
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым
        currPlayer.changeNationalTeam();
        JOptionPane.showMessageDialog(frame,"You've changed NT");
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
        if(currPlayer.playMatch())
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
        currPlayer.finishCareer();
        JOptionPane.showMessageDialog(frame,"You've played"+ currPlayer.getNumOfGames()+"/n You've won "+ currPlayer.getNumOfWins() + "/n Your budget is "+ currPlayer.getMoney());
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void distributePoints(){
        //Player player = new Player();
        final int pl1, p2;
        JFrame frame;
        frame = new JFrame("Volleyball");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
        frame.setSize(500, 300); // размеры окна
        frame.setLocationRelativeTo(null); // позиция на экране
        frame.setVisible(true); // сделать видимым

        widgetList = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(6,1));

        JLabel topLabel = new JLabel("Создание игрока");
        topLabel.setVerticalAlignment(JLabel.TOP);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(topLabel);

        JTextField nameField = new JTextField("DefoltPlayer");
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPlayer.setName(nameField.getText());
            }
        });

        JTextField point1Field = new JTextField("23");
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              currPlayer.distributePoints(Integer.parseInt(point1Field.getText()), 0);
            }
        });

        JTextField point2Field = new JTextField("23");
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPlayer.distributePoints(0, Integer.parseInt(point2Field.getText()));
            }
        });

        JButton menu = new JButton("Создать");

        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu();}
        });

        panel.add(nameField);
        panel.add(point1Field);
        panel.add(point2Field);

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }
}
