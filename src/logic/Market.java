package logic;

import data.VolleyballPlayer;

import java.util.List;

public class Market {

    private List<VolleyballPlayer> players;

    public int buyPlayer(VolleyballPlayer player) {
       //возвращает цену игрока
        return player.price;
    }


    public int sellPlayer(VolleyballPlayer player) {
       //возвращает цену игрока/2
        return player.price/2;
    }

    public void setPlayers(List <VolleyballPlayer> players) {
        this.players = players;
    }

    public List<VolleyballPlayer> getPlayers() {
        return players;
    }
}
