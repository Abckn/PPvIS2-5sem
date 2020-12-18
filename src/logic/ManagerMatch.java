package logic;

import data.VolleyballPlayer;

import java.util.List;

public class ManagerMatch extends Match {
        @Override
     public boolean getResult(Team team) {
            List<VolleyballPlayer> temp = team.getCurrentCast();
            int sum=0;
            for (VolleyballPlayer volleyballPlayer : temp) {
                sum += volleyballPlayer.skill;
            }
            return sum > Math.random() * 4500;
     }
}
