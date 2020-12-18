package logic;

import data.VolleyballPlayer;

import java.util.List;

public class PlayerMatch extends Match {
        @Override
     public boolean getResult(Team team) {
            List<VolleyballPlayer> temp = team.getCurrentCast();
            int sum=0;
            Player p = team.getAveragePlayer();
                sum = (p.getPointsOfPower() + p.getPointsOfProtection())*temp.size();
            return sum > Math.random() * 4500;
     }
}
