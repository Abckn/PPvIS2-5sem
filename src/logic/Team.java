package logic;

import data.VolleyballPlayer;

import java.util.Collections;
import java.util.List;

public class Team {

    private List<VolleyballPlayer> players;
    private List<VolleyballPlayer> currentCast;
    private Player averagePlayer;


    public void addAveragePlayer(Player averagePlayer){
        //чтобы оставить переопределение в матчах
        averagePlayer.setTeam(this);
    }

    public void changeCurrentCast(VolleyballPlayer player1, VolleyballPlayer player2)
   {
   Collections.swap(players, players.indexOf(player1), players.indexOf(player2));
   }

    public void addPlayer(VolleyballPlayer player) {
      players.add(player);
    }

    public void delete(VolleyballPlayer player) {
       players.remove(player);
    }


    public void setPlayers(List<VolleyballPlayer> players) {
        this.players = players;
    }
    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setCurrentCast(List<VolleyballPlayer> currentCast) {
        this.currentCast = currentCast;
    }

    public List<VolleyballPlayer> getCurrentCast() {
        return currentCast;
    }

    public void setAveragePlayer(Player averagePlayer) {
        this.averagePlayer = averagePlayer;
    }

    public Player getAveragePlayer() {
        return averagePlayer;
    }
}

